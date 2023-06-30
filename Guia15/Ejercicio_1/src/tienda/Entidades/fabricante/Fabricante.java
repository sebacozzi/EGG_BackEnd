/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Entidades.fabricante;

import tienda.Entidades.Interfaces.baseEntidad;

/**
 *
 * @author Sebastian Cozzi
 */
public class Fabricante implements baseEntidad{
    private int codigo;
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String getValue(String nombreColumna){
        switch (nombreColumna.toLowerCase()) {
            case "codigo":
                
                return Integer.toString(codigo);
            case "nombre":
                return nombre;
            default:
                throw new AssertionError();
        }
    }
    @Override
    public void setValue(String nombreColumna,Integer valor){
        switch (nombreColumna.toLowerCase()) {
            case "codigo":
                this.codigo = valor;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public void setValue(String nombreColumna,String valor){
        switch (nombreColumna.toLowerCase()) {
            case "nombre":
                this.nombre = valor;
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void setValue(String nombreColumna, Double valor) {
        throw new UnsupportedOperationException("No es requerido para está Clase."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
