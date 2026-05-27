package com.krakedev.tallerjdbc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.tallerjdbc.entidades.Vehiculo;
import com.krakedev.tallerjdbc.entidades.VehiculoJdbc;

@Service
public class VehiculoService {
	public Vehiculo crear(Vehiculo vehi) {
		return VehiculoJdbc.insertar(vehi.getPlaca(),vehi.getMarca(),vehi.getModelo(),vehi.getAnio(),vehi.getPrecio(),vehi.getColor(),vehi.isDisponible(),vehi.getKilometraje());
	}
	public List<Vehiculo> listar(){
		return VehiculoJdbc.listar();
	}
	public Vehiculo buscar(String placa) {
		return VehiculoJdbc.buscar(placa);
	}
	public Vehiculo actualizar(String placa, Vehiculo act) {
		return VehiculoJdbc.actualizar(placa, act.getMarca(),act.getModelo(),act.getAnio(),act.getPrecio(),act.getColor(),act.isDisponible(),act.getKilometraje());
	}
	public boolean eliminar(String placa) {
		return VehiculoJdbc.eliminar(placa);
	}
}
