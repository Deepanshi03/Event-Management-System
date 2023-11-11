package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Participant;
import com.example.EventManagementSystem.dto.CreateParticipantRequest;
import com.example.EventManagementSystem.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    @PostMapping("/participant")
    public void createParticipant(@RequestBody @Valid CreateParticipantRequest createParticipantRequest){
        participantService.createParticipant(createParticipantRequest.to());
    }

    @GetMapping("/participant")
    public Participant getParticipantById(@RequestParam("id") int id){
        return participantService.getParticipant(id);
    }
}
