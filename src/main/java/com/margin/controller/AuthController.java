package com.margin.controller;

import com.margin.common.config.*;
import com.margin.common.exception.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RequestMapping
@RestController
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;


    @PostMapping("/login")
    public GenericResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        if (request.getUsername() == null || request.getPassword() == null) {
            throw new BadCredentialsException("Credentials must not be null");
        }
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = tokenService.generateToken(request.getUsername(), userDetails.getAuthorities()
                .stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList()));
        return new GenericResponse<>
                (new AuthenticationResponse(jwt, userDetails.getAuthorities().toString(), userDetails.getUsername()), null);
    }
}
