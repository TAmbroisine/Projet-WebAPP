package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.AdminDto;
import com.takima.backskeleton.models.Admin;
import com.takima.backskeleton.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("administrator")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping("")
    public List<Admin> listAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteById(id);
    }

    @PostMapping("")
    public void addAdmin(@RequestBody AdminDto adminDto) {
        adminService.addAdmin(adminDto);
    }

    @PostMapping("/{id}")
    public void updateAdmin(@RequestBody AdminDto adminDto, @PathVariable Long id) {
        adminService.updateAdmin(adminDto, id);
    }
}

