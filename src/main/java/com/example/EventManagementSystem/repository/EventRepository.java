package com.example.EventManagementSystem.repository;

import com.example.EventManagementSystem.domain.Event;
import com.example.EventManagementSystem.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

    List<Event> findByGenre(Genre genre);
    List<Event> findByName(String eventName);
    @Query("select e from Event e, Host h where e.host.id = h.id and h.name = ?1")
    List<Event> findByHost_name(String hostName);

}
