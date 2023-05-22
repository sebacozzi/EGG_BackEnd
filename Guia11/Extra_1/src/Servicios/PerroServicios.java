/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Perro;
import Entidades.Persona;
import Enumeradores.Raza;
import Enumeradores.Tamaño;
import java.util.List;
import java.util.Scanner;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastian Cozzi
 */
public class PerroServicios {
    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
// que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
// lea hasta el salto de linea

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    public PerroServicios() {
    }

    public Perro crearPerro() {
        
        String[] op = new String[Tamaño.values().length];

        int cont =0;
        
        for (Tamaño r : Tamaño.values()) {
            op[cont]=r.getDescripcion();
            cont++;
        }
        System.out.println("  Ingresar los datos del perro:");
        System.out.println("---------------------------------");
        System.out.print("*** Nombre (dejar vacio para salir): ");
        String nombre = leer.next();
        if (nombre.trim().isEmpty()) {
            return null;
        }
        System.out.print("*** Raza: ");
        String raza = leer.next();
        String tamaño = op[ServiciosMenu.opciones(op, "Tamaño:")];
        System.out.print("*** Edad: ");
        Integer edad = leer.nextInt();
        return new Perro(nombre, raza, tamaño, edad);
    }

    public void crearPerros(List<Perro> listaDePerros) {
        System.out.println("--------------------------------------------------");
        int inicial = listaDePerros.size();
        do {
            Perro perro = crearPerro();
            if (perro == null) {
                break;
            }else{
            listaDePerros.add(perro);
            }
            System.out.println("--------------------------------------------------");
        } while (true);
        System.out.println("--------------------------------------------------");
        System.out.printf("  Se cargaron %d perros.", listaDePerros.size() - inicial);
    }

    public void muestraPerros(Perro perro) {
        System.out.println(perro);
    }

    public void muestraPerros(List<Perro> perros, Boolean adoptado) {
        System.out.println("  Lista de Perros:");
        System.out.println("--------------------");

        if (perros.isEmpty()) {
            System.out.println("NO HAY PERROS PARA MOSTRAR.");
            return;
        }

        if (adoptado){
        for (Perro perro : perros) {
            if (perro.getAdpotado()) {
                muestraPerros(perro);        
            }
        }
        } else {
            for (Perro perro : perros) {
                if (!perro.getAdpotado()){
                muestraPerros(perro);
                }
            }
            System.out.println("-----------------------------------");
        }

    }

    public void muestraPerros(List<Perro> perros) {
        System.out.println("  Lista de Perros:");
        System.out.println("--------------------");

        if (perros.size() == 0) {
            System.out.println("NO HAY PERROS PARA MOSTRAR.");
            return;
        }

        for (Perro perro : perros) {
            muestraPerros(perro);
            System.out.println("-----------------------------------");
        }
    }
    

    public boolean adoptar(Persona persona, Perro perro) {

        if (persona.getPerro() != null) {
            System.out.printf("%s ya adopto un perro.\n", persona.getNombreCompleto());
            System.out.println(persona.getPerro());
            return false;
        }
        perro.setAdpotado(true);
        persona.setPerro(perro);
        System.out.printf("Perro adoptado por %s....\n", persona.getNombreCompleto());
        System.out.println(persona);
        return true;
    }
    }
