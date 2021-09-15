package com.margin.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}


//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        byte[] seed = "salt".getBytes();
//        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, new SecureRandom(seed));
//    }
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        String encoded = bCryptPasswordEncoder().encode(rawPassword);
//        return encoded;
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        String encoded = encode(rawPassword);
//        if (encoded.equals(encodedPassword)) {
//            return true;
//        }
//        return false;
