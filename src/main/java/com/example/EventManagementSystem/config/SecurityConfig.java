package com.example.EventManagementSystem.config;

import com.example.EventManagementSystem.service.SecuredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Deprecated
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecuredUserService securedUserService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securedUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .csrf().disable()// disabling the csrf token otherwise will wet 403 error, i.e. cross site forgery error
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/participant/**").hasAuthority("PARTICIPANT_SELF_INFO")
                .antMatchers(HttpMethod.GET, "/participant-by-id/**").hasAuthority("PARTICIPANT_INFO_BY_ADMIN")
                .antMatchers(HttpMethod.POST, "/admin/**").hasAnyAuthority("PARTICIPANT_INFO_BY_ADMIN","CREATE_ADMIN_AUTHORITY","CREATE_EVENT_BY_ADMIN")
                .antMatchers(HttpMethod.POST, "/participant/**").permitAll()
                .and()
                .formLogin();
    }
}
