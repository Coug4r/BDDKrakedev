package com.krakdev.peliculas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class Peliculacontroller {
	private final ServicioPelicula servicios;
	public Peliculacontroller(ServicioPelicula servicios) {
		this.servicios = servicios;
	}
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Pelicula pelicula){
		try {
			Pelicula newPelicula = servicios.crear(pelicula);
			return ResponseEntity.status(HttpStatus.CREATED).body(newPelicula);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear Pelicula"+e.getMessage());
		}
	}
	@GetMapping
	public ResponseEntity<?> listar(){
		try {
			List<Pelicula> peliculas = servicios.listar();
			return ResponseEntity.ok(peliculas);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		try {
			Pelicula peli = servicios.buscarPorId(id);
			return ResponseEntity.ok(peli);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pelicula con id "+id+" no encontrada!");
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id,@RequestBody Pelicula peli){
		try {
			Pelicula newPeli = servicios.actualizar(id, peli);
			return ResponseEntity.ok(newPeli);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		try {
			boolean eliminado = servicios.eliminar(id);
			return ResponseEntity.ok(eliminado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pelicula con id "+id+" no encontrada!");
		}
	}
	@GetMapping("/genero")
	public ResponseEntity<?> buscarPorGenero(String genero){
		try {
			List<Pelicula> peliculas = servicios.buscarPorGenero(genero);
			return ResponseEntity.ok(peliculas);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genero no encontrado");
		}
	}
	@GetMapping("/disponible")
	public ResponseEntity<?> buscarPorDisponible(){
		try {
			List<Pelicula> peliculas = servicios.buscarPorDisponible();
			return ResponseEntity.ok(peliculas);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar disponibles");
		}
	}
}
