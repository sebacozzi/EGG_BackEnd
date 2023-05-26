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
public class Televisor extends Electrodomestico {

    private Double resolucion;
    private Boolean tdt;

    public Televisor() {
    }

    public Televisor(Double resolucion, Boolean tdt, Double precio, String color, char consumoEnergetico, Double peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public Double getResolucion() {
        return resolucion;
    }

    public void setResolucion(Double resolucion) {
        this.resolucion = resolucion;
    }

    public Boolean getTdt() {
        return tdt;
    }

    public void setTdt(Boolean tdt) {
        this.tdt = tdt;
    }

    public void crearTelevisor() {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        char res;
        boolean reintentar;

        super.crearElectrodomestico();
        System.out.print("Ingresar la dimensión en pulgadas: ");
        this.resolucion = leer.nextDouble();
        System.out.println("¿Tiene receptor TDT? (s/n) ");
        do {
            System.out.print("  -> ");
            res = leer.next().charAt(0);
            reintentar = false;
            switch (res) {
                case 's':
                    this.tdt = true;
                    break;
                case 'S':
                    this.tdt = true;
                    break;
                case 'n':
                    this.tdt = false;
                    break;
                case 'N':
                    this.tdt = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    reintentar = true;
            }
        } while (reintentar);

    }

    @Override
    public Double precioFinal() {
        Double incTDT = 0d;
        double incResolucion = 0d;
        Double precioFinal = super.precioFinal();
        if (tdt) {
            incTDT = 500d;
        }
        if (this.resolucion > 40) {
            incResolucion = precioFinal * 0.3;
        }
        return precioFinal + incTDT + incResolucion;
    }
}
