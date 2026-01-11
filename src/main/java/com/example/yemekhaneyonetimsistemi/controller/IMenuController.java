package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
