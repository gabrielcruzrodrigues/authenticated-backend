package com.gabriel.authenticatebackend.services;

import com.gabriel.authenticatebackend.model.ApplicationUser;
import com.gabriel.authenticatebackend.model.Role;
import com.gabriel.authenticatebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    //3° search user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("in the user details service");
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found!"));
    }
}
