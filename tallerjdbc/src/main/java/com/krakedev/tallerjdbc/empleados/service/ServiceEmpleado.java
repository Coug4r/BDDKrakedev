package com.krakedev.tallerjdbc.empleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.tallerjdbc.empleados.entidades.Empleado;
import com.krakedev.tallerjdbc.empleados.repository.EmpleadoRepository;

@Service
public class ServiceEmpleado {
	private final EmpleadoRepository repository;
	public ServiceEmpleado(EmpleadoRepository repository) {
		this.repository = repository;
	}
	
	public Empleado crear(Empleado empleado) {
		return repository.save(empleado);
	}
	
	public List<Empleado> listar(){
		return repository.findAll();
	}
	
	public Empleado buscarPorId(Long id) {
		Optional<Empleado> resultado = repository.findById(id);
		return resultado.orElse(null);
	}
	
	public Empleado actualizar(Long id, Empleado act) {
		Empleado emp = buscarPorId(id);
		if(emp == null) {
			return null;
		}
		emp.setNombre(act.getNombre());
		emp.setApellido(act.getApellido());
		emp.setCargo(act.getCargo());
		emp.setActivo(act.isActivo());
		return repository.save(emp);
	}
	
	public boolean eliminar(Long id) {
		Empleado empleado = buscarPorId(id);
		if(empleado == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
	
	public List<Empleado> buscarPorCargo(String cargo){
		return repository.findByCargo(cargo);
	}
	
	public List<Empleado> buscarPorEstado(boolean estado){
		return repository.findByActivo(estado);
	}
}
