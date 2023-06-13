/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import Enums.Color;
import Piezas.*;

/**
 *
 * @author Sebastián Cozzi
 */
public class Armadura {
    
    private Guante guanteIzquierdo;
    private Guante guanteDerecho;
    private Cuerpo cuerpo;
    private Bota botaDerecha;
    private Bota botaIzquierda;
    private Casco casco;
    private Generador generador;
    private Color colorPrimario;
    private Color colorSecundario;

    public Armadura() {
    }

    public Armadura(Guante guanteIzquierdo, Guante guanteDerecho, Cuerpo cuerpo, Bota botaDerecha, Bota botaIzquierda, Casco casco, Color colorPrimario, Color colorSecundario) {
        this.guanteIzquierdo = guanteIzquierdo;
        this.guanteDerecho = guanteDerecho;
        this.cuerpo = cuerpo;
        this.botaDerecha = botaDerecha;
        this.botaIzquierda = botaIzquierda;
        this.casco = casco;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }
    
    public void caminar()
}
