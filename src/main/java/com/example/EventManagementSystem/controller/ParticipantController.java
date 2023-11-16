package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Participant;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.dto.CreateParticipantRequest;
import com.example.EventManagementSystem.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("/participant")
    public void createParticipant(@RequestBody @Valid CreateParticipantRequest createParticipantRequest) {
        participantService.createParticipant(createParticipantRequest.to());
    }

    // api for admin to check details of any Participant with Participant id
    @GetMapping("/participant-by-id/{id}")
    public Participant getParticipantById(@PathVariable("id") int id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        boolean isCalledByAdmin = securedUser.getAuthorities().stream().anyMatch(x -> "PARTICIPANT_INFO_BY_ADMIN".equals(x.getAuthority()));
        if (isCalledByAdmin) {
            return participantService.getParticipant(id);
        }
        else{
            throw new RuntimeException("User is not authorised");
        }

    }


    // api for Participant to check only their details
    @GetMapping("/participant")
    public Participant findParticipant() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        int participantId = securedUser.getParticipant().getId();
        return participantService.find(participantId);
    }
}
