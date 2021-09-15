package com.margin.service.user.validator;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class UserHasPasswordValidator {

    public void userHasPasswordValidator(String password) {
        if (password == null) {
            throw new BadCredentialsException("User mast have password");
        }
    }
}
