/*
a) Lista el nombre de todos los productos que hay en la tabla producto. 
b) Lista los nombres y los precios de todos los productos de la tabla producto. 
c) Listar aquellos productos que su precio esté entre 120 y 202. 
d) Buscar y listar todos los Portátiles de la tabla producto. 
e) Listar el nombre y el precio del producto más barato. 
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.

 */
package tienda;

import java.util.ArrayList;
import tienda.Entidades.fabricante.Fabricante;
import tienda.Entidades.fabricante.FabricanteServicios;
import tienda.Entidades.producto.Producto;
import tienda.Entidades.producto.ProductoServicios;

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
        try{
        ftes = (ArrayList<Fabricante>) fs.obtenerFabricantes();
        fs.mostrarFabricantes(ftes);
        }catch (Exception x){
            System.out.println(x.getClass());
        }
    
        ArrayList<Producto> prods = null;
        ProductoServicios ps = new ProductoServicios();
        try{
        prods = (ArrayList<Producto>) ps.obtenerProductos();
        ps.mostrarProductos(prods);
        }catch (Exception x){
            System.out.println(x.getClass());
        }
        /// a) Lista el nombre de todos los productos que hay en la tabla producto. 
        try{
        prods = (ArrayList<Producto>) ps.nombresProductos();
        ps.mostrarProductos(prods);
        }catch (Exception x){
            System.out.println(x.getClass());
        }
        
        /// b) Lista los nombres y los precios de todos los productos de la tabla producto. 
        try{
        prods = (ArrayList<Producto>) ps.nombresYPreciosProductos();
        ps.mostrarProductos(prods);
        }catch (Exception x){
            System.out.println(x.getClass());
        }
        
        /// c) Listar aquellos productos que su precio esté entre 120 y 202.
    }
    
    
}
