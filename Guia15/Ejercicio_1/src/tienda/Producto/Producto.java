/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Producto;

import tienda.Interfaces.baseEntidad;

/**
 *
 * @author Sebastian Cozzi
 */
public class Producto implements baseEntidad{

    private int codigo;
    private String nombre;
    private Double precio;
    private int codigoFabricante;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Double precio, int codigoFabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigoFabricante = codigoFabricante;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    @Override
    public String getValue(String nombreColumna) {
        switch (nombreColumna.toLowerCase()) {
            case "codigo":
                return Integer.toString(codigo);
            case "nombre":
                return nombre;
            case "precio":
                return Double.toString(precio);
            case "codigo_fabricante":
                return Integer.toString(codigoFabricante);
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
            case "codigo_fabricante":
                this.codigoFabricante = valor;
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
    public void setValue(String nombreColumna,Double valor){
        switch (nombreColumna.toLowerCase()) {
            case "precio":
                this.precio = valor;
                break;
            default:
                throw new AssertionError();
        }
    }
}
