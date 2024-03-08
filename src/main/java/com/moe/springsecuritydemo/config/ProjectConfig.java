package com.moe.springsecuritydemo.config;

import com.moe.springsecuritydemo.service.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @RequiredArgsConstructor
    public class ProjectConfig {

        private final CustomAuthenticationProvider authenticationProvider;

        @Bean
        SecurityFilterChain configure(HttpSecurity http) throws Exception {

            http.httpBasic(Customizer.withDefaults());

            http.authorizeHttpRequests(
                    c -> c.anyRequest().authenticated()
            );

            http.authenticationProvider(authenticationProvider);

            return http.build();
        }

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
