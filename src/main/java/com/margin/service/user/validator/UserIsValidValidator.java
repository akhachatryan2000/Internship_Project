package com.margin.service.user.validator;

import com.margin.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIsValidValidator {

    private UserRepository userRepository;

    public void userIsValid(String password, String username) {
        checkUsernameValidity(username);
        userHasPasswordValidator(password);
    }

    public void userIsValid(String username) {
        checkUsernameValidity(username);
    }

    private void checkUsernameValidity(String username) {
        userHasUsernameValidator(username);
        usernameIsUnique(username);
    }


    private void userHasUsernameValidator(String username) {
        if (username == null || username.isBlank()) {
            throw new BadCredentialsException("User must have username");
        }
    }

    private void userHasPasswordValidator(String password) {
        if (password == null) {
            throw new BadCredentialsException("User mast have password");
        }
    }

    private void usernameIsUnique(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new BadCredentialsException("Username already exists");
        }
    }
}
