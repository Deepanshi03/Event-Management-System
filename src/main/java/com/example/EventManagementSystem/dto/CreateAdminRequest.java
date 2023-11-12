package com.example.EventManagementSystem.dto;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.domain.SecuredUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String username;
    private String password;

    public Admin to(){
        return Admin.builder()
                .name(this.name)
                .email(this.email)
                .securedUser(SecuredUser.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
    }
}