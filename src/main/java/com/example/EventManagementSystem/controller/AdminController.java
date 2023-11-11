package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        try {
            adminService.createAdmin(admin);
            return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdmin(@PathVariable int adminId) {
        Admin admin = adminService.find(adminId);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
