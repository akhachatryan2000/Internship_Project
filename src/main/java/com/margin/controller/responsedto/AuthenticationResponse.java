package com.margin.controller.responsedto;

import lombok.Getter;

import java.util.List;

@Getter
public class AuthenticationResponse {

    private final String jwt;
    private final List<String> userRole;
    private final String username;

    public AuthenticationResponse(String jwt, List<String> userRole, String username) {
        this.jwt = jwt;
        this.userRole = userRole;
        this.username = username;
    }
}
