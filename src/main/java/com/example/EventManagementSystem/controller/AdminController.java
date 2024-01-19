package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.dto.CreateAdminRequest;
import com.example.EventManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/admin")
    public Admin findAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        int adminId = securedUser.getAdmin().getId();
        return adminService.find(adminId);
    }

}


// Controller for Admin