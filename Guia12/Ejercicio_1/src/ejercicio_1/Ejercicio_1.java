/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1;

import Entidades.Animal;
import Entidades.Caballo;
import Entidades.Gato;
import Entidades.Perro;


/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Animal perro1 = new Perro("Stich","Carnivoro",15,"Doberman");
        perro1.alimentarse();
        System.out.println("****************");
        Animal perro2 = new Perro("Teddy","Croquetas",10,"Chihuahua");
        perro2.alimentarse();
        System.out.println("****************");
        Animal gato1 = new Gato("Pelusa","Galletas",15,"Siamés");
        gato1.alimentarse();
        System.out.println("****************");
        Animal caballo1 = new Caballo("Spark","Pasto",25,"Fino");
        caballo1.alimentarse();
        System.out.println("****************");
    }
    
}
