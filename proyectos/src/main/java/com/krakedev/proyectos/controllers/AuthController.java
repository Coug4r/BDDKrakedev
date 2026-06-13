package com.krakedev.proyectos.controllers;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krakedev.proyectos.entidades.Usuario;
import com.krakedev.proyectos.repositories.UsuarioRepository;
import com.krakedev.proyectos.security.JwtUtil;
import com.krakedev.proyectos.services.TokenBlackList;
import com.krakedev.proyectos.services.UsuarioService;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
	private static final Logger logger = LogManager.getLogger(UsuarioService.class);
	private final UsuarioRepository usuarioRepository;
	private final UsuarioService usuarioService;
	private final TokenBlackList blacklist;
	public AuthController(UsuarioRepository usuarioRepository, UsuarioService usuarioService, TokenBlackList blacklist) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuarioService = usuarioService;
		this.blacklist = blacklist;
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Usuario usuario){
		try {
			Usuario nuevoUsuario = usuarioService.registrar(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
		}catch(Exception e) {
			logger.error("Error al registrar usuario "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el Usuario!");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales){
		String username = credenciales.get("username");
		String password = credenciales.get("password");
		boolean autenticador = usuarioService.autenticarUsuario(username, password);
		if(autenticador) {
			Usuario usuario = usuarioRepository.findByUsername(username).get();
			String token = JwtUtil.generarToken(usuario.getUsername(), usuario.getRol());
			return ResponseEntity.ok(Map.of("token",token));
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos!");
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(@RequestHeader(value = "Authorization", required = false) String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
			blacklist.invalidarToken(token);
			return ResponseEntity.ok(Map.of("Mensaje: ", "Sesion cerrada exitosamente token invalidado!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error con el token!");
		}
	}
	
	@GetMapping("/perfil")
	public ResponseEntity<?> perfil(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String usuario = auth.getName();
		String rol = auth.getAuthorities().iterator().next().getAuthority();
		
		return ResponseEntity.ok(Map.of(
				"Mensaje:", "Bienvenido al sistema protegido por spring Security",
				"Usuario:",usuario,
				"rol_detectado:", rol,
				"Status:", "Autenticado exitosamente!"
				));
	}
}
