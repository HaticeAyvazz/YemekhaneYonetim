package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMenuController {

     List<Menu> getMenuList();

     Menu createMenu(Integer menuId,List<Integer> yemekIds);

     Menu createMenu(Menu menu);
     void deleteAllMenu(Integer menuId);

    ResponseEntity<Menu>deleteFoodFromMenu(Integer menuId, List<Integer> yemekIds);

    Menu putUpdate(Integer menuId,Menu menu);
    Menu patchUpdate(Integer menuId,List<Integer> yemekIdsList);



}
