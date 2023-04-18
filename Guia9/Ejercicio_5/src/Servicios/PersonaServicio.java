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
public int calcularEdad(Persona persona){
    Date fecha1=new Date();
    Date fecha2 = persona.getfNacimiento();
         int dif=(int) ((fecha1.getTime()/365/24/60/60/1000) -
                        (fecha2.getTime()/365/24/60/60/1000));
        return  Math.abs(dif);
} 
    
 /** c) Método menorQue recibe como parámetro una Persona y una edad. Retorna true
 * si la persona es menor que la edad consultada o false en caso contrario.
 * 
 */
    public boolean menorQue(Persona persona, int edadOtro){
        return calcularEdad(persona)<edadOtro;
    }
    
 /** d) Método mostrarPersona que muestra la información de la persona deseada.
  * 
  */
    public void mostrarPersona(Persona persona){
        System.out.println("Persona:");
        System.out.println(String.format("Nombre: %s.", persona.getNombre()));
        System.out.println(String.format("Fecha de nacimiento: %d/%d/%d.", persona.getfNacimiento().getDate(),
                                                                           persona.getfNacimiento().getMonth()+1,
                                                                           persona.getfNacimiento().getYear()+1900));
        System.out.println(String.format("Edad: %d años.", calcularEdad(persona)));
        System.out.println("--------fin de persona--------");
    }
    
}
