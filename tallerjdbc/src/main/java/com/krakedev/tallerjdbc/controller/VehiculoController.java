package com.krakedev.tallerjdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.tallerjdbc.entidades.Vehiculo;
import com.krakedev.tallerjdbc.services.VehiculoService;

@RestController
@RequestMapping("jdbc/vehiculos")
public class VehiculoController {
	private final VehiculoService servicio;
	public VehiculoController(VehiculoService servicio) {
		this.servicio = servicio;
	}
	@PostMapping
	public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
		return servicio.crear(vehiculo);
	}
	@GetMapping
	public List<Vehiculo> listar(){
		return servicio.listar();
	}
	@GetMapping("/{placa}")
	public Vehiculo buscar(@PathVariable String placa) {
		return servicio.buscar(placa);
	}
	@PutMapping("/{placa}")
	public Vehiculo actualizar(@PathVariable String placa, @RequestBody Vehiculo vehiculo) {
		return servicio.actualizar(placa, vehiculo);
	}
	@DeleteMapping("/{placa}")
	public boolean eliminar(@PathVariable String placa) {
		return servicio.eliminar(placa);
	}
}
