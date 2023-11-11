package com.example.EventManagementSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "host") // This is the back reference. In database we will not be storing bookList coresponding to a author. To internally executes the queries and findout the list of books corresponding to a autor we need to map back-refrence (my_author is the field name in Book class) from Book entity. Otherwise bookList will be null as we are not stroing list of books in Author table.
    @JsonIgnoreProperties({"host"})
    private List<Event> eventList;

}
