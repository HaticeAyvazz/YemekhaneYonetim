package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Menu;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMenuController {

     List<Menu> getMenuList();

     Menu createMenu(Integer menuId,List<Integer> yemekIds);

     Menu createMenu(Menu menu);
     void deleteAllMenu(Integer menuId);

    ResponseEntity<Menu>deleteFoodFromMenu(Integer menuId, List<Integer> yemekIds);

    Menu updateMenu(Integer menuId,List<Integer> yemekIdsList);



}
