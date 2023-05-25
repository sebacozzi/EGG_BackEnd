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
public class Perro extends Animal{

    public Perro(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }
    
    /**alimentarse
     */
    
    @Override
    public void alimentarse(){
        System.out.println(this.getClass());
        System.out.println("El perro "+ nombre +" se alimenta de "+ alimento+'.');
    }
}
