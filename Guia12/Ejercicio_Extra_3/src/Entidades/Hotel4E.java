/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enumeradores.Gimnasio;
import Enumeradores.Restaurante;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Hotel4E extends Hotel {

    protected Gimnasio gimnasio;
    protected String nombreRestaurante;
    protected int capacidadRestaurante;
    private Restaurante tipoRestaurante;

    public Hotel4E() {
    }

    public Hotel4E(Gimnasio gimnasio, String nombreRestaurante, int capacidadRestaurante,
            int cantidadHabitaciones, int numeroCamas, int cantidadPisos) {
        super(cantidadHabitaciones, numeroCamas, cantidadPisos);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
        setTipoResto();
    }

    @Override
    public int PrecioHabitacion() {
        return super.PrecioHabitacion()
                + this.gimnasio.getPrecio()
                + this.tipoRestaurante.getPrecio();
    }

    @Override
    public String estrellas() {
        return "4"; 
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }
//    Valor agregado por el restaurante:
//• $10 si la capacidad del restaurante es de menos de 30 personas.
//• $30 si está entre 30 y 50 personas.
//• $50 si es mayor de 50.

    private void setTipoResto() {
        switch (this.capacidadRestaurante < 30 ? 1
                : this.capacidadRestaurante >= 30 && this.capacidadRestaurante < 50 ? 2
                        : this.capacidadRestaurante >= 50 ? 3 : 0) {
            case 1:
                this.tipoRestaurante = Restaurante.CHICO;
                break;
            case 2:
                this.tipoRestaurante = Restaurante.MEDIANO;
                break;
            case 3:
                this.tipoRestaurante = Restaurante.GRANDE;
                break;
            default:
                throw new AssertionError();
        }
    }

    public void setGimnasio(Gimnasio gimnasio) {
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
        setTipoResto();
    }

    @Override
    public void cargarDatos() {
        super.cargarDatos();
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
                    this.gimnasio = Gimnasio.CLASEA;
                    break;
                case 2:
                    this.gimnasio = Gimnasio.CLASEB;
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
        setTipoResto();
    }

    @Override
    public String toString() {
        return super.toString()+ "Nombre del Restaurante: "+ nombreRestaurante + ".\n"
                +"Caracteristicas del restaurante: "+ tipoRestaurante.getDescripcion() + ".\n"
                +"Capacidad del restaurante: "+ capacidadRestaurante+".\n"
                +"Tipo de Gimnasio: "+ gimnasio.getDescripcion()+".\n";
    }

    @Override
    public void crearAlAzar() {
        String[] ln={"El Sabor Delicioso", "La Cocina Tradicional", "Sabores Exquisitos", "Comedor El Rincón", "Delicias Gastronómicas", "Sazón Auténtico", "El Buen Apetito", "Gusto y Sabor", "Rincón de Sabores", "Cocina Casera", "Sabor y Tradición", "El Bocado Feliz", "Sabores Del Mundo", "Comedor El Paladar", "La Mesa Feliz"};
        super.crearAlAzar();
        switch ((int) Math.round(Math.random())) {
            case 0:
                gimnasio= Gimnasio.CLASEA;
                break;
            case 1:
                gimnasio= Gimnasio.CLASEB;
                break;
        }
        this.nombreRestaurante =ln[(int)Math.round(Math.random()*ln.length)];
        this.capacidadRestaurante = (int)Math.round(Math.random()*100);
        setTipoResto();
    }
    
    
}
