/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Persona;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class PersonaServicios {

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    /**
     * Metodo que se encarga de ingresar los datos de la persona. Solicita
     * nombre, apellido, documento y edad.
     *
     * @return retorna un objeto del tipo Persona, si no se ingresa un nombre
     * retorna null.
     */
    public Persona crearPersona() {

        // Permite ingreasar los datos de la persona
        System.out.println("  Ingresar los datos de la persona:");
        System.out.println("-------------------------------------");
        System.out.print("*** Nombre (dejar vacio para salir): ");
        String nombre = leer.next();
        //If que controla si no se ingreso un nombre para salir del metodo
        if (nombre.trim().isEmpty()) {
            return null;
        }
        System.out.print("*** Apellido: ");
        String apellido = leer.next();
        System.out.print("*** Documento/DNI: ");
        Long documento = leer.nextLong();
        System.out.print("*** Edad: ");
        Integer edad = leer.nextInt();

        return new Persona(nombre, apellido, documento, edad);
    }

    /**
     * Metodo que se encarga de cargar varias personas hasta que crearPersona
     * retorne null
     *
     * @param personas Lista de Objetos del tipo Persona
     * @see #crearPersona()
     */
    public void crearPersonas(List<Persona> personas) {
        int inicial = personas.size();

        do {
            Persona persona = crearPersona();
            if (persona == null) {
                break;
            }
            personas.add(persona);
            System.out.println("");
        } while (true);

        System.out.printf("Se agregaron %d personas a la lista.\n", personas.size() - inicial);
    }

    public void mostrarPersona(Persona persona, boolean mostraMascota) {
        if (persona == null) {
            System.out.println("No se puede mostrar la persona.");
        }
        if (mostraMascota) {
            System.out.println(persona);
        } else {
            System.out.println(persona.datosPersona());
        }
    }

    public void mostrarPersonasYMascotas(List<Persona> personas, boolean mostrarMascotas) {
        if (personas.isEmpty()) {
            System.out.println("***** No hay personas para mostrar. *****");
            return;
        }
        for (Persona persona : personas) {
            mostrarPersona(persona, mostrarMascotas);
        }
    }

}
