package com.krakedev.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.proyectos.entidades.Proyecto;
import com.krakedev.proyectos.services.ProyectoService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;
    
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Proyecto proyecto) {
        try {
            Proyecto nuevo = proyectoService.guardar(proyecto);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear proyecto: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Proyecto> proyectos = proyectoService.listarTodos();
            return ResponseEntity.ok(proyectos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar proyectos: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return proyectoService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar proyecto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Proyecto proyecto) {
        try {
            proyecto.setId(id);
            Proyecto actualizado = proyectoService.guardar(proyecto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar proyecto: " + e.getMessage());
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            proyectoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar proyecto: " + e.getMessage());
        }
    }
}
