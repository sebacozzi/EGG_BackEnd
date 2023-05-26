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
public class BarcoAMotor extends Barco{
    private Double cv;

    public BarcoAMotor() {
    }

    public BarcoAMotor(Double cv, String matrícula, Double eslora, int añoDeFabricacion) {
        super(matrícula, eslora, añoDeFabricacion);
        this.cv = cv;
    }

    public Double getCv() {
        return cv;
    }

    public void setCv(Double cv) {
        this.cv = cv;
    }

    @Override
    public Double valorModuloBarco() {
        return super.valorModuloBarco()+this.cv;
    }

    @Override
    public void crear() {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        super.crear();
        System.out.println("Datos particulares del barco a motor:");
        System.out.print(  "          Potencia del Motor en CV -> ");
        this.cv = leer.nextDouble();
        
    }
    
}
