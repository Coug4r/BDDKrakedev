package com.krakeDev.taller.exepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        try {
            // Prueba con teléfono inválido
            ValidarContacto.validarTelefono("123");
            GuardarContacto.guardar();
            LeerContacto.leer();
            log.info("Proceso completado correctamente");
        } catch (IllegalArgumentException e) {
            log.error("Teléfono inválido: " + e.getMessage());
        }

        try {
            // Prueba con teléfono válido
            ValidarContacto.validarTelefono("0981234567");
            GuardarContacto.guardar();
            LeerContacto.leer();
            log.info("Proceso completado correctamente");
        } catch (IllegalArgumentException e) {
            log.error("Teléfono inválido: " + e.getMessage());
        }
    }
}
