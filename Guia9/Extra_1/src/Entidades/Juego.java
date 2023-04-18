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
public class Juego {
    private String[] meses;
    private String oculto;

    public Juego(String[] meses, String oculto) {
        this.meses = meses;
        this.oculto = oculto;
    }

    public Juego() {
    }

    public String[] getMeses() {
        return meses;
    }

    public void setMeses(String[] meses) {
        this.meses = meses;
    }

    public String getOculto() {
        return oculto;
    }

    public boolean esOculto(String mes) {
        return oculto.equals(mes);
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }
  
}
