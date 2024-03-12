package com.moe.springsecuritydemo.config;

import com.moe.springsecuritydemo.filter.StaticKeyAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebAuthorizationConfig {

    private final StaticKeyAuthenticationFilter filter;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.addFilterAt(filter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());

        return http.build();
    }

}
