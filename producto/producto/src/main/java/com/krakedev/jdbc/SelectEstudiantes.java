package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectEstudiantes {
	public static final Logger log = LogManager.getLogger(SelectEstudiantes.class);
	public static void main(String args[]) {
		Connection con = ConexionPostgres.conexion();
		String sql = "SELECT * FROM esudiantes";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int ids = rs.getInt("id_estudiantes");
				String nombres = rs.getString("nombres");
				String apellidos = rs.getString("apellidos");
				int edades = rs.getInt("edad");
				String curso = rs.getString("curso");
				String fecha = rs.getString("fechaRegistro");
				System.out.println(ids +" "+nombres+" "+apellidos+" "+edades+" "+curso+" "+fecha);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
