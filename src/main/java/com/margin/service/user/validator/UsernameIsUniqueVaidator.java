package com.margin.service.user.validator;

import com.margin.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class UsernameIsUniqueVaidator {

    @Autowired
    private UserRepository userRepository;

    public void usernameIsUnique(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new BadCredentialsException("Username already exists");
        }
    }
}
