package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Event;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.dto.CreateEventRequest;
import com.example.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;
    @PostMapping("/event")
    public void createEvent(@RequestBody @Valid CreateEventRequest createEventRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        boolean isCalledByAdmin =  securedUser.getAuthorities().stream().anyMatch(x-> "CREATE_EVENT_BY_ADMIN".equals(x.getAuthority()));
        if(isCalledByAdmin) {
            eventService.createEvent(createEventRequest.to());
        }
        else{
            throw new RuntimeException("User is not authorised");
        }

    }

    // In place of defining multiple get requests, below method will work with all the parameters with which we want to search
    @GetMapping("/search-event")
    public List<Event> searchEvent(@RequestParam("key") String key, @RequestParam("value") String value){

        return eventService.find(key, value);
    }
}
