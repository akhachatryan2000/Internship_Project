package com.margin.common.config;

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

    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                cors().and()
                .authorizeRequests()
                .antMatchers("/sign-out").permitAll()
                .antMatchers("/admins/**").hasAuthority("ADMIN")
                .antMatchers("/customers/**").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/customers/create").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/customers/:id/update").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/customers/:id/delete").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/orders/**").hasAnyAuthority("MANAGER", "ADMIN", "DRIVER")
//                .antMatchers("/orders/create").hasAnyAuthority("MANAGER", "ADMIN")
//                .antMatchers("/orders/:id/update").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("orders/:id/delete").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/addresses/**").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/addresses/create").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/addresses/:id/update").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/addresses/:id/delete").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/products/**").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("/products/create").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("products/:id/update").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("products/:id/delete").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("shops/:id/delete").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("shops/:id/update").hasAnyAuthority("ADMIN", "MANAGER")
//                .antMatchers("shops/create").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/shops/**").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/users/**").hasAnyAuthority("ADMIN")
//                .antMatchers("/users/create").hasAnyAuthority("ADMIN")
//                .antMatchers("/users/:id/update").hasAnyAuthority("ADMIN")
//                .antMatchers("/users/:id/delete").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated().and()
//                .logout(logout->logout
//                        .logoutUrl("/logout")
//                )
                //.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().and()
                .exceptionHandling().accessDeniedPage("/access-denied");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy
                .STATELESS).and().addFilterBefore(new JWTAuthenticationFilter(tokenService, userDetailsService), UsernamePasswordAuthenticationFilter.class);
//                .formLogin().loginPage("/auth/login").permitAll()
//                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }
}
