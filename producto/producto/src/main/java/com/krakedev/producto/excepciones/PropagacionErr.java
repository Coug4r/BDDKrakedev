package com.krakedev.producto.excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PropagacionErr {
	public void metodoA() throws FileNotFoundException {
		FileReader archivo = new FileReader("archivo.txt");
		System.out.println("Archivo avierto");
	}
	public void metodoB() {
		try {
			metodoA();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
