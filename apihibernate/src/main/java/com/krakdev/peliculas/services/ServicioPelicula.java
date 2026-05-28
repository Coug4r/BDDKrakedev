package com.krakdev.peliculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculasRepository;

@Service
public class ServicioPelicula {
	private final PeliculasRepository repository;
	public ServicioPelicula(PeliculasRepository repository) {
		this.repository = repository;
	}
	public Pelicula crear(Pelicula peli) {
		return repository.save(peli);
	}
	public List<Pelicula> listar(){
		return repository.findAll();
	}
	public Pelicula buscarPorId(Long id) {
		Optional<Pelicula> resultado = repository.findById(id);
		return resultado.orElse(null);
	}
	public Pelicula actualizar(Long id, Pelicula peli) {
		Pelicula nueva = buscarPorId(id);
		if(nueva!=null) {
			nueva.setNombre(peli.getNombre());
			nueva.setDirector(peli.getDirector());
			nueva.setGenero(peli.getGenero());
			nueva.setDuracion(peli.getDuracion());
			nueva.setDisponible(peli.isDisponible());
			return repository.save(nueva);
		}
		return null;
	}
	public boolean eliminar(Long id) {
		if(buscarPorId(id)!=null) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	public List<Pelicula> buscarPorGenero(String genero) {
		return repository.findByGenero(genero);
	}
	public List<Pelicula> buscarPorDisponible(){
		return repository.findByDisponible(true);
	}
}
