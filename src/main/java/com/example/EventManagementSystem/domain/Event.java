package com.example.EventManagementSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Date scheduled_on;

    private int duration;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"eventList"})
    private Host host;


    @OneToMany(mappedBy = "event")
    @JsonIgnoreProperties({"eventList"})
    private List<Participant> participantList;


}
