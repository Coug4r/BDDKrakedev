package com.krakedev.producto.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EjemploLog4j2 {
	private static final Logger log = LogManager.getLogger(EjemploLog4j2.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = 10/0;
		}catch(Exception e) {
			log.error("Ocurrio un error" + e);
			
		}
	}

}
