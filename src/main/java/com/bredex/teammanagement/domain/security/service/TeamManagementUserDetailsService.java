package com.bredex.teammanagement.domain.security.service;

import com.bredex.teammanagement.domain.security.entity.TeamManagementUser;
import com.bredex.teammanagement.domain.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TeamManagementUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TeamManagementUser teamManagementUser = userRepository.findById(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));


        return new User(username, teamManagementUser.getPassword(),
                teamManagementUser.getRoles().stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }

}
