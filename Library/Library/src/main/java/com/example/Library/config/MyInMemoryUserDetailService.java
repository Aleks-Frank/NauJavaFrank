package com.example.Library.config;


import com.example.Library.entity.ROLE;
import com.example.Library.entity.UserEntity;
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
    private final List<UserEntity> users = new ArrayList<>();

    public MyInMemoryUserDetailService()
    {
        UserEntity user = new UserEntity("user", "123", Set.of(ROLE.USER));
        users.add(user);
        UserEntity admin = new UserEntity("admin", "admin", Set.of(ROLE.ADMIN));
        users.add(admin);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity appUser = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        if (appUser != null)
        {
            return new User(appUser.getUsername(), appUser.getPassword(), mapRoles(appUser));
        }
        else
        {
            throw new UsernameNotFoundException("user not found");
        }
    }


    private Collection<GrantedAuthority> mapRoles(UserEntity appUser)
    {
        return appUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" +
                        role.name())).collect(Collectors.toList());
    }
}

