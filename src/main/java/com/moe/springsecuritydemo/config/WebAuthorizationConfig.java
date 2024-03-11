package com.moe.springsecuritydemo.config;

import com.moe.springsecuritydemo.filter.RequestValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebAuthorizationConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(
                new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests(c -> c.anyRequest().permitAll());

        return http.build();
    }

}
