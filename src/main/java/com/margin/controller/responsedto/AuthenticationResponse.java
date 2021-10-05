package com.margin.controller.responsedto;

import lombok.Getter;

@Getter
public class AuthenticationResponse {

    private final String jwt;
    private String userRole;
    private String username;

    public AuthenticationResponse(String jwt, String userRole, String username) {
        this.jwt = jwt;
        this.userRole = userRole;
        this.username = username;
    }
}
