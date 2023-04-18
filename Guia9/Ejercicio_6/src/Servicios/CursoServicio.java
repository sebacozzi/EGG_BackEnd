/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Curso;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class CursoServicio {
    
   private Scanner leer = new Scanner(System.in).useDelimiter("\n");
 /** d) Método cargarAlumnos(): este método le permitirá al usuario ingresar los
 * alumnos que asisten a las clases. Nosotros nos encargaremos de almacenar esta
 * información en un arreglo e iterar con un bucle, solicitando en cada
 * repetición que se ingrese el nombre de cada alumno.
 * 
 */
    private String[] cargarAlumnos(){
        String[] resultado=new String[5];
        
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(String.format("Nombre del alumno %d: ",i+1));
            resultado[i]=leer.nextLine();
        }
        return resultado;
    }
    
 /** e) Método crearCurso(): el método crear curso, le pide los valores de los
 * atributos al usuario y después se le asignan a sus respectivos atributos para
 * llenar el objeto Curso. En este método invocamos al método cargarAlumnos()
 * para asignarle valor al atributo alumnos
 * 
 */
    public Curso crearCurso(){
        System.out.println("Carga de datos en curso:");
        System.out.print("Nombre del curso: ");
        String nombreCurso=leer.nextLine();
        System.out.print("Cantidad de horas por dia: ");
        int cantHoras=leer.nextInt();
        System.out.print("Cantidad de días por semana: ");
        int cantDias = leer.nextInt();
        System.out.print("Turno en que se dicta el curso (mañana/tarde): ");
        String turno=leer.next();
        System.out.print("Precio por hora: ");
        double PrecioHora=leer.nextDouble();
        
        return new Curso(nombreCurso,cantHoras, cantDias, turno,PrecioHora, cargarAlumnos());
    }
    
 /** f) Método calcularGananciaSemanal(): este método se encarga de calcular la
 * ganancia en una semana por curso. Para ello, se deben multiplicar la cantidad
 * de horas por día, el precio por hora, la cantidad de alumnos y la cantidad de
 * días a la semana que se repite el encuentro.
 * 
     * @param curso
     * @return 
 */
    public double calcularGananciaSemanal(Curso curso){
     return curso.getCantidadDiasPorSemana() *
            curso.getCantidadHorasPorDia() *
            curso.getPrecioPorHora() *
            curso.getAlumnos().length;
    }
}
