package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.controller.IYemekController;
import com.example.yemekhaneyonetimsistemi.Service.IYemekService;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/yemek")
@RestController
public class YemekController implements IYemekController {

    @Autowired
    IYemekService iYemekService;

    @GetMapping("/get")
    @Override
    public List<Yemek> getYemek() {
        return iYemekService.getAllYemek();
    }

    @PatchMapping("/update/{id}")
    @Override
    public Yemek updateYemek(@PathVariable(name = "id", required = true) int id, @RequestBody Yemek yemek) {
        return iYemekService.updateYemek(id, yemek);
    }

    @PostMapping("/save")
    @Override
    public Yemek insertYemek(@RequestBody Yemek yemek) {
        return iYemekService.insertYemek(yemek);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public Yemek deleteYemek(@PathVariable int id) {
        return iYemekService.deleteYemek(id);
    }
}