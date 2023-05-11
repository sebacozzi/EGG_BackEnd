/**Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a
 * contar de dos clases. Perro, que tendrá como atributos: nombre, raza, edad y
 * tamaño; y la clase Persona con atributos: nombre, apellido, edad, documento 
 * y Perro.
 * Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a
 * tener que pensar la lógica necesaria para asignarle a cada Persona un Perro
 * y por ultimo, mostrar desde la clase Persona, la información del Perro y de
 * la Persona.
 */
package ejercicio_1;

import Entidades.Perro;
import Entidades.Persona;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Perro perro= new Perro("Pepe", "Pichicho", "Mediano", 3);
        Persona persona= new Persona("Sebastian", "Cozzi", 42, 28524714, perro);
        System.out.println(persona);
        System.out.println("");
        Persona persona1= new Persona("Martina", "Cozzi", 6, 28524714,null);
        System.out.println(persona1);
        
    }
    
}
