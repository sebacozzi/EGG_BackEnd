/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;



/**
 *
 * @author Sebastian Cozzi
 */
public class Hotel {
    protected int cantidadHabitaciones;
    protected int numeroCamas;
    protected int cantidadPisos;
    protected int precioHabitacion;

    public Hotel() {
    }

    public Hotel(int cantidadHabitaciones, int numeroCamas, int cantidadPisos) {
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.numeroCamas = numeroCamas;
        this.cantidadPisos = cantidadPisos;
        //this.precioHabitacion = precioHabitacion;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public int getPrecioHabitacion() {
        return 50+this.numeroCamas;
    }

    public void setPrecioHabitacion(int precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    
    public void crearHotel(){
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.println("Datos del Hotel:");
        
        System.out.print("Ingrese la cantidad de habitaciones: ");
        this.cantidadHabitaciones = leer.nextInt();
        System.out.print("Ingrese la cantidad de camas en el hotel: ");
        this.numeroCamas = leer.nextInt();
        System.out.print("Ingrese la cantidad de pisos: ");
        this.cantidadPisos = leer.nextInt();
    }
}
