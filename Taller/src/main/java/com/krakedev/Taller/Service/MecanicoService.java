package com.krakedev.Taller.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.Taller.Repositorys.MecanicoRepository;
import com.krakedev.Taller.entidades.Mecanico;

@Service
public class MecanicoService {
	private final MecanicoRepository repository;
	public MecanicoService(MecanicoRepository repository) {
		this.repository = repository;
	}
	public Mecanico guardar(Mecanico mecanico) {
		return repository.save(mecanico);
	}
	
	public List<Mecanico> listar(){
		return repository.findAll();
	}
	
	public Mecanico buscar(int id) {
		Optional<Mecanico> mecanico = repository.findById(id);
		return mecanico.orElse(null);
	}
	
	public Mecanico actualizar(int id, Mecanico mecanico) {
		Mecanico resultado = buscar(id);
		if(resultado == null) {
			return null;
		}
		resultado.setEspecialidad(mecanico.getEspecialidad());
		resultado.setNombre(mecanico.getNombre());
		resultado.setReparaciones(mecanico.getReparaciones());
		
		return repository.save(resultado);
	}
	
	public boolean eliminar(int id) {
		Mecanico resultado = buscar(id);
		if(resultado == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
