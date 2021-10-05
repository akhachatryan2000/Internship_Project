package com.margin.common.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationManager implements org.springframework.security.authentication.AuthenticationManager {

    private CustomAuthenticationProvider authenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authenticationProvider.authenticate(authentication);
    }
}
