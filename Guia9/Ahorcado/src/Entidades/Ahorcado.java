/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Arrays;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ahorcado {

    private String palabra;
    private char[] letrasAcertadas;
    private int fallos;
    private char[] letras;
    private final String[][] dibujo;

    public Ahorcado() {
        this.dibujo = baseDibujo();
        
        this.letras = new char[6];
        this.fallos = 0;
        Arrays.fill(letras, ' ');
        Arrays.fill(letrasAcertadas, ' ');
    }

    public Ahorcado(String palabra) {
        this.palabra = palabra;
        this.dibujo = baseDibujo();
        this.letrasAcertadas = new char[palabra.length()];
        this.letras = new char[6];
        this.fallos = 0;
        Arrays.fill(letras, ' ');
        Arrays.fill(letrasAcertadas, ' ');
    }

    private String[][] baseDibujo() {
        String[][] di = {{"┌──┐ ", "│     ", "│      ", "│      ", "│       ", "│       ", "██████"},
                         {"┌──┐ ", "│   █ ", "│      ", "│      ", "│       ", "│       ", "██████"},
        {"┌──┐ ", "│   █ ", "│  /   ", "│      ", "│       ", "│       ", "██████"},
        {"┌──┐ ", "│   █ ", "│  / \\", "│      ", "│       ", "│       ", "██████"},
        {"┌──┐ ", "│   █ ", "│  /│\\", "│   │  ", "│       ", "│       ", "██████"},
        {"┌──┐ ", "│   █ ", "│  /│\\", "│   │  ", "│  /    ", "│       ", "██████"},
        {"┌──┐ ", "│   █ ", "│  /│\\", "│   │  ", "│  / \\ ", "│       ", "██████"}};
        return di;
    }
    public boolean letraEnPalabra(char letra){
        return palabra.contains(String.valueOf(letra));
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        if (fallos==6 || fallos==0) {
        this.palabra = palabra;
        this.letrasAcertadas = new char[palabra.length()];
        } else System.out.println("Eso es trampa... no se puede cambiar la palabra en medio del juego!!!");
    }

    public char[] getLetrasAcertadas() {
        return letrasAcertadas;
    }   

    public int getFallos() {
        return fallos;
    }

    public void incFallos() {
        this.fallos++;
    }
    public void resetFallos(){
        this.fallos =0;
        Arrays.fill(letras, ' ');
        Arrays.fill(letrasAcertadas, ' ');
    }
    public char[] getLetras() {
        return letras;
    }

    public void setLetras(char[] letras) {
        this.letras = letras;
    }
    
    @Override
    public String toString() {
        String resu = "---AHORCADO---\n";
        for (int i = 0; i < dibujo.length; i++) {
            resu = resu.concat(dibujo[fallos][i]).concat("\n");
        }
        resu = resu.concat("\n");
        /// letras acertadas
        
        int cont=0;
        for (int i = 0; i < palabra.length(); i++) {
            resu = resu.concat(String.valueOf(letraEnPosicion(this.palabra, i)));    
            if (letraEnPosicion(palabra, i)=='_') {
                cont++;
            }
        }
        
        resu = resu.concat(String.format("     faltan %d de %d letras.\n",cont,palabra.length()));
        resu = resu.concat(letrasErradas());

        return resu;
    }

    public char letraEnPosicion(String palabra, int pos) {
        for (int i = 0; i < this.letrasAcertadas.length; i++) {
            if (palabra.charAt(pos) == this.letrasAcertadas[i]) {
                return this.letrasAcertadas[i];
            }
        }
        return '_';
    }

    private String letrasErradas() {
        String resu = "";
        for (int i = 0; i < letras.length; i++) {
            resu = resu.concat(String.valueOf(letras[i]));
            if (i < letras.length - 1) {
                resu = resu.concat("-");
            }
        }
        return resu;
    }
}
