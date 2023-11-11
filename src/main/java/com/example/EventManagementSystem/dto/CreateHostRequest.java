package com.example.EventManagementSystem.dto;

import com.example.EventManagementSystem.domain.Host;

import javax.validation.constraints.NotBlank;

public class CreateHostRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    public Host to() {
        return Host.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}
