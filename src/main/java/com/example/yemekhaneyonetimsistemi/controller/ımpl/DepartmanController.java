package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IDepartmanService;
import com.example.yemekhaneyonetimsistemi.controller.IDepartmanController;
import com.example.yemekhaneyonetimsistemi.entity.Departman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/departman")
@RestController
public class DepartmanController implements IDepartmanController {

    @Autowired
    IDepartmanService iDepartmanService;

    @GetMapping("/getAll")
    @Override
    public List<Departman> getAllDepartman() {
        return iDepartmanService.getAllDepartman();
    }

    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Departman patchUpdate(@PathVariable(name = "id") int id,@RequestBody Departman departman) {
        return iDepartmanService.partialUpdate(id, departman);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Departman putUpdate(@PathVariable int id,@RequestBody Departman departman) {
        return iDepartmanService.fullUpdate(id,departman);
    }

    @PostMapping("/save")
    @Override
    public Departman insertDepartman(@RequestBody Departman departman) {
        return iDepartmanService.insertDepartman(departman);
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public Departman deleteDepartman(@PathVariable(name = "id") int id) {
        return iDepartmanService.deleteDepartman(id);
    }
}
