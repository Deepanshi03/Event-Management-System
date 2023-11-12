package com.example.EventManagementSystem.dto;

import com.example.EventManagementSystem.controller.ParticipantController;
import com.example.EventManagementSystem.domain.Participant;
import com.example.EventManagementSystem.domain.SecuredUser;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateParticipantRequest {

    private String username;
    private String password;
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
                .securedUser(SecuredUser.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
    }
}
