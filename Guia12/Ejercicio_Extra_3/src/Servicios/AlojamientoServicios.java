/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Alojamiento;
import Entidades.Camping;
import Entidades.Gerente;
import Entidades.Hotel4E;
import Entidades.Hotel5E;
import Entidades.Residencia;

/**
 *
 * @author Sebastián Cozzi
 */
public class AlojamientoServicios {
    public void llenarAlAzar(Alojamiento alojamiento){
        String[] calles = {"San Martín", "La Rioja","25 de Mayo","3 de Febrero", "Gobernador Freyre"
        ,"Tucumán","9 de Julio","Candido Pujato", "Boneo","Rivadavia"};
        
        Gerente g = new Gerente();
        g.crearAzar();
        
        alojamiento.setGerente(g);
        alojamiento.setDireccion( calles[(int) (Math.random() * calles.length)] +" "+ (int)(Math.random()*8000));
        switch ((int) Math.random()*4) {
            case 0:
                Hotel4E h4 =new Hotel4E();
                h4.crearAlAzar();
                break;
            case 1:
                Hotel5E h5 =new Hotel5E();
                h5.crearAlAzar();
                break;
            case 2:
                Residencia r=new Residencia();
                r.crearAlAzar();
                alojamiento.setAlojamiento(r);
                break;
            default:
                Camping c = new Camping();
                c.crearAlAzar();
                alojamiento.setAlojamiento(c);
        }
        alojamiento.setLocalidad("Laguna Paiva");
        alojamiento.setNombre("Nombre");
        
        
        
}
}
