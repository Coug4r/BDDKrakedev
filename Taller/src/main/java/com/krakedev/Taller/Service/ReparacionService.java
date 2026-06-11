package com.krakedev.Taller.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.Taller.Repositorys.MecanicoRepository;
import com.krakedev.Taller.Repositorys.ReparacionRepository;
import com.krakedev.Taller.Repositorys.VehiculoRepository;
import com.krakedev.Taller.entidades.Mecanico;
import com.krakedev.Taller.entidades.Reparacion;
import com.krakedev.Taller.entidades.Vehiculo;

@Service
public class ReparacionService {
	private final ReparacionRepository repository;
	private final MecanicoRepository mecanicoRepository;
	private final VehiculoRepository vehiculoRepository;
	
	public ReparacionService(ReparacionRepository repository,MecanicoRepository mecanicoRepository,VehiculoRepository vehiculoRepository) {
		this.repository = repository;
		this.mecanicoRepository = mecanicoRepository;
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public Reparacion guardar(Reparacion reparacion) {
		Vehiculo vehiculo = vehiculoRepository.findById(reparacion.getVehiculo().getPlaca())
				.orElseThrow(()-> new RuntimeException("Vehiculo no existe!"));
		List<Mecanico> mecanicosDB = new ArrayList<>();
		for(Mecanico mecanico:mecanicosDB) {
			Mecanico mecanicoEncontrado = mecanicoRepository.findById(mecanico.getId()).orElseThrow(()->new RuntimeException("Mecanico no existe!"));
			mecanicosDB.add(mecanicoEncontrado);
		}
		reparacion.setVehiculo(vehiculo);
		reparacion.setMecanicos(mecanicosDB);
		
		return repository.save(reparacion);
	}
	
	public List<Reparacion> listar(){
		return repository.findAll();
	}
	
	public Reparacion buscar(int id) {
		Optional<Reparacion> repa =  repository.findById(id);
		return repa.orElse(null);
	}
	
	public Reparacion actualizar(int id,Reparacion data) {
		Reparacion reparacion = buscar(id);
		if(reparacion != null) {
			reparacion.setCosto(data.getCosto());
			reparacion.setDescricion(data.getDescricion());
			reparacion.setFechaEntrega(data.getFechaEntrega());
			reparacion.setFechaIngreso(data.getFechaIngreso());
			return repository.save(reparacion);
		}else {
			return null;
		}
	}
	
	public boolean eliminar(int id) {
		Reparacion reparacion = buscar(id);
		if(reparacion == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
