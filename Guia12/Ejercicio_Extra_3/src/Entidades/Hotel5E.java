/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enumeradores.Gimnasio;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Hotel5E extends Hotel4E{
    private int cantidadSalonesConferencia;
    private int cantidadSuites;
    private int cantidadLimosinas;

    public Hotel5E() {
    }

    public Hotel5E(int cantidadSalonesConferencia, int cantidadSuites, int cantidadLimosinas, Gimnasio gimnasio,
            String nombreRestaurante, int capacidadRestaurante, int cantidadHabitaciones, int numeroCamas, int cantidadPisos) {
        super(gimnasio, nombreRestaurante, capacidadRestaurante, cantidadHabitaciones, numeroCamas, cantidadPisos);
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
        this.cantidadSuites = cantidadSuites;
        this.cantidadLimosinas = cantidadLimosinas;
    }

    @Override
    public String estrellas() {
        return "5";
    }

    @Override
    public void cargarDatos() {
        super.cargarDatos();
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.print("Ingrese la cantidad de salones de conferencia: ");
        this.cantidadSalonesConferencia = leer.nextInt();
        System.out.print("Ingrese la cantidad de suites: ");
        this.cantidadSuites = leer.nextInt();
        System.out.print("Ingrese la cantidad de limosinas: ");
        this.cantidadLimosinas = leer.nextInt();
    }

    public int getCantidadSalonesConferencia() {
        return cantidadSalonesConferencia;
    }

    public void setCantidadSalonesConferencia(int cantidadSalonesConferencia) {
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
    }

    public int getCantidadSuites() {
        return cantidadSuites;
    }

    public void setCantidadSuites(int cantidadSuites) {
        this.cantidadSuites = cantidadSuites;
    }

    public int getCantidadLimosinas() {
        return cantidadLimosinas;
    }

    public void setCantidadLimosinas(int cantidadLimosinas) {
        this.cantidadLimosinas = cantidadLimosinas;
    }

    @Override
    public int PrecioHabitacion() {
        return super.PrecioHabitacion() + 15 * cantidadLimosinas;
    }

    @Override
    public String toString() {
        return super.toString()
                +"Cantidad de Salones para Conferencias: " + cantidadSalonesConferencia + ".\n"
                + "Cantidad de Suites:" + cantidadSuites + ".\n"
                + "Cantidad de Limosinas: " + cantidadLimosinas + ".\n";
    }

    @Override
    public void crearAlAzar() {
        super.crearAlAzar(); 
        cantidadSalonesConferencia = (int) Math.round(Math.random()*5+1);
        cantidadSuites = (int) Math.round(Math.random()*10+1);
        cantidadLimosinas = (int) Math.round(Math.random()*10+1);
    }

    
}
