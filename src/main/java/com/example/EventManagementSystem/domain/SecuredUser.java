package com.example.EventManagementSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecuredUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String authorities;
    private static final String DELIMITER = "::";

    @OneToOne(mappedBy = "securedUser")   // there will be one to one mapping between SecuredUser and participant as one SecuredUser can be one student
    @JsonIgnoreProperties({"securedUser"})
    private Participant participant; // user id will be foreign key in participant table

    @OneToOne(mappedBy = "securedUser")   // there will be one to one mapping between user and admin as one user can be one admin
    @JsonIgnoreProperties({"securedUser"})
    private Admin admin;   // user id will be foreign key in Admin table

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authorities = this.authorities.split(DELIMITER);
        return Arrays.stream(authorities)
                .map(authoritie -> new SimpleGrantedAuthority(authoritie))  // SimpleGrantedAuthority is a class that is implementing GrantedAuthority
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
