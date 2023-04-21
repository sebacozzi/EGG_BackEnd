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
public class Ahorcado {

    private char[] palabra;
    private char[] acertadas;
    private int contadorAcertadas;
    private int contadorIntentos;
    private int contadorErradas;
//    private char[] erradas;

    public Ahorcado() {
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
    }

    public Ahorcado(String palabra, int cantidadIntentos) {
        this.palabra = palabra.toCharArray();
        this.acertadas = new char[this.palabra.length];
        this.contadorIntentos = cantidadIntentos;
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
//        this.erradas=new char[cantidadIntentos];
//        Arrays.fill(this.acertadas,' ');
//        Arrays.fill(this.erradas,' '); 
    }

    public Ahorcado(char[] palabra, int cantidadIntentos) {
        this.palabra = palabra;
        this.acertadas = new char[this.palabra.length];
        this.contadorIntentos = cantidadIntentos;
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
    }

    public void setContadorErradas() {
        this.contadorErradas++;
    }

    public char[] getAcertadas() {
        return this.acertadas;
    }

    public void setAcertadas(char letra) {
        for (int i = 0; i < this.acertadas.length; i++) {
            if (this.acertadas[i] == ' ') {
                this.acertadas[i] = letra;
                this.contadorAcertadas = i + 1;
                return;
            }
        }
    }

    public void setAcertadas(char[] letras) {
        this.acertadas = letras;
    }

    public char[] getPalabra() {
        return palabra;
    }

    public int getContadorAcertadas() {
        return this.contadorAcertadas;
    }

    public int getContadorIntentos() {
        return contadorIntentos;
    }

    public void setContIntentos(int contIntentos) {
        this.contadorIntentos = contIntentos;
    }

    public int getContadorErradas() {
        return contadorErradas;
    }

//    @Override
//    public String toString() {
//        String resultado="%s    Faltan %d de %d\n%s";
//        int contCorrectas=0;
//        String sAcertadas="";
//        for (int i = 0; i < this.palabra.length; i++) {
//            if (letraEnPosicion()) {
//                
//            }
//        }
//        String sErra="";
//        for (int i = 0; i < this.erradas.length; i++) {
//            sErra= sErra.concat(String.valueOf(this.erradas[i]));
//            if (i<this.erradas.length-1) {
//                sErra= sErra.concat(" - ");
//                
//            }
//        }
//        
//        return String.format(resultado, sAcertadas, contCorrectas, this.palabra.length,sErra);
//    }
//    
//    private boolean caracterEnPosicion(char letra,int pos){
//        
//    }
}
