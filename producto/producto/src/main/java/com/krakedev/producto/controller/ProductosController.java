package com.krakedev.producto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.producto.entidades.Producto;
import com.krakedev.producto.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductoService productoService;

    // Inyección de dependencia por constructor
    public ProductosController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // 1. Crear producto
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }

    // 2. Listar todos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    // 3. Buscar por código
    @GetMapping("/{codigo}")
    public Producto buscarPorCodigo(@PathVariable int codigo) {
        return productoService.buscarPorCodigo(codigo);
    }

    // 4. Actualizar producto
    @PutMapping("/{codigo}")
    public Producto actualizar(@PathVariable int codigo, @RequestBody Producto productoActualizado) {
        return productoService.actualizar(codigo, productoActualizado);
    }

    // 5. Eliminar producto
    @DeleteMapping("/{codigo}")
    public boolean eliminar(@PathVariable int codigo) {
        return productoService.eliminar(codigo);
    }
}
