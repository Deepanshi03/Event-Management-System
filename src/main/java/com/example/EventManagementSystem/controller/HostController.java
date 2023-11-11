package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.dto.CreateHostRequest;
import com.example.EventManagementSystem.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/host")
    public void createHost(@RequestBody @Valid CreateHostRequest createHostRequest) {
        hostService.getOrCreateHost(createHostRequest.to());
    }

}
