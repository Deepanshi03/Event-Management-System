package com.example.EventManagementSystem.repository;

import com.example.EventManagementSystem.domain.SecuredUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SecuredUserRepository extends JpaRepository<SecuredUser, Integer> {
    SecuredUser findByUsername(String name);
}
