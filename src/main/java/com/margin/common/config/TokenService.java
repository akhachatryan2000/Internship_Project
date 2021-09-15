package com.margin.common.config;

import com.margin.repository.token.AccessTokenEntity;
import com.margin.repository.token.TokenRepository;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TokenService {

    private final String secretKey = "secretkey";

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
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
            return bearerToken.substring(7); //returns the token
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
        String createdToken = createToken(claims, username); // subject is the username
        return createdToken;
    }

    private String createToken(Map<String, Object> claims, String subject) {
        try {
            Instant issuedAt = Instant.now();
            Instant expiration = issuedAt.plus(3, ChronoUnit.MINUTES);
            JwtBuilder token = Jwts.builder().setClaims(claims).setSubject(subject)
                    .setIssuedAt(Date.from(issuedAt))
                    .setExpiration(Date.from(expiration))
                    .signWith(SignatureAlgorithm.HS256, secretKey);
            return token.compact();
        } catch (ExpiredJwtException ex) {
            ex.getMessage();
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails user = userDetailsService.loadUserByUsername(extractUsername(token));
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
        System.out.println(authentication.toString());
        return authentication;
    }

    public Boolean tokenIsExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    public void saveToken(String token) {
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setToken(token);
        tokenRepository.save(accessTokenEntity);
    }


    //
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && tokenIsExpired(token));
    }

//    public Boolean validateToken(String token) {
//        try {
//            Claims claims = (Claims) Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new TokenExpiredException("Token is invalid");
//        }
}

