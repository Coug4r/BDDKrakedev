package com.krakedev.producto.excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeerArchivo {
	
	private static final Logger log = LogManager.getLogger(LeerArchivo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader lector  = new FileReader("contacto.txt");
			BufferedReader bf = new BufferedReader(lector);
			System.out.println(bf.readLine());
			System.out.println(bf.readLine());
			System.out.println(bf.readLine());
			System.out.println(bf.readLine());
			System.out.println(bf.readLine());
			System.out.println(bf.readLine());
			
			bf.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error al leer archivo"+ e.getMessage());
		}
		
	}

}
