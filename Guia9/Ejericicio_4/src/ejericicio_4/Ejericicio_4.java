/**Vamos a usar la clase Date que ya existe en Java. Crearemos la clase
 * FechaService, en paquete Servicios, que tenga los siguientes métodos:
 *  a) Método fechaNacimiento que pregunte al usuario día, mes y año de su
 *  nacimiento. Luego los pase por parámetro a un nuevo objeto Date. El método
 *  debe retornar el objeto Date.
 *      Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
 *  b) Método fechaActual que cree un objeto fecha con el día actual. Para esto
 *  usaremos el constructor vacío de la clase Date.
 *      Ejemplo: Date fechaActual = new  Date();
 *  El método debe retornar el objeto Date.
 *  c) Método diferencia que reciba las dos fechas por parámetro y retorna la
 *  diferencia de años entre una y otra (edad del usuario).
 * 
 * Si necesiten acá tienen más información en clase Date: Documentacion Oracle
 */
package ejericicio_4;

import java.util.Date;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejericicio_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date fecha= new Date(80,11,30);
        Date f1=new Date();
        System.out.println("fecha: "+ ((f1.getYear())-fecha.getYear()));
        System.out.println("tics: " + (fecha.getTime()/1000/60/60/24/365));
        System.out.println("tics: " + (f1.getTime()/1000/60/60/24/365));
        int duf =(int) Math.abs((fecha.getTime()/1000/60/60/24/365)-(f1.getTime()/1000/60/60/24/365));
        
        System.out.println("dif : "+ duf);
    }
    
}
