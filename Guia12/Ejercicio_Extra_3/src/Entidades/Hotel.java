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
public class Hotel extends Lugar {

    protected int cantidadHabitaciones;
    protected int numeroCamas;
    protected int cantidadPisos;

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

    public String estrellas() {
        return "";
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

    @Override
    public String toString() {
        return "Datos del Hotel:\n"
                + "Tipo de Hotel: Hotel " + estrellas() + " estrellas.\n"
                + "Cantidad de Habitaciones: " + cantidadHabitaciones
                + ".\nNúmero de Camas: " + numeroCamas
                + ".\nCantidad de Pisos: " + cantidadPisos
                + ".\nPrecio de la Habitacion: " + PrecioHabitacion() + ".\n";
    }

    public int PrecioHabitacion() {
        return 50 + numeroCamas;
    }

    @Override
    public void crearAlAzar() {
        this.cantidadPisos = (int) Math.round(Math.random() * 15 + 1);
        this.cantidadHabitaciones = (int) Math.round(cantidadPisos * Math.random() * 6 + 1);
        this.numeroCamas = (int) Math.round(cantidadHabitaciones * Math.random() * 5 + 1);
    }

    @Override
    public void cargarDatos() {
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
