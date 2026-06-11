package com.krakedev.proyectos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krakedev.proyectos.entidades.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    // Ejemplo de consulta personalizada
    // List<Tarea> findByProyectoId(Integer proyectoId);
    // List<Tarea> findByFechaLimiteBefore(LocalDate fecha);
}
