package com.krakedev.tallerjdbc.empleados.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.tallerjdbc.empleados.entidades.Empleado;
import com.krakedev.tallerjdbc.empleados.service.ServiceEmpleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	private final ServiceEmpleado servicio;
	public EmpleadoController(ServiceEmpleado servicio) {
		this.servicio=servicio;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Empleado empleado){
		try {
			Empleado newEmpleado = servicio.crear(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body(newEmpleado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el empleado");
		}
	}
	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Empleado> empleados = servicio.listar();
			return ResponseEntity.ok(empleados);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al LISTAR");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id){
		try {
			Empleado empleado = servicio.buscarPorId(id);
			if(empleado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado con id "+id+" no encontrado");
			}
			return ResponseEntity.ok(empleado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar");
		}
	}
	@GetMapping("/cargo")
	public ResponseEntity<?> buscarPorCargo(@RequestParam String cargo){
		try {
			List<Empleado> empleados = servicio.buscarPorCargo(cargo);
			if(empleados.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen empleados con ese cargo!");
			}
				return ResponseEntity.ok(empleados);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por cargo");
		}
	}
	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorEstado(@RequestParam String estado){
		try {
			List<Empleado> empleados = servicio.buscarPorCargo(estado);
			return ResponseEntity.ok(empleados);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por cargo");
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Empleado empleado){
		try {
			Empleado actualizado = servicio.actualizar(id, empleado);
			if(actualizado==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado con id: "+id+"no fue encontrado");
			}
			return ResponseEntity.ok(actualizado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al ACTUALIZAR");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		try {
			boolean eliminado = servicio.eliminar(id);
			if(eliminado == false) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado con id: "+id+" no fue encontrado");
			}
			return ResponseEntity.ok("Empleado eliminado con exito!");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al ELIMINAR");
		}
	}
}
