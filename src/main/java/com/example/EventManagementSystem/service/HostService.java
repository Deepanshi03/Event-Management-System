package com.example.EventManagementSystem.service;

import com.example.EventManagementSystem.domain.Host;
import com.example.EventManagementSystem.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public Host getOrCreateHost(Host host) {
        Host retrievedHost = hostRepository.findByEmail(host.getEmail());
        if (retrievedHost == null) {
            return hostRepository.save(host);
        }
        return retrievedHost;
    }

    public Host find(int hostId) {
        Optional<Host> optionalHost = hostRepository.findById(hostId);
        return optionalHost.orElse(null);
    }

}
