package com.krakedev.producto.excepciones;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EscribirArchivo {
	private static final Logger log = LogManager.getLogger(EscribirArchivo.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter escritor =  new FileWriter("contacto.txt",true);
			escritor.write("Andres\n");
			escritor.write("Castillo\n");
			escritor.write("123456778\n");
			escritor.close();
			
			log.info("Archivo creado con exito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Ocurrio un error" + e.getMessage());
		}
		
	}

}
