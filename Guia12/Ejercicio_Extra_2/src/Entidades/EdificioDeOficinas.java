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
public class EdificioDeOficinas extends Edificio {

    private Integer cantidadOficinas;
    private Integer cantidadPersonasXOficina;
    private Integer cantidadDePisos;

    public EdificioDeOficinas() {

    }

    public EdificioDeOficinas(Integer cantidadOficinas, Integer cantidadPersonasXOficina, Integer cantidadDePisos, Double ancho, Double alto, Double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.cantidadDePisos = cantidadDePisos;
        if (cantidadOficinas>cantidadDePisos) {
            this.cantidadOficinas= cantidadDePisos;
        }else{
        this.cantidadOficinas = cantidadOficinas;
        }
        this.cantidadPersonasXOficina = cantidadPersonasXOficina;
    }

    public Integer getCantidadOficinas() {
        return cantidadOficinas;
    }

    public void setCantidadOficinas(Integer cantidadOficinas) {
        if (cantidadOficinas>cantidadDePisos) {
            this.cantidadOficinas = this.cantidadDePisos;
        }else{
        this.cantidadOficinas = cantidadOficinas;
        }
    }

    public Integer getCantidadPersonasXOficina() {
        return cantidadPersonasXOficina;
    }

    public void setCantidadPersonasXOficina(Integer cantidadPersonasXOficina) {
        this.cantidadPersonasXOficina = cantidadPersonasXOficina;
    }

    public Integer getCantidadDePisos() {
        return cantidadDePisos;
    }

    public void setCantidadDePisos(Integer cantidadDePisos) {
        if (cantidadDePisos>this.cantidadOficinas) {
            System.out.println("La cantidad de pisos no puede ser mayor que la cantidad de oficinas.");
        }else{
        this.cantidadDePisos = cantidadDePisos;
        }
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public void cantPersonas(){
        System.out.printf("En el edificio pueden trabajar %d personas.\n",cantidadOficinas*cantidadPersonasXOficina);
        
        System.out.printf("%.0f son las personas que trabajan en cada piso.\n", (cantidadPersonasXOficina*cantidadOficinas)/cantidadDePisos);
    }
    
    
    @Override
    public Double calcularSuperficie() {
        return this.ancho * this.largo * this.cantidadDePisos;
    }

    @Override
    public Double calcularVolumen() {
        return this.alto * this.ancho * this.largo;
    }

}
