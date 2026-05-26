package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static void main(String[] args) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql="DELETE FROM vehiculos WHERE placa = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "IG003C");
			int filas = ps.executeUpdate();
			log.info("Vehiculo eliminado\nFilas afectadas "+filas);
		} catch (SQLException e) {
			log.error("Error de SQL!");
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
