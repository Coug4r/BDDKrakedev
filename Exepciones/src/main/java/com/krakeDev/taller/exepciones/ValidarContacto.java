package com.krakeDev.taller.exepciones;

public class ValidarContacto {
    public static void validarTelefono(String telefono) throws IllegalArgumentException {
        if (telefono == null || telefono.length() != 10) {
            throw new IllegalArgumentException("Teléfono inválido, debe tener 10 dígitos");
        }
    }
}
