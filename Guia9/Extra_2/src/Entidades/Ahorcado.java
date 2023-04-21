/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Arrays;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ahorcado {
    private char[] palabra;
  //  private char[] erradas;
  //  private char[] acertadas;
    private int contIntentos;
    private int contErradas;
    
    
    public Ahorcado(){
        this.contErradas=0;
    }
    public Ahorcado(String palabra,int cantidadIntentos){
        this.palabra=palabra.toCharArray();
       // this.erradas=new char[cantidadIntentos];
        this.contIntentos = cantidadIntentos;
        this.contErradas =0;
       // Arrays.fill(this.acertadas,' ');
       // Arrays.fill(this.erradas,' ');
        
    }
    public void setErrados(){
        this.contErradas++;
    }
   public char[] getPalabra(){
       return palabra;
   }

    public int getContIntentos() {
        return contIntentos;
    }

    public void setContIntentos(int contIntentos) {
        this.contIntentos = contIntentos;
    }
    public int getErrados(){
        return contErradas;
    }
/*
    @Override
    public String toString() {
        String resultado="%s    Faltan %d de %d\n%s";
        int contCorrectas=0;
        String sAcertadas="";
        for (int i = 0; i < this.palabra.length; i++) {
            if (letraEnPosicion()) {
                
            }
        }
        String sErra="";
        for (int i = 0; i < this.erradas.length; i++) {
            sErra= sErra.concat(String.valueOf(this.erradas[i]));
            if (i<this.erradas.length-1) {
                sErra= sErra.concat(" - ");
                
            }
        }
        
        return String.format(resultado, sAcertadas, contCorrectas, this.palabra.length,sErra);
    }
    
    private boolean caracterEnPosicion(char letra,int pos){
        
    }
*/
}
