package com.krakedev.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.proyectos.entidades.Tarea;
import com.krakedev.proyectos.services.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Tarea tarea) {
        try {
            return ResponseEntity.ok(tareaService.guardar(tarea));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear tarea: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodas() {
        try {
            List<Tarea> tareas = tareaService.listarTodas();
            return ResponseEntity.ok(tareas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar tareas: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return tareaService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar tarea: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Tarea tarea) {
        try {
            tarea.setId(id);
            return ResponseEntity.ok(tareaService.guardar(tarea));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar tarea: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            tareaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar tarea: " + e.getMessage());
        }
    }
}
