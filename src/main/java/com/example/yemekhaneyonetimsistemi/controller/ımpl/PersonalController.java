package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IPersonalService;
import com.example.yemekhaneyonetimsistemi.controller.IPersonalController;
import com.example.yemekhaneyonetimsistemi.entity.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/personal")
public class PersonalController implements IPersonalController {

    IPersonalService personalService;

    public PersonalController(IPersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/list")
    @Override
    public List<Personel> getAllPersonal() {
        return personalService.getAllPersonal();
    }


    @PostMapping("/save")
    @Override
    public Personel insertPersonal(@RequestBody Personel personel) {
        return  personalService.insertPersonal(personel);
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public void deletePersonal(@PathVariable int id) {
        personalService.deletePersonal(id);
    }


    @PutMapping("/update/{id}")
    @Override
    public Personel updatePersonal(@RequestBody Personel personalDetails, @PathVariable Integer id) {
        return personalService.updatePersonal(personalDetails, id);
    }

}
