/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sebastian Cozzi
 */
public class Alquiler {
    private String nombre;
    private long dni;
    private Date inicioAlquiler;
    private Date finAlquiler;
    2private int posicionAmarre;
    private Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, long dni, Date inicioAlquiler, Date finAlquiler, int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.dni = dni;
        this.inicioAlquiler = inicioAlquiler;
        this.finAlquiler = finAlquiler;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Date getInicioAlquiler() {
        return inicioAlquiler;
    }

    public void setInicioAlquiler(Date inicioAlquiler) {
        this.inicioAlquiler = inicioAlquiler;
    }

    public Date getFinAlquiler() {
        return finAlquiler;
    }

    public void setFinAlquiler(Date finAlquiler) {
        this.finAlquiler = finAlquiler;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }
    public Double calculoAlquiler(){
        long dias = TimeUnit.DAYS.toDays((long) (this.finAlquiler.getTime()-this.inicioAlquiler.getTime()));
        
        if (this.barco instanceof BarcoAMotor) {
            BarcoAMotor b1= (BarcoAMotor) this.barco;
            return b1.valorModuloBarco() * dias;
        }else if (this.barco instanceof Velero) {
            Velero b1= (Velero) this.barco;
            return b1.valorModuloBarco() * dias;
        }else if (this.barco instanceof YateDeLujo) {
            YateDeLujo b1= (YateDeLujo) this.barco;
            return b1.valorModuloBarco() * dias;
        }else{
            return  this.barco.valorModuloBarco() * dias;
        }
    }
    
    public void crearAlquiler (){
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        System.out.println("Datos para el alquiler:");
        System.out.print(  "          Nombre del cliente -> ");
        this.nombre = leer.next();
        System.out.print(  "          Documento -> ");
        this.dni = leer.nextLong();
        System.out.print(  "          Fecha de inicio del alquiler (DD/MM/YYYY -> ");
        String[] datos=leer.next().split("/");
        this.inicioAlquiler = new Date(Integer.parseInt(datos[2])-1900,Integer.parseInt(datos[1])-1,Integer.parseInt(datos[0]));
        System.out.print(  "          Fecha de finalización del alquiler (DD/MM/YYYY -> ");
        datos=leer.next().split("/");
        this.finAlquiler = new Date(Integer.parseInt(datos[2])-1900,Integer.parseInt(datos[1])-1,Integer.parseInt(datos[0]));
        System.out.print(  "          Código de amarre -> ");
        this.posicionAmarre = leer.nextInt();
    }
}
