/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.Arrays;

/**
 *
 * @author Sebastian Cozzi
 */
public class ArregloService {
 /**  a) Método inicializarA recibe un arreglo por parámetro y lo inicializa con
 * números aleatorios.
 * 
     * @param arreglo
     * @return 
 */
    public Double[] inicializarA(Double[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i]=Math.random()*50;
        }
        return arreglo;
    }
    
 /**  b) Método mostrar recibe un arreglo por parámetro y lo muestra por pantalla.
  * 
     * @param arreglo
  */
 public void mostrar(Double[] arreglo){
         System.out.println(Arrays.toString(arreglo));
 }   
    
 /**  c) Método ordenar recibe un arreglo por parámetro y lo ordena de mayor a menor.
  * 
     * @param arreglo
     * @return 
  */
    public Double[] ordenar(Double[] arreglo){
        Arrays.sort(arreglo);
        Double[] a=new Double[arreglo.length];
        mostrar(arreglo);
        for (int i = 0; i < arreglo.length; i++) {
            a[i] = arreglo[49-i];
        }
    
        return a;
    }
    
 /**  d) Método inicializarB copia los primeros 10 números del arreglo A en el 
 * arreglo B. Luego llenar las últimas 10 posiciones del arreglo B con 0.5.
 * 
     * @param arregloA
     * @param arregloB
     * @return 
 */
    public Double[] inicializarB(Double[] arregloA, Double[] arregloB){
        
        arregloB=Arrays.copyOfRange(arregloA,0, 20);
        Arrays.fill(arregloB,10, 20, 0.5);
        return arregloB;
    }
    
}
