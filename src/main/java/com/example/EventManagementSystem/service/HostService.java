package com.example.EventManagementSystem.service;

import com.example.EventManagementSystem.domain.Host;
import com.example.EventManagementSystem.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;
    public Host getOrCreateHost(Host host){

        Host retrievedAuthor = hostRepository.findByEmail(host.getEmail());
        if(retrievedAuthor == null) {
            return hostRepository.save(host);
        }
        return retrievedAuthor;
    }

}
