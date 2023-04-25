/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidad.Estudiante;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class EstudianteServicio {
    // Scanner encargado de la lectura de los atributos de los estudiantes (ISO-8859-1 es para que acepte acentos)
    private final Scanner leer = new Scanner(System.in,"ISO-8859-1");
    /**
     * Metodo que se encarga de cargar los datos del Estudiante
     * Solicita el nombre y la nota 
     * 
     * @return Esctudiante
     */
    public Estudiante crearEstudiante(){
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre=leer.next();
        System.out.print("Ingrese la nota: ");
        int nota = leer.nextInt();
        return new Estudiante (nombre,nota);
    }
    /**
     * Metodo que permite cargar los Estudiantes en forma masiva, llamando N
     *  cantidad de veces al metodo crearEstudiante()
     * 
     * @param cantidad int con la cantidad de Estudiantes a cargar
     * @return Array de Estudiante
     */
    public Estudiante[] crearEstudiantes(int cantidad){
        Estudiante[] resu= new Estudiante[cantidad];
        for (int i = 0; i < resu.length; i++) {
            resu[i]=crearEstudiante();
        }
        return resu;
    }
    /**
     * Metodo que calcula el promedio de notas de un array de Estudiante pasado
     * por parametro
     *  Informa el promedio de notas
     *  se controla en el caso de que todas las notas sean 0 y devuelve 0
     * 
     * @param escuela
     * @return double con el promedio de todos los estudiantes
     */
    public double calculaPromedio(Estudiante[] escuela){
        
        int sumaNota=0;
        for (Estudiante estudiante : escuela) {
            sumaNota+=estudiante.getNota();            
        }
        
        if (sumaNota==0) {
            System.out.println("El promedio de notas es: 0 puntos.");
            return 0;
        }
        System.out.println(String.format("El promedio de notas es: %.2f puntos.",(double)sumaNota/escuela.length));
        return sumaNota/escuela.length;
    }
    /**
     * Metodo encargado de crear un array de String con los nombres de los 
     * Estudiantes con nota mayor al promedio
     * @param escuela Array de Estudiante
     * @param nota double con promedio de notas
     * @return array de String con los nombres de los Estudiantes
     *      (incluye como extra la nota)
     * para generar el array se utiliza el metodo split del objeto String,utilizando
     *  la "/" como separador
     */
    public String[] mayorPromedio(Estudiante[] escuela,double nota){
        String lista="";
        for (Estudiante estudiante : escuela) {
            if (estudiante.getNota() > nota) {
                lista = lista.concat(String.format("%s (nota: %d)/", estudiante.getNombre(), estudiante.getNota()));
            }
        }
         if (lista.length()==0) {
            return new String[0];
        }
        String[] alumno= lista.split("/");
        return alumno;
    }
    /**
     * Metodo encargador de mostrar una lista con el nombre de los Estudiantes
     * que superaron el promedio
     * @param alumno Array de String con los nombres de los Estudiantes 
     *  (en el metodo que crea la lista se incluye como extra la nota)
     */
    public void mostrarArreglo(String[] alumno){
        System.out.println("Alumnos con una nota mayor al promedio:");
        for (int i = 0; i < alumno.length; i++) {
            System.out.println(String.format("Alumno %d: %s.",i+1,alumno[i]));
        }
    }
}
