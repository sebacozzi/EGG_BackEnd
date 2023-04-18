/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class FechaServicio {
 /**a) Método fechaNacimiento que pregunte al usuario día, mes y año de su
 *  nacimiento. Luego los pase por parámetro a un nuevo objeto Date. El método
 *  debe retornar el objeto Date.
 *      Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
 * 
     * @return 
 */
    public Date fechaNacimiento(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su fecha de nacimiento:");
        System.out.print("Ingresar el día: ");
        int dia=leer.nextInt();
        System.out.print("Ingrese el número de mes: ");
        int mes=leer.nextInt();
        System.out.print("Ingrese el año en 4 digitos: ");
        int anio = leer.nextInt();
        return new Date(anio-1900, mes-1, dia);
    }
    
 /**  b) Método fechaActual que cree un objeto fecha con el día actual. Para esto
 *  usaremos el constructor vacío de la clase Date.
 *      Ejemplo: Date fechaActual = new  Date();
 *  El método debe retornar el objeto Date.
 * 
 */
    public Date fechaActual(){
        return new Date();
    }
    
 /**  c) Método diferencia que reciba las dos fechas por parámetro y retorna la
 *  diferencia de años entre una y otra (edad del usuario).
 * 
     * @param fecha1
     * @param fecha2
     * @return 
 */
    public int diferencia(Date fecha1,Date fecha2){
        int dif=(int) ((fecha1.getTime()/365/24/60/60/1000) -
                        (fecha2.getTime()/365/24/60/60/1000));
        
        return  Math.abs(dif);
    }
    
}
