package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IFakulteService;
import com.example.yemekhaneyonetimsistemi.controller.IFakulteController;
import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/fakulte")
@RestController
public class FakulteController implements IFakulteController {

    @Autowired
    IFakulteService fakulteService;
    @GetMapping("/GetAll")
    @Override
    public List<Fakulte> getAllFakulte() {
        return fakulteService.getAllFakulte();
    }
    @PatchMapping("/update/{id}")
    @Override
    public Fakulte updateFakulte(@PathVariable(name = "id") int id,@RequestBody Fakulte fakulte) {
        return fakulteService.updateFakulte(id, fakulte);
    }
    @PostMapping("/save")
    @Override
    public Fakulte insertFakulte(@RequestBody Fakulte fakulte) {
        return fakulteService.insertFakulte(fakulte);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public Fakulte deleteFakulte(@PathVariable(name = "id") int id) {
        return fakulteService.deleteFakulte(id);
    }
}
