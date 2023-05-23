/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashMap;

/**
 *
 * @author Sebastián Cozzi
 */
public class Cine {

    //private HashMap<String, Boolean> sala;
    private HashMap<String, Expectador> sala;
    private Pelicula pelicula;
    private Double precioEntrada;

    public Cine(Pelicula pelicula, Double precioEntrada) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        sala = creaSalaVacia();
    }

    public Cine() {
    this.pelicula = new Pelicula();
    this.precioEntrada = 50.45;
        sala = creaSalaVacia();
    }

    public HashMap<String, Expectador> getSala() {
        return sala;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

//    private HashMap<String, Boolean> creaSalaVacia() {
//        String[] letras = {"A", "B", "C", "D", "E", "F"};
//        HashMap<String, Boolean> resu = new HashMap<>();
//        for (int i = 8; i > 0; i--) {
//            for (int j = 0; j < 6; j++) {
//                resu.put(String.valueOf(i).concat(letras[j]), 1 == Math.round(Math.random() * 2));
//            }
//        }
//        return resu;
//    }
    private HashMap<String, Expectador> creaSalaVacia() {
        String[] letras = {"A", "B", "C", "D", "E", "F"};
        HashMap<String, Expectador> resu = new HashMap<>();
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 6; j++) {
                resu.put(String.valueOf(i).concat(letras[j]), null);
            }
        }
        return resu;
    }

    @Override
    public String toString() {
        String[] letras = {"A", "B", "C", "D", "E", "F"};
        char estado;
        String resultado = "  Información de la Sala: asientos: " + sala.size() + "\n";
        resultado = resultado.concat("------------------------------------------\n");
            //Datos de la pelicula
        resultado = resultado.concat(this.pelicula.toString()+"\n");
            //Info Entrada
         resultado= resultado.concat(String.format("Valor de la entrada: $ %.2f.-\n\n",this.precioEntrada));
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 6; j++) {
                estado = 'X';
                if (sala.get(String.valueOf(i).concat(letras[j])) == null) {
                    estado = ' ';
                }

                resultado = resultado.concat(String.format("%2d%2s%2s |", i, letras[j], estado));
            }
            resultado += "\n";
        }
        resultado = resultado.concat("------------------------------------------\n");
        return resultado;
    }

}
