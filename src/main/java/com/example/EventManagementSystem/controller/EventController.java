package com.example.EventManagementSystem.controller;

import com.example.EventManagementSystem.domain.Event;
import com.example.EventManagementSystem.dto.CreateEventRequest;
import com.example.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @PostMapping("/event")
    public void createEvent(@RequestBody @Valid CreateEventRequest createEventRequest){
        eventService.createEvent(createEventRequest.to());
    }
    @GetMapping("/event")
    public List<Event> searchEvent(@RequestParam("key") String key, @RequestParam("value") String value){

        return eventService.find(key, value);
    }
}
