package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IFakulteService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.IFakulteController;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Fakulte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/fakulte")
@RestController
public class FakulteController implements IFakulteController {

    @Autowired
    IFakulteService fakulteService;

    @GetMapping("/getAll")
    @Override
    public List<Fakulte> getAllFakulte() {
        return fakulteService.getAllFakulte();
    }

    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Fakulte patchUpdate(@PathVariable(name = "id") int id,@RequestBody Fakulte fakulte) {
        return fakulteService.partialUpdate(id, fakulte);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Fakulte putUpdate(@PathVariable int id,@RequestBody Fakulte fakulte) {
        return fakulteService.fullUpdate(id,fakulte);
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
