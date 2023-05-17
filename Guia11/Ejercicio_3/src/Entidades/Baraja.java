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
public class Baraja {

    private ArrayList<Carta> maso;
    private ArrayList<Carta> monton;

    public Baraja() {
        this.maso = new ArrayList();
        this.monton = new ArrayList();
    }

    public Baraja(ArrayList<Carta> maso) {
        this.maso = maso;
        this.monton = new ArrayList();
    }

    public ArrayList<Carta> getmaso() {
        return maso;
    }

    public void setCartas(ArrayList<Carta> maso) {
        this.maso = maso;
    }

    public ArrayList<Carta> getMonton() {
        return monton;
    }

    public void setDadas(ArrayList<Carta> monton) {
        this.monton = monton;
    }

    public void agregaCarta(Carta carta) {
        this.maso.add(carta);
    }

    public Carta darCarta(Carta carta) {
        if (!maso.remove(carta)) {
            return null;
        }
        if (!monton.add(carta)) {
            return null;
        }
        return carta;
    }

    public String toStringMaso() {
        String resultado = "Baraja{maso}\n";
        for (Carta carta : maso) {
            resultado = resultado.concat("  " + carta.toString() + "\n");
        }
        return resultado;
    }

    public String toStringMonton() {
        String resultado = "Baraja{dadas}\n";
        for (Carta carta : monton) {
            resultado = resultado.concat("  " + carta.toString() + "\n");
        }
        return resultado;
    }

}
