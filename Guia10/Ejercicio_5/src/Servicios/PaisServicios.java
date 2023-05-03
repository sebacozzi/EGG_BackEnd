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

    public PaisServicios() {
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    }

    public void cargarPaises(Pais pais) {
        do {
            System.out.print("Agregar pais al lista: ");
            if (!pais.aniadeNombre(leer.next())) {
                System.out.println("");
                System.out.println("Pais repetido... ingrese otro");
                System.out.println("");
                continue;
            };
            System.out.print("¿Quiere agragar otro pais?(s/n) ");
            if (leer.next().toLowerCase().charAt(0) != 's') {
                System.out.println("Paises ingresados: " + pais.getNombres().size());
                break;
            }
            System.out.println("");
        } while (true);
    }

    public void mostrar(Pais pais) {
        mostrar(pais.getNombres());
    }
    public void mostrar(HashSet<String> conjunto){
        int cont =1;
        if (conjunto.isEmpty()){
            System.out.println("El conjunto de paises está vacio.");
            return;
        }
        for (String nombre : conjunto) {
            System.out.printf("Pais %d: Nombre: %s.%n",cont,nombre);
            cont++;
        }
    }
    public void ordenarYMostrar(Pais pais){
        if (pais.getNombres().isEmpty()){
            System.out.println("El conjunto de paises está vacio.");
            return;
        }
        ArrayList<String> temp = new ArrayList(pais.getNombres());
        int cont=1;
        Collections.sort((List) temp);
        for (String nombre : temp) {
            System.out.printf("Pais %d: Nombre: %s.%n",cont,nombre);
            cont++;
        } 
    }
    public void buscarYBorrar(Pais pais){
        if (pais.getNombres().isEmpty()){
            System.out.println("El conjunto de paises está vacio.");
            return;
        }
        System.out.print("Ingresar el pais a buscar y eliminar: ");
        String p = leer.next();
        if (pais.getNombres().contains(p)) {
            Iterator<String> iter = pais.getNombres().iterator();
            while (iter.hasNext()) {
                if (iter.next().equals(p)) {
                    iter.remove();
                    break;
                }
            }
            System.out.println("Lista con el pais "+p+" eliminado:");
            System.out.println("--------------------------------------------------");
            mostrar(pais.getNombres());
        }else
            System.out.println("--- El pais "+p+" no se encuentra en el conjunto ---");
    }
}
