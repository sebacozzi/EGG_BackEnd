/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashMap;

/**
 *
 * @author Sebastian Cozzi
 */
public class Stock {
    private HashMap<String,Double> stock;

    public Stock(HashMap<String, Double> stock) {
        this.stock = stock;
    }

    public Stock() {
        this.stock= new HashMap();
    }

    public HashMap<String, Double> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Double> stock) {
        this.stock = stock;
    }
    public void ingresaProducto(String nombre,Double precio){
        this.stock.put(nombre, precio);
    }

    /**
     *Metodo que retorna el tamaño del HashMap
     * @return int
     */
    public int size(){
    return this.stock.size();
            }
    public boolean isEmpty(){
        return this.stock.isEmpty();
    }
}
