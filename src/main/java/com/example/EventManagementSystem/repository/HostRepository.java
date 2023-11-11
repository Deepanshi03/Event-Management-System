package com.example.EventManagementSystem.repository;


import com.example.EventManagementSystem.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Integer> {
    Host findByEmail(String email);
}
