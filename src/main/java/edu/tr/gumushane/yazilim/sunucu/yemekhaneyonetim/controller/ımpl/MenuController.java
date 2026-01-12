package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IMenuService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.IMenuController;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/menu")
public class MenuController implements IMenuController {

    private IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping(path = "/list")
    @Override
    public List<Menu> getMenuList() {
        return menuService.getMenuList();
    }


    @PostMapping("/save/{menuId}/yemek-ekle")
    @Override
    public Menu createMenu(@PathVariable Integer menuId,@RequestBody List<Integer> yemekIds) {
        return menuService.createMenu(menuId,yemekIds);
    }

    @PostMapping("/save")
    @Override
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    @DeleteMapping("/deleteAll/{menuId}")
    @Override
    public void deleteAllMenu(@PathVariable Integer menuId) {
        menuService.deleteMenu(menuId);
    }


    @DeleteMapping("/delete/{menuId}/yemekler")
    @Override
    public ResponseEntity<Menu> deleteFoodFromMenu(@PathVariable Integer menuId, @RequestBody List<Integer> yemekIds) {
        Menu updatedMenuFood= menuService.deleteFoodFromMenu(menuId,yemekIds);

        return ResponseEntity.ok(updatedMenuFood);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Menu putUpdate(@PathVariable Integer menuId,@RequestBody Menu menu) {
        return menuService.updateFullMenu(menuId,menu);
    }

    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Menu patchUpdate(Integer menuId, List<Integer> yemekIdsList) {
        return menuService.updateMenu(menuId,yemekIdsList);
    }

}
