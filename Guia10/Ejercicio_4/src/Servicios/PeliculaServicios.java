/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class PeliculaServicios {

    private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    public final int ORDENA_X_TITULO = 1;
    public final int ORDENA_X_DIRECTOR = 2;
    public final int ORDENA_X_DURACION = 3;

    public Pelicula cargarPelicula() {
        System.out.print("Ingresar el titulo: ");
        String titulo = leer.next();
        System.out.print("Ingresar el Director: ");
        String director = leer.next();
        System.out.print("Ingresar la duración: ");
        Double duracion = leer.nextDouble();
        return new Pelicula(titulo, director, duracion);
    }

    public void cargarPeliculas(ArrayList<Pelicula> lista) {
        do {
            lista.add(cargarPelicula());
            System.out.print("Desea ingresar otra pelicula?(s/n) ");
            if (leer.next().toLowerCase().charAt(0) == 'n') {
                break;
            }
        } while (true);
    }

    public void mostrarPeliculas(ArrayList<Pelicula> lista) {
        Iterator<Pelicula> iter = lista.iterator();

        while (iter.hasNext()) {
            System.out.println("---- ---- ---- ---- ----");
            System.out.println(iter.next().toString());
        }
    }

    public ArrayList<Pelicula> mayorDeUnaHora(ArrayList<Pelicula> lista) {
        ArrayList<Pelicula> temp = new ArrayList();
        for (Pelicula pelicula : lista) {
            if (pelicula.getDuracion() > 1) {
                temp.add(pelicula);
            }
        }
        return temp;
    }
    
    public ArrayList<Pelicula> ordenar(ArrayList<Pelicula> lista, int por) {
        return ordenar(lista,true,por);
    }

    public ArrayList<Pelicula> ordenar(ArrayList<Pelicula> lista, boolean ascendente, int por) {

        ArrayList<Pelicula> temp = lista;
        switch (por) {
            case ORDENA_X_TITULO:// porTitulo
                Collections.sort(temp, Pelicula.porTitulo);
                break;
            case ORDENA_X_DIRECTOR:// porTitulo
                Collections.sort(temp, Pelicula.porDirector);
                break;
            case ORDENA_X_DURACION:// porTitulo
                Collections.sort(temp, Pelicula.porDuracion);
                break;
            default:
                System.out.println("Los posibles valores son: ORDENAXTITULO,ORDENAXDIRECTOR,ORDENAXDURACION.\nNo se realizo ningun cambio en la lista.");
                return lista;
        }
        if (!ascendente) {
            Collections.reverse(temp);
        }
        return temp;
    }

}
