package com.krakeDev.taller.exepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerContacto {
    private static final Logger log = LoggerFactory.getLogger(LeerContacto.class);

    public static void leer() {
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader("contactos.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            log.info("Archivo leído correctamente");
        } catch (FileNotFoundException e) {
            log.error("Archivo no encontrado", e);
        } catch (IOException e) {
            log.error("Error al leer archivo", e);
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    log.error("Error al cerrar lector", e);
                }
            }
        }
    }
}
