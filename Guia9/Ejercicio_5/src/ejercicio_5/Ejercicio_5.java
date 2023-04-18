/**Implemente la clase Persona en el paquete entidades. Una persona tiene un
 * nombre y una fecha de nacimiento (Tipo Date), constructor vacío, constructor
 * parametrizado, get y set. Crear una clase PersonaService, en el paquete
 * servicio, con los siguientes métodos:
 * a) Método crearPersona que pida al usuario Nombre y fecha de nacimiento de la
 * persona a crear. Retornar el objeto Persona creado.
 * b) Método calcularEdad que calcule la edad del usuario utilizando el atributo
 * de fecha de nacimiento y la fecha actual.
 * c) Método menorQue recibe como parámetro una Persona y una edad. Retorna true
 * si la persona es menor que la edad consultada o false en caso contrario.
 * d) Método mostrarPersona que muestra la información de la persona deseada.

 */
package ejercicio_5;

import Entidades.Persona;
import Servicios.PersonaServicio;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona per;
        PersonaServicio ps = new PersonaServicio();
        per=ps.creaPersona();
        System.out.println(ps.calcularEdad(per));
        ps.mostrarPersona(per);
    }
    
}
