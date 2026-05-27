package com.krakdev.jdbc.videojuegos.services;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioVideojuegoJdbc {

    // Crear videojuego
    public Videojuego crear(Videojuego juego) {
        return VideojuegoJdbc.insertar(juego);
    }

    // Listar videojuegos
    public List<Videojuego> listar() {
        return VideojuegoJdbc.listar();
    }

    // Buscar por código
    public Videojuego buscarPorCodigo(String codigo) {
        return VideojuegoJdbc.buscar(codigo);
    }

    // Actualizar videojuego
    public Videojuego actualizar(String codigo, Videojuego juego) {
        return VideojuegoJdbc.actualizar(codigo, juego);
    }

    // Eliminar videojuego
    public boolean eliminar(String codigo) {
        return VideojuegoJdbc.eliminar(codigo);
    }
}