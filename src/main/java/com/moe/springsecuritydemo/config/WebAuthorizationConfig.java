package com.moe.springsecuritydemo.config;

import com.moe.springsecuritydemo.filter.StaticKeyAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebAuthorizationConfig {

    private final StaticKeyAuthenticationFilter filter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());

        http.authenticationProvider(authenticationProvider);

        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        return http.build();
    }

}
