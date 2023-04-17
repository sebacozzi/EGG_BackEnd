/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Persona;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class PersonaServicio {
private Scanner leer=new Scanner(System.in).useDelimiter("\n");
    /** a) Método crearPersona que pida al usuario Nombre y fecha de nacimiento de la
 * persona a crear. Retornar el objeto Persona creado.
 * 
     * @return 
 */
    public Persona creaPersona(){
        System.out.println("Ingresar los datos de la persona:");
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/YYYY): ");
        String[] fecha=leer.next().split("/");
        return new Persona(nombre, new Date(Integer.parseInt(fecha[2])-1900,Integer.parseInt(fecha[1])-1,Integer.parseInt(fecha[0])));
    }
    
    
 /** b) Método calcularEdad que calcule la edad del usuario utilizando el atributo
 * de fecha de nacimiento y la fecha actual.
 * 
 */
    
    
 /** c) Método menorQue recibe como parámetro una Persona y una edad. Retorna true
 * si la persona es menor que la edad consultada o false en caso contrario.
 * 
 */
    
    
 /** d) Método mostrarPersona que muestra la información de la persona deseada.
  * 
  */
    
    
}
