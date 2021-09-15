package com.margin.service.user.validator;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class UserHasUsernameValidator {

    public void userHasUsernameValidator(String username) {
        if (username == null) {
            throw new BadCredentialsException("User must hav username");
        }
    }
}
