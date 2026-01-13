package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IRezervasyonRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IMenuService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Yemek;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IMenuRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IYemekRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class MenuService implements IMenuService {

    private final IRezervasyonRepository rezervasyonRepository;
    private IMenuRepository menuRepository;
    private IYemekRepository yemekRepository;

    public MenuService(IMenuRepository menuRepository, IRezervasyonRepository rezervasyonRepository, IYemekRepository yemekRepository) {
        this.menuRepository = menuRepository;
        this.rezervasyonRepository = rezervasyonRepository;
        this.yemekRepository = yemekRepository;
    }

    @Override
    public List<Menu> getMenuList() {
        return menuRepository.getAll();
    }


    @Override
    @Transactional
    public Menu createMenu(Menu menu) {
       if(menu==null){
           throw new IllegalArgumentException("Menu cannot be null");
       }
        return  menuRepository.save(menu);
    }

    @Override
    @Transactional
    public Menu createMenu(Integer menuId, List<Integer> yemekIds) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu Not Found"));

        List<Yemek> eklenecekYemekler = yemekIds.stream()
                .map(yemekId -> yemekRepository.findById(yemekId)
                        .orElseThrow(() -> new RuntimeException("Yemek Not Found")))
                .collect(Collectors.toList());

        menu.getYemekler().addAll(eklenecekYemekler);

        return menuRepository.save(menu);
    }


    @Override
    @Transactional
    public void deleteMenu(Integer menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu bulunamadı"));

        //Menü silinmeden önce rezervasyonlardaki menü bağını kopar
        List<Rezervasyon> bagliRezervasyonlar = rezervasyonRepository.findByMenu(menu);
        for (Rezervasyon rez : bagliRezervasyonlar) {
            rez.setMenu(null); // Menu referansını null yapıyoruz
        }

        menu.getYemekler().clear();

        menuRepository.deleteById(menuId);
    }



    @Override
    @Transactional
    public Menu deleteFoodFromMenu(Integer menuId, List<Integer> yemekIds) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menu.getYemekler().removeIf(yemek -> yemekIds.contains(yemek.getYemekId()));

        return menuRepository.save(menu);
    }


    @Override
    @Transactional
    public Menu updateMenu(Integer menuId, List<Integer> yemekIdList) {
        Menu guncelMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with ID: " + menuId));

            List<Yemek> newFoodList = yemekIdList.stream()
                    .map(id -> yemekRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Food not found")))
                    .collect(Collectors.toList());

            guncelMenu.setYemekler(newFoodList);
            return menuRepository.save(guncelMenu);
        }



    @Override
    @Transactional
    public Menu updateFullMenu(Integer menuId, Menu yeniMenuVerileri) {

        Menu mevcutMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        mevcutMenu.setTarih(yeniMenuVerileri.getTarih());
        mevcutMenu.setGuncellenmeTarihi(yeniMenuVerileri.getGuncellenmeTarihi());

        //Cascade bozmadan ilişki yönetimi
        if (yeniMenuVerileri.getYemekler() != null) {
            List<Yemek> yonetilenYemekler = new ArrayList<>();

            for (Yemek y : yeniMenuVerileri.getYemekler()) {
                Yemek managedYemek = yemekRepository.findById(y.getYemekId())
                        .orElseThrow(() -> new RuntimeException("Yemek ID bulunamadı: " + y.getYemekId()));
                yonetilenYemekler.add(managedYemek);
            }

            // Mevcut listeyi temizleyip yönetilen nesneleri ekliyoruz
            mevcutMenu.getYemekler().clear();
            mevcutMenu.getYemekler().addAll(yonetilenYemekler);
        }

        return menuRepository.save(mevcutMenu);
    }





}
