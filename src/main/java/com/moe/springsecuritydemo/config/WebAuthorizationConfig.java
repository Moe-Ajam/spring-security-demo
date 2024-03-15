package com.moe.springsecuritydemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebAuthorizationConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf(
                c->c.disable()
        );

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(
                c -> c.requestMatchers(HttpMethod.GET, "/a")
                        .authenticated()
                        .requestMatchers(HttpMethod.POST, "/a")
                        .permitAll()
                        .anyRequest()
                        .denyAll()
        );

        return http.build();
    }

}
