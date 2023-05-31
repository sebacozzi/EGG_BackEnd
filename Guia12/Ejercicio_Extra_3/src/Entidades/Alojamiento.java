/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián Cozzi
 */
public class Alojamiento <T> {
    private String nombre;
    private String direccion;
    private String localidad;
    private Gerente gerente;
    private Class<T> alojamiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Class<T> getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Class<T> alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Alojamiento(String nombre, String direccion, String localidad, Gerente gerente, Class<T> alojamiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.gerente = gerente;
        this.alojamiento = alojamiento;
    }

    public Alojamiento() {
    }
    
}
