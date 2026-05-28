package com.krakdev.peliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krakdev.peliculas.entidades.Pelicula;

public interface PeliculasRepository extends JpaRepository<Pelicula, Long>{
	List<Pelicula> findByGenero(String genero);
	List<Pelicula> findByDisponible(boolean disponible);
}
