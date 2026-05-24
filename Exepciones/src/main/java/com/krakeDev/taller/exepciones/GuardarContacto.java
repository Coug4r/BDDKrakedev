package com.krakeDev.taller.exepciones;

import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardarContacto {
    private static final Logger log = LoggerFactory.getLogger(GuardarContacto.class);

    public static void guardar() {
        FileWriter escritor = null;
        try {
            escritor = new FileWriter("contactos.txt", true);
            escritor.write("Nombre: Maria\n");
            escritor.write("Apellido: Gomez\n");
            escritor.write("Telefono: 0981234567\n");
            log.info("Contacto guardado correctamente");
        } catch (IOException e) {
            log.error("Error al guardar contacto", e);
        } finally {
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    log.error("Error al cerrar archivo", e);
                }
            }
        }
    }
}
