package com.krakedev.Taller.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.Taller.Service.MecanicoService;
import com.krakedev.Taller.entidades.Mecanico;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    private final MecanicoService service;

    public MecanicoController(MecanicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Mecanico mecanico) {
        try {
            Mecanico nuevo = service.guardar(mecanico);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar mecánico: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<Mecanico> lista = service.listar();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar mecánicos: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id) {
        try {
            Mecanico mecanico = service.buscar(id);
            if (mecanico == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(mecanico);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar mecánico: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody Mecanico mecanico) {
        try {
            Mecanico actualizado = service.actualizar(id, mecanico);
            if (actualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar mecánico: " + e.getMessage());
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
            return ResponseEntity.internalServerError().body("Error al eliminar mecánico: " + e.getMessage());
        }
    }
}