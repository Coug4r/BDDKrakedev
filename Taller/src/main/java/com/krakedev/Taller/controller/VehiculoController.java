package com.krakedev.Taller.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakedev.Taller.Service.VehiculoService;
import com.krakedev.Taller.entidades.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo nuevo = service.guardar(vehiculo);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar vehículo: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<Vehiculo> lista = service.listar();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar vehículos: " + e.getMessage());
        }
    }

    @GetMapping("/{placa}")
    public ResponseEntity<?> buscar(@PathVariable String placa) {
        try {
            Vehiculo vehiculo = service.buscar(placa);
            if (vehiculo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(vehiculo);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar vehículo: " + e.getMessage());
        }
    }

    @PutMapping("/{placa}")
    public ResponseEntity<?> actualizar(@PathVariable String placa, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo actualizado = service.actualizar(placa, vehiculo);
            if (actualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar vehículo: " + e.getMessage());
        }
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<?> eliminar(@PathVariable String placa) {
        try {
            boolean eliminado = service.eliminar(placa);
            if (!eliminado) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar vehículo: " + e.getMessage());
        }
    }
}