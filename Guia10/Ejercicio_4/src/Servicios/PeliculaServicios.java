/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pelicula;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class PeliculaServicios {
    // Scanner utilizado para capturar los datos ingresados por el usuario
    private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    // Para switch ordenar por titulo
    public final int ORDENA_X_TITULO = 1;
    // Para switch ordenar por director
    public final int ORDENA_X_DIRECTOR = 2;
    // Para switch ordenar por duración
    public final int ORDENA_X_DURACION = 3;
    
    // lt y ld utilizados para el metodo mostrar
    // de uso interno para almacenar la longitud del titulo mas largo
    private int lt;
    // de uso interno para almacenar la longitud del nombre de director mas largo
    private int ld;

    /**
     * Metodo que solicita al usuario titulo de la pelicula, nombre del director
     * y duración
     *
     * @return Objeto de tipo Pelicula
     */
    public Pelicula cargarPelicula() {
        System.out.print("Ingresar el titulo: ");
        String titulo = leer.next();
        System.out.print("Ingresar el Director: ");
        String director = leer.next();
        System.out.print("Ingresar la duración en hora (formato= h:m): ");
        String hora= leer.next();
        String[] h=hora.split(":");
        System.out.println(h[0]);
        Time duracion =new Time(Integer.parseInt(h[0]),Integer.parseInt(h[1]),0);
        return new Pelicula(titulo, director, duracion);
    }
    /**
    * Metodo encargador de carga masiva de Peliculas
    * consulta, luego de cargar cada pelicula, si desea agregar otra
    * 
    * @param lista ArrayList&lt;Pelicula&gt; donde se van a almacenar
    */
    public void cargarPeliculas(ArrayList<Pelicula> lista) {
        // Verifica si es la primera carga de peliculas y setea lt y ld a 0
        if (lista.isEmpty()) {
            lt = 0;
            ld = 0;
        }
        do {
            lista.add(cargarPelicula());
            if (lista.get(lista.size() - 1).getTitulo().length() > lt) {
                lt = lista.get(lista.size() - 1).getTitulo().length();
            }
            if (lista.get(lista.size() - 1).getDirector().length() > ld) {
                ld = lista.get(lista.size() - 1).getDirector().length();
            }
            System.out.print("Desea ingresar otra pelicula?(s/n) ");
            if (leer.next().toLowerCase().charAt(0) == 'n') {
                break;
            }
        } while (true);
    }
    /**
     * Metodo encargador de mostrar por consola la lista de peliculas
     * pasada por parametro<br>
     * Lo muestra formateado por columnas <br>
     * Columna 1: Pelicula + indice(espaciado de 3 digitos)<br>
     * Columna 2: Titulo de la pelicula(Espaciado a la derecha determinado por el titulo mas largo)<br>
     * Columna 3: Director de la pelicula(Espaciado a la derecha determinado por el nombre del director mas largo)<br>
     * Columna 4: Duración de la pelicula(Centrado a "Minutos" con 3 digitos de espaciado)
     * 
     * @param lista ArrayList&lt;Pelicula&gt; con los datos a mostrar
     */
    public void mostrarPeliculas(ArrayList<Pelicula> lista) {
        // Iterador de Lista de peliculas
        Iterator<Pelicula> iter = lista.iterator();
        // Contador de Indices de peliculas
        int cont = 1;
        // Usado para guardar texto a formatear
        String fTexto;
        // Variable para almacenar pasos del iterator
        Pelicula pel;
        // calculo para centrar "Titulo" en columna
        int ct = (int) ((lt - 6) / 2);
        // calculo para centrar "Director" en columna
        int cd = (int) ((ld - 8) / 2);
        // Formato para la fila de encabezado
        fTexto="    Número     |%1$" + ct + "sTitulo%1$" + ct + "s  | %1$" + cd + "sDirector%" + cd + "s |   Horas   |%n";
        // imprime encabezado
        System.out.printf(fTexto, "");
        // Bucle del iterator
        while (iter.hasNext()) {
            // Asigna Iterator a variable para poder utilizar todos los atributos
            pel = iter.next();
            // formato para las filas de peliculas
            fTexto=" Pelicula %3d: | %-"+ lt +"s | %-"+ ld + "s |   %2d:%02d   |%n";
            // imprime fila con datos de la pelicula
            System.out.printf(fTexto,cont, pel.getTitulo(), pel.getDirector(),pel.getDuracion().getHours(),pel.getDuracion().getMinutes());
            // contador para indice de pelicula
            cont++;
        }
    }
/**
 * Metodo que recorre un ArrayList&lt;Pelicula&gt; con la lista de peliculas 
 * y filtra las peliculas que cumplen con la condición de que la duración 
 * sea mayor a 60 minutos
 * @param lista ArrayList&lt;Pelicula&gt; con la lista completa
 * @return ArrayList&lt;Pelicula&gt; con la lista filtrada
 */
    public ArrayList<Pelicula> mayorDeUnaHora(ArrayList<Pelicula> lista) {
        ArrayList<Pelicula> temp = new ArrayList();
        for (Pelicula pelicula : lista) {
            if (pelicula.getDuracion().getTime()> 14400000) {
                temp.add(pelicula);
            }
        }
        return temp;
    }
/**
 * Metodo encargado de ordenar ArrayList&lt;Pelicula&gt; por el atributo determinado
 *  de menor a mayor
 * 
 * @param lista ArrayList&lt;Pelicula&gt; con los datos a ordenar
 * @param por int<br>
 * PeliculaServicios.ORDENA_X_TITULO = 1 ordena por titulo de la pelicula<br>
 * PeliculaServicios.ORDENA_X_DIRECTOR = 2 ordena por director de la pelicula<br>
 * PeliculaServicios.ORDENA_X_DURACION = 3 ordena por duración de la pelicula
 * @return ArrayList&lt;Pelicula&gt; con los datos ordeandos en forma ascendente
 */
    public ArrayList<Pelicula> ordenar(ArrayList<Pelicula> lista, int por) {
        return ordenar(lista, true, por);
    }
/**
 * Metodo encargado de ordenar ArrayList&lt;Pelicula&gt; por el atributo determinado
 *  de menor a mayor o mayor a menor determinado por el parametro boolean ascendente
 * <br>
 * @param lista ArrayList&lt;Pelicula&gt; con los datos a ordenar
 * <br>
 * @param ascendente boolean, si es true ordena de menor a mayor y si es false
 * ordena de mayor a menor
 * <br>
 * @param por int<br>
 * PeliculaServicios.ORDENA_X_TITULO = 1 ordena por titulo de la pelicula<br>
 * PeliculaServicios.ORDENA_X_DIRECTOR = 2 ordena por director de la pelicula<br>
 * PeliculaServicios.ORDENA_X_DURACION = 3 ordena por duración de la pelicula<br>
 * 
 * @return ArrayList&lt;Pelicula&gt; con los datos ordeandos en forma ascendente
 */
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
                System.out.println("Los posibles valores son: ORDENA_X_TITULO,ORDENA_X_DIRECTOR,ORDENA_X_DURACION.\nNo se realizo ningun cambio en la lista.");
                return lista;
        }
        if (!ascendente) {
            Collections.reverse(temp);
        }
        return temp;
    }
}
