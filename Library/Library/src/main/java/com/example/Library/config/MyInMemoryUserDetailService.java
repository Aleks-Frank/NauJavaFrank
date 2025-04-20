package com.example.Library.config;


import com.example.Library.entity.ROLE;
import com.example.Library.entity.UserEntity;
import com.example.Library.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyInMemoryUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

//    @PostConstruct
//    public void init()
//    {
//        UserEntity user = new UserEntity("user", "123", Set.of(ROLE.USER));
//        userService.saveUser(user);
//        UserEntity admin = new UserEntity("admin", "admin", Set.of(ROLE.ADMIN));
//        userService.saveUser(admin);
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        try {
            return userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }


    private Collection<GrantedAuthority> mapRoles(UserEntity appUser)
    {
        return appUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" +
                        role.name())).collect(Collectors.toList());
    }
}

