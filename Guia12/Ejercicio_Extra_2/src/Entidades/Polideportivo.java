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
public class Polideportivo extends Edificio{
    private Boolean abierto;
    private String nombre;

    public Polideportivo() {
    }

    public Polideportivo(Boolean abierto, String nombre, Double ancho, Double alto, Double largo) {
        this.ancho=ancho;
        this.alto= alto;
        this.largo=largo;
        this.abierto = abierto;
        this.nombre = nombre;
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

    public Boolean getAbierto() {
        return abierto;
    }
    
    public void setAbierto(Boolean abierto) {
        this.abierto = abierto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo(){
        if (abierto) {
            return "Abierto";
        }else
            return "Techado";
    }
    
    @Override
    public Double calcularSuperficie() {
     return super.ancho*super.largo;
    }

    @Override
    public Double calcularVolumen() {
        if (abierto) {
            return 0d;
        }
        return super.alto*super.ancho*super.largo;
    }

    
}
