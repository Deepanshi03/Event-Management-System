package com.example.EventManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderConfig {
    @Bean
    PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
