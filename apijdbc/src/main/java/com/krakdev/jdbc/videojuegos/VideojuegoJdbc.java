package com.krakdev.jdbc.videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.videojuegos.entidades.Videojuego;
import com.krakdev.jdbc.ConexionPostgres;

public class VideojuegoJdbc {
	private static final Logger log = LogManager.getLogger(VideojuegoJdbc.class); 
	public static Videojuego insertar(Videojuego juego) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		Videojuego game = null;
		String sql = "INSERT INTO videojuegos(codigo,nombre,plataforma,precio,disponible,genero) "
				+ "VALUES(?,?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, juego.getCodigo());
			ps.setString(2, juego.getNombre());
			ps.setString(3, juego.getPlataforma());
			ps.setDouble(4, juego.getPrecio());
			ps.setBoolean(5, juego.isDisponible());
			ps.setString(6, juego.getGenero());
			int filas = ps.executeUpdate();
			log.info("Videojuego insertado con exito!\nFilas afectadas "+filas);
			game = juego;
		} catch (SQLException e) {
			log.error("Error al insertar!");
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		return game;
	}
	public static List<Videojuego> listar(){
		List<Videojuego> videojuegos = new ArrayList<Videojuego>();
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		Videojuego game = null;
		String sql = "SELECT * FROM videojuegos;";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				String plataforma = rs.getString("plataforma");
				double precio = rs.getDouble("precio");
				boolean disponible = rs.getBoolean("disponible");
				String genero = rs.getString("genero");
				game = new Videojuego(codigo,nombre,plataforma,precio,disponible,genero);
				videojuegos.add(game);
			}
			log.info("Listado con exito");

		}catch (SQLException e) {
			log.error("Error al insertar!");
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		return videojuegos;
	}
	public static Videojuego buscar(String id) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Videojuego game = null;
		String sql = "SELECT * FROM videojuegos WHERE codigo = ?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				game = new Videojuego(rs.getString("codigo"),rs.getString("nombre"),rs.getString("plataforma"),rs.getDouble("precio"),rs.getBoolean("disponible"),rs.getString("genero"));
				log.info("Busqueda exitosa");
			}
		} catch (SQLException e) {
			log.error("Error en la busqueda!");
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		return game;
	}
	public static Videojuego actualizar(String id,Videojuego juego) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		Videojuego game = null;
		String sql = "UPDATE videojuegos SET nombre=?, plataforma=?, precio=?, disponible=?, genero=? WHERE codigo=? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, juego.getNombre());
			ps.setString(2, juego.getPlataforma());
			ps.setDouble(3, juego.getPrecio());
			ps.setBoolean(4, juego.isDisponible());
			ps.setString(5, juego.getGenero());
			ps.setString(6, id);
			game = juego;
			int filas = ps.executeUpdate();
			log.info("Videojuego actualizado con exito!\nFilas afectadas "+filas);
		}catch (SQLException e) {
			log.error("Error al actualizar!");
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		return game;
	}
	public static boolean eliminar(String id) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		boolean resultado = false;
		String sql = "DELETE FROM videojuegos WHERE codigo=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			resultado = true;
			log.info("Videojuego eliminado con exito!");
		}catch (SQLException e) {
			log.error("Error al eliminar!");
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		return resultado;
	}
}
