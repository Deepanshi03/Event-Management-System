package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.dto.CreateAdminRequest;
import com.example.EventManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping("/admin")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        adminService.createAdmin(createAdminRequest.to());
    }

}
