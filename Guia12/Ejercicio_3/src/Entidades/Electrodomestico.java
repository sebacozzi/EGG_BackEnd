/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Electrodomestico {

    private final String[] COLORVALIDO = {"BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS"};
    private final String CONSUMOVALIDO = "ABCDEF";

    protected Double precio;
    protected String color;
    protected char consumoEnergetico;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumoEnergetico, Double peso) {
        this.precio = precio;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        if (CONSUMOVALIDO.contains(String.valueOf(letra).toUpperCase())) {
            return Character.toUpperCase(letra);
        } else {
            return 'F';
        }
    }

    private String comprobarColor(String color) {
        if (Arrays.asList(COLORVALIDO).contains(color.toUpperCase())) {
            return Character.toUpperCase(color.charAt(0)) + color.substring(1, color.length());
        }
        return "Blanco";
    }

    protected void crearElectrodomestico() {
        // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
// que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
// lea hasta el salto de linea
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

        System.out.print("Ingresar el precio del Electrodomestico (Minimo $1000): ");
        this.precio = leer.nextDouble();
        if (this.precio < 1000) {
            this.precio = 1000d;
        }
        System.out.print("Ingresar el peso del Electrodomestico en Kg.: ");
        this.peso = leer.nextDouble();
        System.out.print("Colores validos:\n     Blanco, Negro, Rojo, Azul y Gris.\n    Ingresar el color: ");
        this.color = comprobarColor(leer.next());
        System.out.print("Ingresar el Consumo Energético (\"A\" a \"F\"): ");
        this.consumoEnergetico = comprobarConsumoEnergetico(leer.next().charAt(0));
    }

    public Double precioFinal() {
        double incConsumo = 1000d;
        double incPeso = 0d;
        switch (this.consumoEnergetico) {
            case 'B':
                incConsumo = 800;
                break;
            case 'C':
                incConsumo = 600;
                break;
            case 'D':
                incConsumo = 500;
                break;
            case 'E':
                incConsumo = 300;
                break;
            case 'F':
                incConsumo = 100;
        }

        if (this.peso >0 && this.peso < 20) {
            incPeso = 100;
        } else if (this.peso >= 20 && this.peso < 50) {
            incPeso = 500;
        } else if (this.precio >= 50 && this.peso < 80) {
            incPeso = 800;
        } else {
            incPeso = 1000;
        }
        return this.precio + incConsumo + incPeso;
    }
}
