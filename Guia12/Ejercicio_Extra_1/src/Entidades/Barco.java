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
public class Barco {
    protected String matrícula;
    protected Double eslora;
    protected int añoDeFabricacion;

    protected Barco() {
    }

    protected Barco(String matrícula, Double eslora, int añoDeFabricacion) {
        this.matrícula = matrícula;
        this.eslora = eslora;
        this.añoDeFabricacion = añoDeFabricacion;
    }

    public String getMatrícula() {
        return matrícula;
    }

    public void setMatrícula(String matrícula) {
        this.matrícula = matrícula;
    }

    public Double getEslora() {
        return eslora;
    }

    public void setEslora(Double eslora) {
        this.eslora = eslora;
    }

    public int getAñoDeFabricacion() {
        return añoDeFabricacion;
    }

    public void setAñoDeFabricacion(int añoDeFabricacion) {
        this.añoDeFabricacion = añoDeFabricacion;
    }
    
    public Double valorModuloBarco(){
        return this.eslora*10;
    }
    
    public void crear(){
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        System.out.println("Ingresar los datos generales de la enbarcación: ");
        System.out.print(  "          Matricula -> ");
        this.matrícula = leer.next();
        System.out.print(  "          Eslora -> ");
        this.eslora = leer.nextDouble();
        System.out.print(  "          Año de Fabricación -> ");
        this.añoDeFabricacion = leer.nextInt();
    }
}
