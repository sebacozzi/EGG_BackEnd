/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Emuns;

/**
 *
 * @author Sebastian Cozzi
 */
public enum Precio {
    MAYOR("DESC"),MENOR("ASC");
    private String valor;

    private Precio(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
