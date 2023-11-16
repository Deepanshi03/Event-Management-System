package com.example.EventManagementSystem.service;

import com.example.EventManagementSystem.domain.Participant;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SecuredUserService securedUserService;
    public void createParticipant(Participant participant){
        SecuredUser securedUser = participant.getSecuredUser();
        securedUser = securedUserService.save(securedUser, "PARTICIPANT_USER"); // pass user object and type of user, type of user will be used to assign the authorities correctly
        participant.setSecuredUser(securedUser);  // set secured User, at this point we also be having the id of secured user
        participantRepository.save(participant);
    }


    public Participant getParticipant(int id)
    {
        return participantRepository.findById(id).orElse(null);
    }

    public Participant find(int participantId)
    {
        return participantRepository.findById(participantId).orElse(null);
    }

}
