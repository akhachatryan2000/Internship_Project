package com.margin.common.security.filter;

import lombok.AllArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//    private final AuthenticationManager authenticationManager;
//
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        username="u";
//        password = "p";
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        return authenticationManager.authenticate(token);
//    }

//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        User authenticatedUser = (User) authResult.getPrincipal();
//        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
//        String accessToken = JWT.create()
//                .withSubject(getUsernameParameter());
//    }
}
