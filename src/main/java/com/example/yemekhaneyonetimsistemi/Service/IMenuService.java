package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Menu;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IMenuService {

     List<Menu> getMenuList();

     Menu createMenu(Integer menuId,List<Integer> yemekIds);

     //Tüm menüyü silme işlemi
    void deleteMenu(Integer menuId);

    //Menüde seçili olan yemekleri silme
     Menu deleteFoodFromMenu(Integer menuId,List<Integer>yemekIds);

     //Menü içindeki yemekleri günceller
     Menu updateMenu(Integer menuId,List<Integer> yemekIdsList);





}
