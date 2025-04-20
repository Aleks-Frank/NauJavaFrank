package com.example.Library.config;

import com.example.Library.entity.ROLE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        return security
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/book").hasRole(ROLE.ADMIN.name())
                        .requestMatchers("/book/create").hasRole(ROLE.ADMIN.name())
                        .requestMatchers("/book/edit/{id}").hasRole(ROLE.ADMIN.name())
                        .requestMatchers("/book/edit").hasRole(ROLE.ADMIN.name())
                        .requestMatchers("/book/delete/{id}").hasRole(ROLE.ADMIN.name())
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
