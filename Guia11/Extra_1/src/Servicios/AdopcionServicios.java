/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Perro;
import Entidades.Persona;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class AdopcionServicios {
    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
// que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
// lea hasta el salto de linea

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    public void personaAdoptaPerro(Persona persona, List<Perro> perros) {
        boolean adopto = false;
        PerroServicios ps = new PerroServicios();
        String nombre = "";
        System.out.println("  Sistema de Adpción:");
        System.out.println("***********************");
        do {
            System.out.printf("%s, ingresa el nombre del perro que queres adoptar:\n"
                    + "(para listar los disponibles ingresa -h o vacio para salir) ", persona.getNombreCompleto());
            nombre = leer.next();
            if (!nombre.trim().isEmpty()) {
                if (nombre.trim().equals("-h")) {
                    ps.muestraPerros(perros, false);
                    continue;
                }
                for (Perro perro : perros) {
                    if (!perro.getAdpotado()) {
                        if (perro.getNombre().equalsIgnoreCase(nombre)) {
                            System.out.println("Adoptaste a " + perro.getNombre());
                            persona.setPerro(perro);
                            perro.setAdoptadoPor(persona);
                            adopto=true;
                            break;
                        }
                    }
                }
                System.out.printf("No se encontro ningun perro con el nombre de %s.\n", nombre);
                
                System.out.print("¿Queres volver a ingresar el nombre? s/n");
                if (leer.next().charAt(0)=='s') {
                    continue;
                }
                break;
                
            } else {
                break;
            }

        } while (true);

        if (adopto) {
            System.out.println("Se ha formado una nueva familia!!!");
            System.out.println("");
            System.out.println(persona.toString());
            System.out.println("");
        } else {
            System.out.println("***** No se pudo formar una nueva familia! *****");
        }
    }

    public void perroAdoptaPersona(Perro perro, List<Persona> personas) {

    }
}
