package com.margin.common.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class TokenService {
    private final String secretKey = "secretkey";

    private UserDetailsServiceImpl userDetailsService;


    public String extractUsername(String token) {
        String username = extractClaim(token, Claims::getSubject);
        return username;
    }

    public Date extractExpirationDate(String token) {
        Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration;
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims;
    }

    public String generateToken(String username, Collection<SimpleGrantedAuthority> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("roles", roles.toString());
        String createdToken = createToken(claims, username);
        return createdToken;
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Instant issuedAt = Instant.now();
        Instant expiration = issuedAt.plus(15, ChronoUnit.MINUTES);
        JwtBuilder token = Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(Date.from(issuedAt))
                .setExpiration(Date.from(expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey);
        return token.compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails user = userDetailsService.loadUserByUsername(extractUsername(token));
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
        return authentication;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }
}

