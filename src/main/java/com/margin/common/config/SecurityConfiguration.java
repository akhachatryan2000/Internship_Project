package com.margin.common.config;

import com.margin.common.enums.UserRole;
import com.margin.common.security.filter.JWTAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private TokenService tokenService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admins").hasRole("ADMIN")
                .antMatchers("/customers").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/orders").hasRole("MANAGER")
                .antMatchers("/addresses").hasRole((UserRole.MANAGER.toString()))
                .antMatchers("/products").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/shops").hasAnyRole("ADMIN", "MANAGER")
                .anyRequest().authenticated().and()
                .exceptionHandling().accessDeniedPage("/login");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy
                .STATELESS).and().addFilterBefore(new JWTAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
//                .formLogin().loginPage("/auth/login").permitAll()
//                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }
}
