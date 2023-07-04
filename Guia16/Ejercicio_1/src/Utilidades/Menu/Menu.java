/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades.Menu;

import Utilidades.Utils.Utils;

/**
 *
 * @author Sebasti�n Cozzi
 */
public class Menu {

    private String[] items;
    private String titulo;

   

    /**
     * Metodo para crear base para el menu
     *
     * @param items Arreglo con los items del menu
     *
     * @param titulo Titulo del menu
     */
    public Menu(String[] items, String titulo) {
        this.items = items;
        if (titulo.trim().isEmpty()) {
            titulo = "Menu";
        }
        this.titulo = titulo;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        String temp = "";
        temp = temp.concat(Utils.titulo(this.titulo,25));
//        for (int i = 0; i < titulo.length(); i++) {
//        temp = temp.concat("-");
//        }
        temp = temp.concat("\n");
        for (int i = 0; i < items.length; i++) {
            temp = temp.concat(String.format(" %d) %s.",(i + 1), items[i]) + "\n");
        }
        temp = temp.concat(String.format("  Ingrese una Opción (1 al %d): ",items.length));
        return temp;
    }

}