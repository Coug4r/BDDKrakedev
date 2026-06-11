package com.krakedev.Taller.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.Taller.Repositorys.VehiculoRepository;
import com.krakedev.Taller.entidades.Vehiculo;

@Service
public class VehiculoService {
    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    public List<Vehiculo> listar() {
        return repository.findAll();
    }

    public Vehiculo buscar(String placa) {
        Optional<Vehiculo> vehiculo = repository.findById(placa);
        return vehiculo.orElse(null);
    }

    public Vehiculo actualizar(String placa, Vehiculo vehiculo) {
        Vehiculo existente = buscar(placa);
        if (existente == null) {
            return null;
        }
        existente.setMarca(vehiculo.getMarca());
        existente.setModelo(vehiculo.getModelo());
        existente.setAnio(vehiculo.getAnio());
        existente.setReparaciones(vehiculo.getReparaciones());

        return repository.save(existente);
    }

    public boolean eliminar(String placa) {
        Vehiculo existente = buscar(placa);
        if (existente == null) {
            return false;
        }
        repository.deleteById(placa);
        return true;
    }
}
