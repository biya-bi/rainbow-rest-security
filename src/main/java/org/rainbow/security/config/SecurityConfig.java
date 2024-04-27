package org.rainbow.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Primary
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity httpSecurity, AuthenticationEntryPoint entryPoint)
            throws Exception {
        httpSecurity.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                .oauth2ResourceServer(customizer -> customizer.authenticationEntryPoint(entryPoint)
                        .jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }

}
