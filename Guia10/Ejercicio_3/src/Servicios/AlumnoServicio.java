/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class AlumnoServicio {
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    
    public Alumno creaAlumno(){
        Alumno alumno = new Alumno();
        System.out.print("Ingrese el nombre del alumno: ");
        alumno.setNombre(leer.next());
        System.out.println("--- Ingrese las notas del alumno ---");
        for (int i = 0; i < 3; i++) {
            System.out.print(String.format("Nota %d: " ,i+1));
            alumno.getNotas().add(leer.nextInt());
        }
        return alumno;
    }
    /**
     * En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
     * toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
     * pregunta al usuario si quiere crear otro Alumno o no.
     * @param alumnos 
     */
    public void crearAlumnos(ArrayList<Alumno> alumnos){
        do {
            alumnos.add(creaAlumno());
            System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ----");
            System.out.print("-- ¿Desea ingresar otro alumnos? -- (S)i/(N)o ");
        } while (leer.next().toLowerCase().charAt(0)=='s'); 
    }
    /**
     * Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
     * final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
     * del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
     * promedio final, devuelto por el método y mostrado en el main.
     * @param alumnos
     * @return 
     * 
     */
    
    public boolean notasAlumno(ArrayList<Alumno> alumnos){
        double notaF=0;
        boolean encontro =false;
        System.out.print("Ingresar el nombre del alumno (dejar en blanco para salir):  ");
        String nombre= leer.next();
        if (nombre.trim().isEmpty()) {
            return false;
        }
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                notaF = notaFinal(alumno.getNotas());
                encontro = true;
                break;
            }
        }
        System.out.println("---- ---- ---- ---- ---- ---- ---- ----");
        if (encontro) {
            
            System.out.println(String.format("La nota final de %s es de %.2f.-", nombre,notaF));
        }else
        System.out.println("No se encontro el nombre del alumno.");
        return true;
    }
    public double notaFinal(ArrayList<Integer> notas){
        double sumaNotas=0;
        Iterator<Integer> iterator = notas.iterator();
        while (iterator.hasNext()) {
            sumaNotas+=iterator.next();
        }
        return sumaNotas/notas.size();
    }
}
