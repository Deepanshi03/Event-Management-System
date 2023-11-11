package com.example.EventManagementSystem.dto;

import com.example.EventManagementSystem.domain.Event;
import com.example.EventManagementSystem.domain.Genre;
import com.example.EventManagementSystem.domain.Host;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEventRequest {

    @NotBlank
    private String name;
    @NotNull
    private Genre genre;
    @NotBlank
    private String hostName;
    @NotBlank
    private String hostEmail;

    public Event to(){
        return Event.builder()
                .name(this.name)
                .genre(this.genre)
                .host(
                        Host.builder()
                                .name(this.hostName)
                                .email(this.hostEmail)
                                .build()
                )
                .build();
    }
}
