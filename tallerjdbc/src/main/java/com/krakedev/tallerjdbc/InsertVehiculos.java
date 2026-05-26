package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculos {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static void main(String[] args) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = "INSERT INTO vehiculos (placa,marca,modelo,anio,precio,color,disponible)\r\n"
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "IG003C");
			ps.setString(2, "KTM");
			ps.setString(3, "DUKE");
			ps.setInt(4, 2014);
			ps.setDouble(5, 3400.40);
			ps.setString(6, "Blanco");
			ps.setBoolean(7,true);
			int filas = ps.executeUpdate();
			log.info("Vehiculo insertado\nFilas afectadas "+filas);
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
