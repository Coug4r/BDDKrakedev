package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertEstudiante {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static void main(String args[]) {
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = """ 
				INSERT INTO esudiantes (id_estudiantes,nombres,apellidos,edad,curso,fechaRegistro)
				VALUES(?,?,?,?,?,?)
				""";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, "David");
			ps.setString(3, "Burneo");
			ps.setInt(4, 20);
			ps.setString(5, "Bases de Datos");
			ps.setString(6, "2026-05-24");
			
			int filas = ps.executeUpdate();
			log.info("Filas insertadas: "+filas);
			con.close();
			log.error("Conexion cerrada");
		} catch (SQLException e) {
			log.error("Error SQL");
			try {
				con.close();
				log.error("Conexion cerrada");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
