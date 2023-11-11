package com.example.EventManagementSystem.service;

import com.example.EventManagementSystem.domain.Event;
import com.example.EventManagementSystem.domain.Genre;
import com.example.EventManagementSystem.domain.Host;
import com.example.EventManagementSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private HostService hostService;
    @Autowired
    private EventRepository eventRepository;
    public void createEvent(Event event){

        Host eventHost = event.getHost(); // here bookAuthor will not be having id and other auto generated fields
        Host savedHost = hostService.getOrCreateHost(eventHost); // now it will be having all the fields

        // map author to book
        event.setHost(savedHost);
        eventRepository.save(event);

    }

    public List<Event> find(String key, String value) {
        switch (key) {
            case "id":
                Optional<Event> event = eventRepository.findById(Integer.parseInt(value));
                if(event.isPresent()){
                    return Arrays.asList(event.get());
                }
                else {
                    return new ArrayList<>(); // empty list
                }
            case "genre":
                return eventRepository.findByGenre(Genre.valueOf(value));
            case "host_name":
                return eventRepository.findByHost_name(value);
            case "name":
                return eventRepository.findByName(value);
            default:
                throw new RuntimeException("Search key not value: "+key);
        }
    }

}
