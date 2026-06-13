package com.krakedev.proyectos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	private final JwtAuthenticatorFilter jwtAutenticationFilter;

	public SecurityConfig(JwtAuthenticatorFilter jwtAutenticationFilter) {
		super();
		this.jwtAutenticationFilter = jwtAutenticationFilter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(sessions -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/registrar", "/api/auth/login").permitAll()
						.anyRequest().authenticated())
				.addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
	}
	
	
}
