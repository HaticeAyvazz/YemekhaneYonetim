package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yemekhaneyonetimsistemi.Service.IAdminService;
import com.example.yemekhaneyonetimsistemi.controller.IAdminController;
import com.example.yemekhaneyonetimsistemi.entity.Admin;

@RestController
@RequestMapping("/rest/api/admin")
public class AdminController implements IAdminController {

    private IAdminService adminService;

    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/list")
    @Override
    public List<Admin> getAllAdmin() {
        return adminService.getAll();
    }


    @PostMapping("/save")
    @Override
    public Admin insertAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Admin updateAdmin(@RequestBody Admin adminDetails,@PathVariable int id) {
        return adminService.updateAdmin(adminDetails, id);
    }

}
