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

    // Varible donde se almacenan las letras de la palabra
    private char[] palabra;
    // array donde se van almacenar las letras ingresadas que pertenecen a la palabra
    // la verificación si pertenecen es externa
    private char[] acertadas;
    //Contador de las letras ingresadas correctamente
    private int contadorAcertadas;
    // Contador de intentos va a tener disponibles
    private int contadorIntentos;
    // Contador de veces el usuario no descubrio la letra
    private int contadorErradas;

    /**
     * Constructor vacio para inicializar <b>Ahorcado</b>
     * Inicializa <b>contadorErradas</b> en 0, <b>contadorAcertadas</b> en 0,
     * @see #Ahorcado(java.lang.String, int)
     * @see #Ahorcado(char[], int) 
     */
    public Ahorcado() {
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
    }

    /**
     * Constructor con parametro para inicializar <b>Ahorcado</b>
     * Convierte el String de palabra en array de char Inicializa
     * <b>contadorErradas</b> en 0, <b>contadorAcertadas</b> en 0,
     * <b>acertadas</b> con la longitud de palabra y lo llena con espacios
     *
     * @param palabra <b>String</b> con la palabra a descubrir
     * @param cantidadIntentos <b>int</b> Cantidad de intentos que va a tener el
     * participante para equivocarse de letra
     * 
     * @see #Ahorcado() 
     * @see #Ahorcado(char[], int) 
     */
    public Ahorcado(String palabra, int cantidadIntentos) {
        this.palabra = palabra.toCharArray();
        this.acertadas = new char[this.palabra.length];
        this.contadorIntentos = cantidadIntentos;
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
        Arrays.fill(this.acertadas, ' ');
    }

    /**
     * Constructor con parametro para inicializar <b>Ahorcado</b>
     * Inicializa <b>contadorErradas</b> en 0, <b>contadorAcertadas</b> en 0,
     * <b>acertadas</b> con la longitud de palabra y lo llena con espacios
     *
     * @param palabra <b>array de char</b> con las letras de la palabra
     * @param cantidadIntentos <b>int</b> Cantidad de intentos que va a tener el
     * participante para equivocarse de letra
     * 
     * @see #Ahorcado() 
     * @see #Ahorcado(java.lang.String, int) 
     */
    public Ahorcado(char[] palabra, int cantidadIntentos) {
        this.palabra = palabra;
        this.acertadas = new char[this.palabra.length];
        this.contadorIntentos = cantidadIntentos;
        this.contadorErradas = 0;
        this.contadorAcertadas = 0;
        Arrays.fill(this.acertadas, ' ');
    }

    /**
     * Metodo que incrementa el contador de letras que no estan en la palabra
     */
    public void setContadorErradas() {
        this.contadorErradas++;
    }

    /**
     * Metodo que sirve para obtener las letras que se ingresaron correctamente
     *
     * @return char[] contiene la letras acertadas
     */
    public char[] getAcertadas() {
        return this.acertadas;
    }

    /**
     * Metodo que permite enviar una letra (tipo char) y la agrega al final del
     * array
     *
     * @param letra char
     * @see #setAcertadas(char[]) 
     */
    public void setAcertadas(char letra) {
        for (int i = 0; i < this.acertadas.length; i++) {
            if (this.acertadas[i] == ' ') {
                this.acertadas[i] = letra;
                this.contadorAcertadas++;
                return;
            }
        }
    }

    /**
     * Metodo que permite cargar el array de letras adivinadas
     *
     * @param letras char[] array de char
     * @see #setAcertadas(char) 
     */
    public void setAcertadas(char[] letras) {
        this.acertadas = letras;
    }

    /**
     * Metodo que retorna la palabra como un array de char
     *
     * @return char[]
     */
    public char[] getPalabra() {
        return palabra;
    }

    /**
     * Retorna la palabra en formato String
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.copyValueOf(palabra);
    }

    /**
     * Retorna el estado del <b>contador</b> de las letras acetadas
     *
     * @return <b>int</> contadorAcertadas
     */
    public int getContadorAcertadas() {
        return this.contadorAcertadas;
    }

    /**
     * Metodo que retorna la cantidad de intentos total
     *
     * @return int
     */
    public int getContadorIntentos() {
        return contadorIntentos;
    }

    /**
     * Metodo que permite inicializar la cantidad de veces que el segundo
     * jugador va a poder equivocarse de letra
     *
     * @param contIntentos int
     */
    public void setContIntentos(int contIntentos) {
        this.contadorIntentos = contIntentos;
    }

    /**
     * Metodo que retorna la cantidad de letras que se ingresaron y no
     * pertenecen a la palabra
     *
     * @return int
     */
    public int getContadorErradas() {
        return contadorErradas;
    }

    /**
     * Metodo que permite mostrar la palabra a descubrir
     *
     * @return Retorna String con las letras descubiertas y espacios, las letras
     * no descubiertas las reemplaza con "_"
     */
    public String getAyuda() {
        String enco = String.copyValueOf(this.acertadas);
        String resu = "";
        for (char c : palabra) {
            if (c == ' ') {
                resu += c;
            } else if (!enco.contains(String.valueOf(c))) {
                resu += '_';
            } else {
                resu += c;
            }
        }
        return resu;
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
