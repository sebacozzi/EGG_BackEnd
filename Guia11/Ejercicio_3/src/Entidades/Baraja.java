/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashSet;

/**
 *
 * @author Sebastián Cozzi
 */
public class Baraja {

    private HashSet<Carta> maso;
    private HashSet<Carta> dadas;

    public Baraja() {
        this.maso = new HashSet();
        this.dadas = new HashSet();
    }

    public Baraja(HashSet<Carta> maso) {
        this.maso = maso;
        this.dadas = new HashSet();
    }

    public HashSet<Carta> getmaso() {
        return maso;
    }

    public void setCartas(HashSet<Carta> maso) {
        this.maso = maso;
    }

    public HashSet<Carta> getDadas() {
        return dadas;
    }

    public void setDadas(HashSet<Carta> dadas) {
        this.dadas = dadas;
    }

    public void agregaCarta(Carta carta) {
        this.maso.add(carta);
    }

    public Carta darCarta(Carta carta) {
        if (maso.remove(carta)) {
            return null;
        }
        if (dadas.add(carta)) {
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

    public String toStringDadas() {
        String resultado = "Baraja{dadas}\n";
        for (Carta carta : dadas) {
            resultado = resultado.concat("  " + carta.toString() + "\n");
        }
        return resultado;
    }

}
