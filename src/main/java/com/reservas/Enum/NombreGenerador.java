package com.reservas.Enum;

import java.util.ArrayList;
import java.util.List;

public class NombreGenerador {

    public static List<String> generarNombres(Long cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }

        List<String> nombres = new ArrayList<>();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            for (int j = 0; j < letras.length(); j++) {
                if (nombres.size() == cantidad){
                    break;
                }
                // Selecciona una letra aleatoria del abecedario
                char letra = letras.charAt(j);
                // Agrega un número entre 1 y 6
                for (int k = 1; k <= 8; k++) {
                    if (nombres.size() == cantidad){
                        break;
                    }
                    // Crear el nombre alfanumérico de dos caracteres
                    String nombre = "" + letra + k;
                    nombres.add(nombre);
                }
            }
        }while (nombres.size() < cantidad);

        return nombres;
    }
}