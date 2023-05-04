/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pais;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class PaisServicios {

    private final Scanner leer;

    /**
     * CONSTRUCTOR encargado de inicializar el Scanner
     */
    public PaisServicios() {
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    }

    /**
     * Metodo encargado de cargar en forma masiva los paises en el set.<br>
     * Muestra un mensaje si el pais ya fue ingresado, sino lo agrega al
     * Set.<br>
     * Luego consulta si se desea seguir ingresando nombres de paises
     *
     * @param pais Objeto que contiene el Set donde se van a guardar los paises
     */
    public void cargarPaises(Pais pais) {
        do {
            System.out.print("Agregar pais al lista: ");
            // llama al metodo aniadeNombre del objeto que devuelve true si se cargo el nombre
            // si devuelve false informa que el nombre ya existe
            if (!pais.aniadeNombre(leer.next())) {
                System.out.println("");
                System.out.println("Pais repetido... ingrese otro");
                System.out.println("");
                continue;
            }
            // Pregunta si quiere seguir ingresando nombres
            System.out.print("¿Quiere agragar otro pais?(s/n) ");
            // lee el char en la posición 0 y si es igual de 's' contiuna con el "DO"
            // si es distinto informa la cantidad de nombres ingresados y sale del "DO" con un break
            if (leer.next().toLowerCase().charAt(0) != 's') {
                System.out.println("Paises ingresados: " + pais.getNombres().size());
                break;
            }
            System.out.println("");
        } while (true);
    }

    /**
     * Metodo que muestra un HashSet de String por consola. Pasa como argumento
     * a mostrar(HashSet&lt;String&gt;) el Set contenido en el objeto Pais
     *
     * @param pais Objeto que contiene el Set de paises
     *
     * @see #mostrar(java.util.HashSet)
     */
    public void mostrar(Pais pais) {
        // llama al medoto mostrar(HashSet<String> conjunto)
        mostrar(pais.getNombres());
    }

    /**
     * Metodo que muestra un HashSet de String por consola. Verifica si el set
     * está vacio
     *
     * @param conjunto <TT>HashSet&lt;String&gt;</TT> con los datos a mostrar
     */
    public void mostrar(HashSet<String> conjunto) {
        // Contador utilizado como indice de los nombres
        int cont = 1;
        // verifica si el Set esta vacio
        // si está vacio, informa y sale. Sino continua con el metodo
        if (conjunto.isEmpty()) {
            System.out.println("El conjunto de paises está vacio.");
            return;
        }
        // Bucle for que recorre el Set
        for (String nombre : conjunto) {
            // Muestra el indice (cont) y el nombre utilizando printf 
            System.out.printf("Pais %d: Nombre: %s.%n", cont, nombre);
            //incrementa cont
            cont++;
        }
    }

    /**
     * Metodo encargado de ordenar y mostrar el set almacenado en el objeto
     * Pais<br>
     * Primero verifica que el set no esté vacio<br>
     * Si no está vacio, pasa el set a un ArrayList y utiliza el metodo sort de
     * Collections para ordenarlo, luego utiliza un for each para mostrarlo por
     * consola
     *
     * @param pais Objeto que contiene el Set de paises
     */
    public void ordenarYMostrar(Pais pais) {
        // llama al metodo estaVacio y si lo está sale
        if (estaVacio(pais)) {
            return;
        }
        // pasa el Set a un ArrayList
        ArrayList<String> temp = new ArrayList(pais.getNombres());
        // contador utilizado para el indice de los nombres
        int cont = 1;
        // llama a Collections.sort para ordenar el ArrayList que contiene los datos del Set
        Collections.sort((List) temp);
        // bucle utilizado para recorrer el ArrayList y mostrar los nombres
        for (String nombre : temp) {
            System.out.printf("Pais %3d: Nombre: %s.%n", cont, nombre);
            // incremento del contador de indices
            cont++;
        }
    }

    /**
     * Metodo encargado de solicitar el nombre de un pais y verificar si está en
     * el set, si no está informa que no se encuentra en el set y sale del
     * metodo.<br>
     * Si se encuentra en el set, recorre el set con un Iterator y lo elimina.
     * <br>
     *
     * @param pais Objeto que contiene el Set de paises
     */
    public void buscarYBorrar(Pais pais) {
        // llama al metodo estaVacio y si lo está sale
        if (estaVacio(pais)) {
            return;
        }
        // solicita al usuario el nombre de pais a eliminar
        System.out.print("Ingresar el pais a buscar y eliminar: ");
        // almacena el nombre en la variable "p" para usos posteriores
        String p = leer.next();
        // Utiliza el metodo contains para verificar si lo almacenado en "p"
        // se encuentra en el Set, si lo contiene inicializa el iterator
        if (pais.getNombres().contains(p)) {
            // iterador encargado de recorrer el Set
            Iterator<String> iter = pais.getNombres().iterator();
            //inicia el While consultando al iterador si hay siguiente
            while (iter.hasNext()) {
                // compara el valor de "p" con el valor .next() (posición del iterador)
                // si es igual lo elimina y sale del while (no hay valores repetidos)
                // sino sigue avansando en el iterador hasta que no alla siguiente
                if (iter.next().equals(p)) {
                    iter.remove();
                    break;
                }
            }
            // muestra el set con el valor de p eliminado
            System.out.println("Lista con el pais " + p + " eliminado:");
            System.out.println("--------------------------------------------------");
            mostrar(pais.getNombres());
        } else {
            // else del contains; muestra un mensaje informando que el valor de "p"
            // no se encuentra en el Set (reconoce mayusculas y minusculas
            System.out.println("--- El pais " + p + " no se encuentra en el conjunto ---");
        }
    }

    /**
     * Metodo encargado de verificar si en el objeto Pais tiene datos guardados
     * <br>
     *
     * @param pais Objeto a verificar
     * @return boolean true si no hay datos, false si ya se cargaron paises
     */
    public boolean estaVacio(Pais pais) {
        // llama al metodo isEmpty para saber si el Set esta vacio, si es así,
        // muestra un mensaje y devuelve true, sino devuelve false
        if (pais.getNombres().isEmpty()) {
            System.out.println("El conjunto de paises está vacio.");
            return true;
        }
        return false;
    }
}
