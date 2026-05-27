package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionPostgres {
	private static final Logger log = LogManager.getLogger(ConexionPostgres.class);
	public static Connection conexion(){
		Connection con = null; 
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Duke3902014");
			log.info("Conexion exitosa");
			return con;
		
//		} catch (PSQLException ec) {
//			log.error("Contraseña incorrecta!");
//			throw new RuntimeException("Contraseña incorrecta!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Fallo en la conexion!");
			throw new RuntimeException("Fallo en la conexion!");
		}
	}
}
