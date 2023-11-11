package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Host;
import com.example.EventManagementSystem.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    @Autowired
    private HostService hostService;
    @PostMapping
    public ResponseEntity<String> createHost(@RequestBody Host host) {
        try {
            hostService.getOrCreateHost(host);
            return new ResponseEntity<>("Host created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{hostId}")
    public ResponseEntity<Host> getHost(@PathVariable int hostId) {
        Host host = hostService.find(hostId);
        if (host != null) {
            return new ResponseEntity<>(host, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
