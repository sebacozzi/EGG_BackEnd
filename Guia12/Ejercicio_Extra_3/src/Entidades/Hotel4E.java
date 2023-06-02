/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enumeradores.TipoGimnasio;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Hotel4E extends Hotel{
    protected TipoGimnasio gimnasio;
    protected String nombreRestaurante;
    protected int capacidadRestaurante;

    public Hotel4E() {
    }

    public Hotel4E(TipoGimnasio gimnasio, String nombreRestaurante, int capacidadRestaurante,
            int cantidadHabitaciones, int numeroCamas, int cantidadPisos) {
        super(cantidadHabitaciones, numeroCamas, cantidadPisos);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    @Override
    public int getPrecioHabitacion() {
        
        return super.getPrecioHabitacion()+this.gimnasio.getPrecio();
    }

    public TipoGimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(TipoGimnasio gimnasio) {
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
        
        System.out.print("¿Que tipo de gimnasio tiene?\n"
                + "   1) Gimnasio Clase \"A\".\n"
                + "   2) Gimnasio Clase \"B\".\n");
        boolean continuar;
        do {
            continuar = false;
            System.out.print(" -> ");
            switch (leer.nextInt()) {
                case 1:
                    this.gimnasio= TipoGimnasio.CLASEA;
                    break;
                case 2:
                    this.gimnasio= TipoGimnasio.CLASEB;
                    break;
                default:
                System.out.println("Opcion incorrecta. Ingresar 1 o 2.");
                continuar = true;
            }
        } while (continuar);
        
        System.out.print("Ingresar el nombre del restaurante: ");
        this.nombreRestaurante = leer.next();
        System.out.print("Ingresar la capacidad del restaurante: ");
        this.capacidadRestaurante = leer.nextInt();
    }
    
}
