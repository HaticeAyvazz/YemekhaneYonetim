package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;

import java.util.List;

public interface IMenuService {

     List<Menu> getMenuList();

     Menu createMenu(Integer menuId,List<Integer> yemekIds);

     Menu createMenu(Menu menu);
     //Tüm menüyü silme işlemi
    void deleteMenu(Integer menuId);


    Menu deleteFoodFromMenu(Integer menuId,List<Integer>yemekIds);

     //Menü içindeki yemekleri günceller
     Menu updateMenu(Integer menuId,List<Integer> yemekIdsList);
     Menu updateFullMenu(Integer menuId, Menu yeniMenuVerileri);




}
