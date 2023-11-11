package com.example.EventManagementSystem.repository;

import com.example.EventManagementSystem.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Integer> {
}
