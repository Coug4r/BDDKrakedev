package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateEstudiantes {
	public static final Logger log = LogManager.getLogger(SelectEstudiantes.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = ConexionPostgres.conexion();
		PreparedStatement ps = null;
		String sql = """ 
				update esudiantes set apellidos = ? where id_estudiantes = ?;
				""";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "Ludeña");
			ps.setInt(2, 1);

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
