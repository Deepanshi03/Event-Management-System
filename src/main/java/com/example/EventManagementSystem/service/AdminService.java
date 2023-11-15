package com.example.EventManagementSystem.service;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SecuredUserService securedUserService;
    public void createAdmin(Admin admin){
        SecuredUser securedUser = admin.getSecuredUser();
        securedUser = securedUserService.save(securedUser, "ADMIN_USER");
        admin.setSecuredUser(securedUser);
        adminRepository.save(admin);
    }

    public Admin getAdmin(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin find(int adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }
}
