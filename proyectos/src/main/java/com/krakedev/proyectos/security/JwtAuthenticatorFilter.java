package com.krakedev.proyectos.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.krakedev.proyectos.services.TokenBlackList;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticatorFilter extends OncePerRequestFilter{
	private final TokenBlackList blaclist;

	public JwtAuthenticatorFilter(TokenBlackList blaclist) {
		super();
		this.blaclist = blaclist;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader = request.getHeader("Authorization");
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
		}
		String token = authHeader.substring(7);
		if(blaclist.estaInvalidado(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Acceso denegado sesion cerrada!");
			return;
		}
		DecodedJWT datosToken = JwtUtil.validarToken(token);
		if(datosToken!=null) {
			String username = datosToken.getSubject();
			String rol = datosToken.getClaim("rol").asString();
			String rolSpring = "ROLE_"+ rol;
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(rolSpring);
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, Collections.singleton(authority));
			SecurityContextHolder.getContext().setAuthentication(authentication); 
		}
		
		filterChain.doFilter(request, response);
	}
	
	
}
