package com.krakedev.producto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.producto.entidades.Producto;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    // 1. Crear
    public Producto crear(Producto producto) {
        for (Producto p : productos) {
            if (p.getCodigo() == producto.getCodigo()) {
                return null; // Ya existe
            }
        }
        productos.add(producto);
        return producto;
    }

    // 2. Listar
    public List<Producto> listar() {
        return productos;
    }

    // 3. Buscar por código
    public Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    // 4. Actualizar
    public Producto actualizar(int codigo, Producto productoActualizado) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                p.setNombre(productoActualizado.getNombre());
                p.setPrecio(productoActualizado.getPrecio());
                //Se añade el nuevo atributo y se setea tambien
                p.setStock(productoActualizado.getStock());
                return p;
            }
        }
        return null; // No existe
    }

    // 5. Eliminar
    public boolean eliminar(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                productos.remove(p);
                return true;
            }
        }
        return false; // No existe
    }
}