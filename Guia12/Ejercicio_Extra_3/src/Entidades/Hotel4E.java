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
public class Hotel4E extends Hotel{
    private boolean gimnasio;
    private String nombreRestaurante;
    private int capacidadRestaurante;

    public Hotel4E() {
    }

    public Hotel4E(boolean gimnasio, String nombreRestaurante, int capacidadRestaurante, int cantidadHabitaciones, int numeroCamas, int cantidadPisos, double precioHabitacion) {
        super(cantidadHabitaciones, numeroCamas, cantidadPisos, precioHabitacion);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    public boolean tieneGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(boolean gimnasio) {
        this.gimnasio = gimnasio;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public int getCapacidadRestaurante() {
        return capacidadRestaurante;
    }

    public void setCapacidadRestaurante(int capacidadRestaurante) {
        this.capacidadRestaurante = capacidadRestaurante;
    }

    @Override
    public void crearHotel() {
        super.crearHotel();
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        
        System.out.print("¿Tiene gimnasio? <(S)i/(N)o>\n");
        do {
            System.out.print(" -> ");
            if (leer.next().toUpperCase().charAt(0)=='S') {
                this.gimnasio = true;
                break;
            }else if (leer.next().toUpperCase().charAt(0)=='n') {
               this.gimnasio= false;
               break;
            }else
                System.out.println("Opcion incorrecta. Ingresar S o N.");
        } while (true);
        
        System.out.print("Ingresar el nombre del restaurante: ");
        this.nombreRestaurante = leer.next();
        System.out.print("Ingresar la capacidad del restaurante: ");
        this.capacidadRestaurante = leer.nextInt();
    }
    
}
