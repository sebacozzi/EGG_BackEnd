/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1;

/**
 *
 * @author Sebastián Cozzi
 */
public class Persona {
    int edad;

    public Persona() {
    }

    public Persona(int edad) {
        this.edad = edad;
    }
    
    public boolean esMayor(int edad){
        return edad < this.edad;
    }

    

    
}
