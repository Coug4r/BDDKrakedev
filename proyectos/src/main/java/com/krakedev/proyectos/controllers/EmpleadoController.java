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

import com.krakedev.proyectos.entidades.Empleado;
import com.krakedev.proyectos.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Empleado empleado) {
        try {
            return ResponseEntity.ok(empleadoService.guardar(empleado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear empleado: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Empleado> empleados = empleadoService.listarTodos();
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar empleados: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return empleadoService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar empleado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Empleado empleado) {
        try {
            empleado.setId(id);
            return ResponseEntity.ok(empleadoService.guardar(empleado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar empleado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            empleadoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar empleado: " + e.getMessage());
        }
    }
}
