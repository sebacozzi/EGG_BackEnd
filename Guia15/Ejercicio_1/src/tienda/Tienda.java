/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import tienda.Entidades.fabricante.Fabricante;
import tienda.Entidades.fabricante.FabricanteServicios;

/**
 *
 * @author Sebastián Cozzi
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ArrayList<Fabricante> ftes = null;
        FabricanteServicios fs = new FabricanteServicios();
        
        ftes = (ArrayList<Fabricante>) fs.obtenerFabricantes();
        fs.mostrarFabricantes(ftes);
        
    }
    
}
