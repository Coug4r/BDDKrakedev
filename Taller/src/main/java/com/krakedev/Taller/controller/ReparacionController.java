package com.krakedev.Taller.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakedev.Taller.Service.ReparacionService;
import com.krakedev.Taller.entidades.Reparacion;

@RestController
@RequestMapping("/reparaciones")
public class ReparacionController {

    private final ReparacionService service;

    public ReparacionController(ReparacionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Reparacion reparacion) {
        try {
            Reparacion nueva = service.guardar(reparacion);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar reparación: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<Reparacion> lista = service.listar();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar reparaciones: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            Reparacion reparacion = service.buscar(id);
            if (reparacion == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(reparacion);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar reparación: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody Reparacion reparacion) {
        try {
            Reparacion actualizada = service.actualizar(id, reparacion);
            if (actualizada == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar reparación: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try {
            boolean eliminado = service.eliminar(id);
            if (!eliminado) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar reparación: " + e.getMessage());
        }
    }
}