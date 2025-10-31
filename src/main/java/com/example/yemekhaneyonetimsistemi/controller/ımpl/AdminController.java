package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IAdminService;
import com.example.yemekhaneyonetimsistemi.controller.IAdminController;
import com.example.yemekhaneyonetimsistemi.entity.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
