/**Ejercicio integrador
 * Una escuela ha terminado su ciclo lectivo y todos sus alumnos ya rindieron el
 * examen final. La escuela nos ha pedido que calculemos el promedio de notas
 * final de todos sus alumnos y saber qué alumnos han recibido una nota por
 * encima de ese promedio.
 * Para esto vamos a tener que crear un objeto de tipo Estudiante, sus atributos
 * van a ser nombre y nota (representando la nota obtenida en el final).
 * La escuela consta con tan solo 8 estudiantes, por lo que deberemos crear los
 * 8 estudiantes con sus respectivas notas.
 * Una vez creado los estudiantes deberemos guardar los estudiantes en un
 * arreglo de objetos tipo Estudiante, usando ese arreglo tenemos que realizar
 * las dos tareas que nos ha pedido la escuela.
 *    1. Calcular y mostrar el promedio de notas de todo el curso
 *    2. Retornar otro arreglo con los nombre de los alumnos que recibieron una
 *      nota mayor al promedio del curso
 *    3. Por último, deberemos mostrar todos los estudiantes con una nota
 *      mayor al promedio.
 * 
 * Nota: para crear un vector de objetos la definición es la siguiente:
 *      Objeto nombreVector[] = new Objeto[];
 */
package integrador;

import Entidad.Estudiante;
import Servicios.EstudianteServicio;

/**
 *
 * @author Sebastián Cozzi
 */
public class Integrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instansación del Servicio que administra el objeto Estudiante
        EstudianteServicio es= new EstudianteServicio();
        // Creación de Arreglo de Estudiantes
        Estudiante[] escuela= es.crearEstudiantes(8);
        System.out.println("");
        // Calculo de promedio de notas
        double promedio= es.calculaPromedio(escuela);
        System.out.println("");
        // Creación de Array con nombres de los alumnos "mayor" al promedio
        String[] alumnosMayorAPromedio=es.mayorPromedio(escuela, promedio);
       es.mostrarArreglo(alumnosMayorAPromedio);
        
    }
    /* Pruebas de notas
    ////////////////////////////////
    Notas iguales (promedio 0.00)
               *         *        *      *       *      *         *          * 
    Sebastian 0 Ignacio 0 Marcos 0 Raul 0 Ramón 0 Juan 0 Mariana 0 Agustina 0
    ////////////////////////////////
    Notas iguales, promedios iguales (promedio 7.00)
               *         *        *      *       *      *         *          *
    Sebastian 7 Ignacio 7 Marcos 7 Raul 7 Ramón 7 Juan 7 Mariana 7 Agustina 7
    ////////////////////////////////
    Notas variadas (promedio 6.63)
               *         *        *      *       *      *          *          *
    Sebastian 7 Ignacio 6 Marcos 4 Raul 8 Ramón 7 Juan 4 Mariana 10 Agustina 7
    ////////////////////////////////
    Notas altas menos 1 Estudiante (promedio 7.88)
               *         *        *      *       *      *          *          *
    Sebastian 8 Ignacio 8 Marcos 1 Raul 9 Ramón 9 Juan 9 Mariana 10 Agustina 9
     */
}
