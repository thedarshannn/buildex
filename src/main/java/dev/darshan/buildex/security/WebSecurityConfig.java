package dev.darshan.buildex.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionconfig -> sessionconfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/api/v1/**").permitAll()
                );

        return httpSecurity.build();
    }
}
