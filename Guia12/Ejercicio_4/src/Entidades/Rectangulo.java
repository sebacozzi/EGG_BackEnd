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
public class Rectangulo implements calculoFormas{
    private Double altura;
    private Double base;

    public Rectangulo(Double altura, Double base) {
        this.altura = altura;
        this.base = base;
    }

    public Rectangulo() {
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    @Override
    public Double calcularSuperficie() {
        return this.base * this.altura;
    }

    @Override
    public Double calcularPerimetro() {
        return this.base*2 + this.altura*2;
    }
    
    
}
