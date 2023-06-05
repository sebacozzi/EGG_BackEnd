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
public class Residencia extends ExtraHotelero{
//    cantidad de habitaciones, si se hacen o no descuentos a los gremios 
//    y si posee o no campo deportivo
    
    private int cantidadDeHabitaciones;
    private boolean descuentoAGremio;
    private boolean campoDeportivo;

    public Residencia() {
    }

    public Residencia(int cantidadDeHabitaciones, boolean descuentoAGremio, boolean campoDeportivo, Boolean esPrivado, Double superficie) {
        super(esPrivado, superficie);
        this.cantidadDeHabitaciones = cantidadDeHabitaciones;
        this.descuentoAGremio = descuentoAGremio;
        this.campoDeportivo = campoDeportivo;
    }

    public int getCantidadDeHabitaciones() {
        return cantidadDeHabitaciones;
    }

    public void setCantidadDeHabitaciones(int cantidadDeHabitaciones) {
        this.cantidadDeHabitaciones = cantidadDeHabitaciones;
    }

    public boolean isDescuentoAGremio() {
        return descuentoAGremio;
    }

    public void setDescuentoAGremio(boolean descuentoAGremio) {
        this.descuentoAGremio = descuentoAGremio;
    }

    public boolean isCampoDeportivo() {
        return campoDeportivo;
    }

    public void setCampoDeportivo(boolean campoDeportivo) {
        this.campoDeportivo = campoDeportivo;
    }

    @Override
    public String toString() {
        String dg="No",pcd ="No";
        if (campoDeportivo) {
            pcd = "Si";
        }
        if (descuentoAGremio) {
            dg="Si";
        }
        return super.toString()
                +"Cantidad de Habitaciones: "+cantidadDeHabitaciones+"\n"
        + "Posee Campo deportivo: "+pcd +".\n"
                + "Raliza descuento al Gremio: "+dg+".\n";
    }

    @Override
    public void crearAlAzar() {
        super.crearAlAzar();
        this.campoDeportivo = Math.round(Math.random())==1;
        this.descuentoAGremio = Math.round(Math.random())==1;
        this.cantidadDeHabitaciones=(int) (Math.round(Math.random()*4)+1);
    }
    
    
    
    
}
