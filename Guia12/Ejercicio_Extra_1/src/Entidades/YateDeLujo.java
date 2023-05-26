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
public class YateDeLujo extends BarcoAMotor{
    private int cantidadDeCamarotes;

    public YateDeLujo() {
    }

    public YateDeLujo(int cantidadDeCamarotes, Double cv, String matrícula, Double eslora, int añoDeFabricacion) {
        super(cv, matrícula, eslora, añoDeFabricacion);
        this.cantidadDeCamarotes = cantidadDeCamarotes;
    }

    public int getCantidadDeCamarotes() {
        return cantidadDeCamarotes;
    }

    public void setCantidadDeCamarotes(int cantidadDeCamarotes) {
        this.cantidadDeCamarotes = cantidadDeCamarotes;
    }

    @Override
    public Double valorModuloBarco() {
        return super.valorModuloBarco()+this.cantidadDeCamarotes; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear() {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        super.crear(); 
        System.out.println("Dato particular del yate de lujo:");
        System.out.print(  "          Matricula -> ");
        this.cantidadDeCamarotes = leer.nextInt();
    }
    
    
    
}
