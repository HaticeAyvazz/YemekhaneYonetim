package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IMenuService;
import com.example.yemekhaneyonetimsistemi.entity.Menu;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import com.example.yemekhaneyonetimsistemi.repository.IMenuRepository;
import com.example.yemekhaneyonetimsistemi.Repository.IYemekRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class MenuService implements IMenuService {


    private IMenuRepository menuRepository;
    private IYemekRepository yemekRepository;

    public MenuService(IMenuRepository menuRepository, IYemekRepository yemekRepository) {
        this.menuRepository = menuRepository;
        this.yemekRepository = yemekRepository;
    }


    @Override
    public List<Menu> getMenuList() {
        return menuRepository.findAll();
    }


    @Override
    public Menu createMenu(Integer menuId, List<Integer> yemekIds) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        List<Yemek> eklenecekYemekler = yemekIds.stream()
                .map(yemekId -> yemekRepository.findById(yemekId)
                        .orElseThrow(() -> new RuntimeException("Yemek not found with ID: " + yemekId)))
                .collect(Collectors.toList());

        menu.getYemekler().addAll(eklenecekYemekler);

        return menuRepository.save(menu);
    }


    @Override
    public void deleteMenu(Integer menuId) {
        menuRepository.deleteById(menuId);
    }


    @Override
    public Menu deleteFoodFromMenu(Integer menuId, List<Integer> yemekIds) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menu.getYemekler().removeIf(yemek -> yemekIds.contains(yemek.getYemekId()));

        return menuRepository.save(menu);
    }


    @Override
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




}
