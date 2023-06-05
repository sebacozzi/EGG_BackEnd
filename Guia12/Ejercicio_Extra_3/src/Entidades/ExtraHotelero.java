/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class ExtraHotelero extends Lugar {

    protected Boolean esPrivado;
    protected Double superficie;

    public ExtraHotelero(Boolean esPrivado, Double superficie) {
        this.esPrivado = esPrivado;
        this.superficie = superficie;
    }

    public ExtraHotelero() {
    }

    public Boolean getEsPrivado() {
        return esPrivado;
    }

    public void setEsPrivado(Boolean esPrivado) {
        this.esPrivado = esPrivado;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        String pri;
        if (esPrivado) {
            pri = "Privado";
        } else {
            pri = "Publico";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return "Datos del Alojamiento Extra Hotelero:\n"
                + "Tipo de Alojamiento: " + this.getClass().getSimpleName() + ".\n"
                + "Alojamiento: " + pri + ".\n"
                + "Superficie: " + df.format(superficie) + "m2.\n";
    }

    @Override
    public void crearAlAzar() {
        this.esPrivado = Math.round(Math.random()) == 1;
        this.superficie = Math.random() * 1000 + 1000;
    }

    @Override
    public void cargarDatos() {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.println("Esta cargando los datos de " + this.getClass().getSimpleName() + '.');
        System.out.print("¿El Alojamiento es privado? (S/N)");
        boolean salida;
        do {
            salida = false;
            System.out.print("-> ");
            switch (leer.next().toUpperCase().charAt(0)) {
                case 'S':
                    this.esPrivado = true;
                    break;
                case 'N':
                    this.esPrivado = false;
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese S o N.");
                    salida = true;
            }

        } while (salida);
        System.out.print("Ingrese la superficie en m2: ");
        this.superficie = leer.nextDouble();
    }
}
