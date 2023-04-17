/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Sebastian Cozzi
 */
public class Persona {
    private String nombre;
    private Date fNacimiento;

    public Persona() {
    }

    public Persona(String nombre, Date fNacimiento) {
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "\nnombre=" + nombre + "\nFecha de Nacimiento=" + fNacimiento + '}';
    }
    
}
