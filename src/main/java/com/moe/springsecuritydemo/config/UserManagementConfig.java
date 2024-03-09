package com.moe.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("moe")
                .password("123")
                .authorities("read")
                .build();

        UserDetails user2 = User.withUsername("test")
                .password("123")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user, user2);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
