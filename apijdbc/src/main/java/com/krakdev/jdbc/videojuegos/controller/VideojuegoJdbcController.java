package com.krakdev.jdbc.videojuegos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.jdbc.videojuegos.services.ServicioVideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;
@RestController
@RequestMapping("/videojuego")
public class VideojuegoJdbcController {
	private final ServicioVideojuegoJdbc servicio;
	
	public VideojuegoJdbcController(ServicioVideojuegoJdbc servicio) {
		this.servicio = servicio;
	}
	@PostMapping
	public Videojuego crear(@RequestBody Videojuego videojuego) {
		return servicio.crear(videojuego);
	}
	@GetMapping
	public List<Videojuego> listar(){
		return servicio.listar();
	}
	@GetMapping("/{id}")
	public Videojuego buscar(@PathVariable String id) {
		return servicio.buscarPorCodigo(id);
	}
	@PutMapping("/{id}")
	public Videojuego actualizar(@PathVariable String id, @RequestBody Videojuego videojuego) {
		return servicio.actualizar(id, videojuego);
	}
	@DeleteMapping("/{id}")
	public boolean eliminar(@PathVariable String id) {
		return servicio.eliminar(id);
	}
}
