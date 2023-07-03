/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Interfaces;

/**
 *
 * @author Sebastian Cozzi
 */
public interface baseEntidad {
    public void setValue(String nombreColumna,Integer valor);
    public void setValue(String nombreColumna,Double valor);
    public void setValue(String nombreColumna,String valor);
    
    public String getValue(String nombreColumna);
    
}
