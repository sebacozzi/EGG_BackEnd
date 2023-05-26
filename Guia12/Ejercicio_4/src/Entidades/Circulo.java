/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastian Cozzi
 */
public class Circulo implements calculoFormas{
    private Double radio;
    private Double diametro;

    public Circulo() {
    }

    public Circulo(Double radio) {
        this.radio = radio;
        this.diametro = radio*2;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
        this.diametro = radio*2;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
        this.radio = diametro/2;
    }

    @Override
    public Double calcularSuperficie() {
        return PI * Math.pow(this.radio, 2);
    }

    @Override
    public Double calcularPerimetro() {
        return PI * this.diametro;
    }
     
}
