package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehculo {

	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static void main(String[] args) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM vehiculos;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				System.out.println(placa+" "+marca+" "+modelo+" "+anio+" "+precio+" "+color+" "+disponible);
			}
			
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
