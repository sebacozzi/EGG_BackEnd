/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Velero extends Barco{
    private int mastiles;

    public Velero() {
    }
    
    public Velero(int mastiles, String matrícula, Double eslora, int añoDeFabricacion) {
        super(matrícula, eslora, añoDeFabricacion);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }

    @Override
    public Double valorModuloBarco() {
        return super.valorModuloBarco()+mastiles;
    }

    @Override
    public void crear() {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        super.crear(); 
        System.out.println("Datos particulares del velero: ");
        System.out.print(  "          Cantidad de Mastiles -> ");
        this.mastiles = leer.nextInt();
    }
    
}
