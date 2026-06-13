package com.krakedev.proyectos.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.krakedev.proyectos.entidades.Usuario;
import com.krakedev.proyectos.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario registrar(Usuario usuario) {
		String contrasena = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(contrasena);
		return usuarioRepository.save(usuario);
	}
	
	public boolean autenticarUsuario(String username, String password ) {
		Optional<Usuario> usuarioOtp = usuarioRepository.findByUsername(username);
		if(usuarioOtp.isPresent()) {
			Usuario usuario = usuarioOtp.get();
			if(BCrypt.checkpw(password,usuario.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
