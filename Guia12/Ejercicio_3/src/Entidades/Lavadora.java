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
public class Lavadora extends Electrodomestico{
    private Double carga;

    public Lavadora() {
    }

    public Lavadora(Double carga) {
        this.carga = carga;
    }

    public Lavadora(Double carga, Double precio, String color, char consumoEnergetico, Double peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public void crearLavadora(){
        // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
// que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
// lea hasta el salto de linea
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        super.crearElectrodomestico();
        System.out.print("Ingresar la capacidad de carga de la lavadora en kg.: ");
        this.carga = leer.nextDouble();
    }
    @Override
    public Double precioFinal(){
        if (this.carga>30) {
            return super.precioFinal()+500;
        }
        return super.precioFinal();
    }
}
