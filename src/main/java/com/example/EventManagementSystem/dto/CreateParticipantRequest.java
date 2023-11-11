package com.example.EventManagementSystem.dto;

import com.example.EventManagementSystem.controller.ParticipantController;
import com.example.EventManagementSystem.domain.Participant;

import javax.validation.constraints.NotBlank;

public class CreateParticipantRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private int age;

    public Participant to(){
        return Participant.builder()
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .build();
    }
}
