package com.krakedev.tallerjdbc.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.tallerjdbc.ConexionPostgres;

public class VehiculoJdbc {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static Vehiculo insertar(String placa, String marca, String modelo, int anio, double precio, String color,boolean disponible, int kilometraje) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "INSERT INTO vehiculos (placa,marca,modelo,anio,precio,color,disponible,kilometraje)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		Vehiculo veh = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, placa);
			ps.setString(2,marca);
			ps.setString(3, modelo);
			ps.setInt(4,anio);
			ps.setDouble(5, precio);
			ps.setString(6, color);
			ps.setBoolean(7, disponible);
			ps.setInt(8, kilometraje);
			veh = new Vehiculo(placa,marca,modelo,anio,precio,color,disponible,kilometraje); 
			int filas = ps.executeUpdate();
			log.info("Filas afectadas "+filas);
			
		} catch (SQLException e) {
			log.error("Error SQL!");
			throw new RuntimeException("Error al insertar: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e1) {
				log.error("Error al cerrar conexion!");
			}
		}	
		return veh;		
	}
	
	public static List<Vehiculo> listar(){
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM vehiculos";
		ResultSet rs = null;
		
		try {
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				int kilometraje = rs.getInt("kilometraje");
				Vehiculo veh = new Vehiculo(placa,marca,modelo,anio,precio,color,disponible,kilometraje);
				vehiculos.add(veh);
			}
		} catch (SQLException e) {
			log.error("Error al listar!");
			throw new RuntimeException("Error al listar: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e1) {
				log.error("Error al cerrar conexion!");
			}
		}
		return vehiculos;
	}
	
	public static Vehiculo buscar(String placa) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM vehiculos WHERE placa = ?";
		ResultSet rs = null;
		Vehiculo veh = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, placa);
			rs=ps.executeQuery();
			if(rs.next()) {
				veh = new Vehiculo(rs.getString("placa"),rs.getString("marca"),rs.getString("modelo"),rs.getInt("anio"),rs.getDouble("precio"),rs.getString("color"),rs.getBoolean("disponible"),rs.getInt("kilometraje"));
			}
			
		}catch (SQLException e) {
			log.error("Error SQL!");
			throw new RuntimeException("Error al buscar: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e1) {
				log.error("Error al cerrar conexion!");
			}
		}
		return veh;
	}
	
	public static Vehiculo actualizar(String placa, String marca, String modelo, int anio, double precio, String color,boolean disponible, int kilometraje) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "UPDATE vehiculos SET "
				+ "marca = ?, "
				+ "modelo = ?, "
				+ "anio = ?, "
				+ "precio = ?, "
				+ "color = ?, "
				+ "disponible = ?, "
				+ "kilometraje = ? "
				+ "WHERE placa = ?;";
		Vehiculo veh = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setInt(3, anio);
			ps.setDouble(4, precio);
			ps.setString(5, color);
			ps.setBoolean(6,disponible);
			ps.setInt(7, kilometraje);
			ps.setString(8, placa);
			veh = new Vehiculo(placa,marca,modelo,anio,precio,color,disponible,kilometraje);
			int filas = ps.executeUpdate();
			log.info("Vehiculo actualizado\nFilas afectadas "+filas);
			
		} catch (SQLException e) {
			log.error("Error SQL!");
			throw new RuntimeException("Error al actualizar: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e1) {
				log.error("Error al cerrar conexion!");
			}
		}
		return veh;
	}
	
	public static boolean eliminar(String placa) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "DELETE FROM vehiculos WHERE placa = ?";
		Vehiculo veh = null;
		boolean res = false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, placa);
			int filas = ps.executeUpdate();
			log.info("Vehiculo eliminado\nFilas afectadas "+filas);
			res = true;
		} catch (SQLException e) {
			log.error("Error al eliminar!");
			throw new RuntimeException("Error al eliminar: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e1) {
				log.error("Error al cerrar conexion!");
			}
		}
		return res;
	}
}
