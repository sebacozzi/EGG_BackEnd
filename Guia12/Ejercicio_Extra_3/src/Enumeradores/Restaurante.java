/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumeradores;

/**
 *
 * @author Sebastián Cozzi
 */
public enum Restaurante {
    CHICO(10, "Restaurante para menos de 30 personas"),
    MEDIANO(30, "Restaruante de 30 a 50 personas"),
    GRANDE(50, "Restaurante para mas de 50 personas");
    private int precio;
    private String Descripcion;
    
    private Restaurante() {
    }

    private Restaurante(int precio, String Descripcion) {
        this.precio = precio;
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
