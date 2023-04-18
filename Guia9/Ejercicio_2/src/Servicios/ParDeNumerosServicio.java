/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.ParDeNumeros;

/**
 *
 * @author Sebastian Cozzi
 */
public class ParDeNumerosServicio {

    /**
     * a) Método mostrarValores que muestra cuáles son los dos números
     * guardados.
     *
     * @param numeros
     */
    public void mostrarValores(ParDeNumeros numeros) {
        System.out.println(" Par de números:");
        System.out.println("-----------------");
        System.out.println("Número 1: " + numeros.getN1());
        System.out.println("Número 2: " + numeros.getN2());
        System.out.println("-----------------");
    }

    /**
     * b) Método devolverMayor para retornar cuál de los dos atributos tiene el
     * mayor valor
     *
     * @param numeros
     * @return
     */
    public double devolverMayor(ParDeNumeros numeros) {
        if (numeros.getN1() > numeros.getN2()) {
            return numeros.getN1();
        }
        return numeros.getN2();
    }

    private double devolverMenor(ParDeNumeros numeros) {
        if (numeros.getN1() > numeros.getN2()) {
            return numeros.getN2();
        }
        return numeros.getN1();
    }

    /**
     * c) Método calcularPotencia para calcular la potencia del mayor valor de
     * la clase elevado al menor número. Previamente se deben redondear ambos
     * valores.
     *
     * @param numeros
     * @return resultado de el número mayor elevado al menor
     */
    public long calcularPotencia(ParDeNumeros numeros) {
        int n1 = (int) Math.round(devolverMayor(numeros));
        int n2 = (int) Math.round(devolverMenor(numeros));
        System.out.println(String.format("Calculo: %d^%d", n1, n2));
        return (long) Math.pow(n1, n2);
    }

    public long calcularPotenciaV2(ParDeNumeros numeros) {
        int n1 = (int) Math.round(numeros.getN2());
        int n2 = (int) Math.round(numeros.getN1());
        if (devolverMayor(numeros) == numeros.getN1()) {
            n1 = (int) Math.round(numeros.getN1());
            n2 = (int) Math.round(numeros.getN2());
        }
        System.out.println(String.format("Calculo: %d^%d", n1, n2));
        return (long) Math.pow(n1, n2);
    }

    /**
     * d) Método calculaRaiz, para calcular la raíz cuadrada del menor de los
     * dos valores. Antes de calcular la raíz cuadrada se debe obtener el valor
     * absoluto del número.
     *
     * @param numeros
     * @return Devuelve el resultado de la raiz cuadrada del menor de
     * ParDeNumeros
     */
    public double calculaRaiz(ParDeNumeros numeros) {
        Double n = Math.abs(devolverMenor(numeros));
        System.out.println("ABS: " + n);
        return Math.sqrt(n);
    }

    public double calculaRaizV2(ParDeNumeros numeros) {
        double n = Math.abs(numeros.getN1());
        if (devolverMayor(numeros) == numeros.getN1()) {
            n = Math.abs(numeros.getN2());
        }
        System.out.println("ABS: " + n);
        return Math.sqrt(n);
    }
}
