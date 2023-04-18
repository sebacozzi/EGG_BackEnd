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
    private String palabra;
    private int aciertos;
    private String[] dibujo;

    public Ahorcado() {
        this.dibujo={"  ┌──┐ ",
                     "  │   █ ",
                     "  │  /│\\",
                     "  │   │  ",
                     "  │  / \\ ",
                     "  │       ",
                     "  ██████"};
    }
                
    }

    public Ahorcado(String palabra, int aciertos, String[] dibujo) {
        this.palabra = palabra;
        this.aciertos = aciertos;
        this.dibujo = dibujo;
    }
    
}
