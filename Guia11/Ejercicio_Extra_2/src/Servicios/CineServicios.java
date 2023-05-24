/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cine;
import Entidades.Expectador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastian Cozzi
 */
public class CineServicios {
    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
// que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
// lea hasta el salto de linea

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    public void crearExpectadores(List<Expectador> expectadores) {
        System.out.print("Ingrese la cantidad de expectadores a crear: ");
        int cant = leer.nextInt();
        if (!expectadores.isEmpty()) {
            System.out.println("");
            System.out.println("La lista de expectadores no está vacia.");
            if (!ServiciosMenu.preguntaSON("¿Desea añadirla a la lista existente?(s/n) ")) {
                expectadores.clear();
            }
        }
        for (int i = 0; i < cant; i++) {
            expectadores.add(new Expectador());
        }
        System.out.println("");
        System.out.printf("Se crearon %d nuevos expectadores", cant);
    }

    public void LlenarSala(List<Expectador> expectadores, Cine cine) {
        String butaca;
        int contIngresaron = 0;

        for (Expectador expectador : expectadores) {
            if (expectador.getEdad() >= cine.getPelicula().getEdadMinima()) {
                if (expectador.getDinero() > cine.getPrecioEntrada()) {
                    if (cine.isLlena()) {
                        System.out.println("Se a llenado la sala...\n");
                        break;
                    }
                    if (expectador.getButaca().trim().isEmpty()) {

                        System.out.print(expectador.getNombre() + " asignado a la butaca ");
                        butaca = butacaVacia(cine.getSala());
                        expectador.setButaca(butaca);
                        expectador.setDinero(expectador.getDinero() - cine.getPrecioEntrada());
                        System.out.println(butaca);
                        cine.getSala().replace(butaca, expectador);
                        cine.setEstado(true);

                        contIngresaron++;
                    }
                }
            }
        }
        System.out.printf("Ingresaron %d expectadores a la sala.\n", contIngresaron);
    }

    public void listarExpectadoresEnSala(Cine cine) {
        for (Expectador value : cine.getSala().values()) {
            if (value != null) {
                System.out.println(value.toString());
            }
        }
    }

    public void mostrarSala(Cine cine) {
        System.out.println(cine.toString());
    }

    private String butacaVacia(HashMap<String, Expectador> sala) {
        int fila;
        String columna;
        String butaca;
        String[] letras = {"A", "B", "C", "D", "E", "F"};
        do {
            fila = (int) Math.round(Math.random() * 7) + 1;
            columna = letras[(int) Math.round(Math.random() * 5)];
            butaca = String.valueOf(fila).concat(columna);
        } while (sala.get(butaca) != null);
        return butaca;
    }

    public void vaciarSala(Cine cine, List<Expectador> expectadores) {
        if (!cine.getEstado()) {
            System.out.println("La sala está desocupada!!\n");
            return;
        }
        if (ServiciosMenu.preguntaSON("¿Seguro desea vaciar la sala?(s/n) ")) {
            for (Map.Entry<String, Expectador> butaca : cine.getSala().entrySet()) {
                butaca.setValue(null);
            }
            System.out.println("La sala se vacio correctamente.\n");
            cine.setEstado(false);
        } else {
            System.out.println("La sala sigue ocupada.\n");
        }
        for (Expectador expectador : expectadores) {
            expectador.setButaca("");
        }
    }

    public void mostrarPelicula(Cine cine) {
        System.out.println(cine.getPelicula().toString());
    }

    public void mostrarPersonas(ArrayList<Expectador> expectadores) {
        for (Expectador expectador : expectadores) {
            System.out.println(expectador);
            System.out.println("------------------------------------------------");
        }
    }

}
