/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_3;

import Entidad.Alumno;
import Servicios.AlumnoServicio;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int i = 0; i < 17; i++) {
            System.out.println(String.format("TextBox%d = m(%d)",i+1,i));
            
        }
        AlumnoServicio as = new AlumnoServicio();
        ArrayList<Alumno> alumnos = new ArrayList();
        as.crearAlumnos(alumnos);
        do {} while (as.notasAlumno(alumnos));
    }
    
}
