package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Participant;
import com.example.EventManagementSystem.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    @PostMapping
    public ResponseEntity<String> createParticipant(@RequestBody Participant participant) {
        try {
            participantService.createParticipant(participant);
            return new ResponseEntity<>("Participant created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{participantId}")
    public ResponseEntity<Participant> getParticipant(@PathVariable int participantId) {
        Participant participant = participantService.find(participantId);
        if (participant != null) {
            return new ResponseEntity<>(participant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
