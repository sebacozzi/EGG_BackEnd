/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Cozzi
 */
public class Juego {
    private ArrayList<Jugador> jugadores;
    private Revolver revolver;
    private int turno;

    public Juego() {
    }

    public void llenarJuego(ArrayList<Jugador> jugadores, Revolver r) {
        this.jugadores=jugadores;
        this.revolver = r;
        this.turno =1;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Revolver getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }    
}
