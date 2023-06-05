/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián Cozzi
 */
public final class Camping extends ExtraHotelero {
//    capacidad máxima de carpas, la cantidad de baños
//disponibles y si posee o no un restaurante

    private int capacidadDeCarpas;
    private int cantidadDeBaños;
    private boolean tieneRestaurante;

    public Camping() {
    }

    public Camping(int capacidadDeCarpas, int cantidadDeBaños, boolean tieneRestaurante, Boolean esPrivado, Double superficie) {
        super(esPrivado, superficie);
        this.capacidadDeCarpas = capacidadDeCarpas;
        this.cantidadDeBaños = cantidadDeBaños;
        this.tieneRestaurante = tieneRestaurante;
    }

    public int getCapacidadDeCarpas() {
        return capacidadDeCarpas;
    }

    public void setCapacidadDeCarpas(int capacidadDeCarpas) {
        this.capacidadDeCarpas = capacidadDeCarpas;
    }

    public int getCantidadDeBaños() {
        return cantidadDeBaños;
    }

    public void setCantidadDeBaños(int cantidadDeBaños) {
        this.cantidadDeBaños = cantidadDeBaños;
    }

    public boolean isTieneRestaurante() {
        return tieneRestaurante;
    }

    public void setTieneRestaurante(boolean tieneRestaurante) {
        this.tieneRestaurante = tieneRestaurante;
    }

    @Override
    public String toString() {
        String tiene = "";
        if (tieneRestaurante) {
            tiene = "Posee Restaurante";
        } else {
            tiene = "No posee";
        }
        return super.toString()
                +"Capacidad maxima de carpas: "+ capacidadDeCarpas+".\n"
                +"Cantidad de Baños: "+ cantidadDeBaños+".\n"
                +"Otras instalaciones: "+ tiene+".\n";
    }

    @Override
    public void crearAlAzar() {
        super.crearAlAzar();
        this.superficie= Math.random()*200000+100000;
        this.capacidadDeCarpas = (int) Math.round((this.superficie/2)/Math.pow(Math.random()*4+2, 2));
        this.tieneRestaurante=Math.round(Math.random())==1;
        this.cantidadDeBaños = (int) Math.round(Math.random()*10+6);
    }

}
