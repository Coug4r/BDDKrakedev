package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static void main(String[] args) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "UPDATE vehiculos SET "
				+ "marca = ?, "
				+ "modelo = ?, "
				+ "anio = ?, "
				+ "precio = ?, "
				+ "color = ?, "
				+ "disponible = ? "
				+ "WHERE placa = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "YAMAHA");
			ps.setString(2, "MT07");
			ps.setInt(3, 2020);
			ps.setDouble(4, 7600);
			ps.setString(5, "Negro");
			ps.setBoolean(6,true);
			ps.setString(7, "IG003C");
			int filas = ps.executeUpdate();
			log.info("Vehiculo actualizado\nFilas afectadas "+filas);
		} catch (SQLException e) {
			log.error("Error en conexion!"+e.getMessage());
		}finally {
			try {
				con.close();
				log.info("Conexion cerrada!");
			} catch (SQLException e) {
				log.error("Error al cerrar conexion!");
			}
		}
		
	}
}