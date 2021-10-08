package com.margin.controller.authentication;

import com.margin.common.config.AuthenticationManager;
import com.margin.common.config.TokenService;
import com.margin.common.config.UserDetailsServiceImpl;
import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.requestdto.AuthenticationRequest;
import com.margin.controller.responsedto.AuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {

    private UserDetailsServiceImpl userDetailsService;

    private TokenService tokenService;

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
                (new AuthenticationResponse(jwt, userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()), userDetails.getUsername()), null);
    }


    @PostMapping("/sign-out")
    public GenericResponse<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new GenericResponse<>("You have successfully logged out", null);
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "Access Denied";
    }
}
