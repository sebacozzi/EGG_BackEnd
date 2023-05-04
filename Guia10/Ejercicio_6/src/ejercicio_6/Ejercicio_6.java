/**
 * Se necesita una aplicación para una tienda en la cual queremos almacenar los
 * distintos productos que venderemos y el precio que tendrán. Además, se
 * necesita que la aplicación cuente con las funciones básicas.
 * Estas las realizaremos en el servicio. Como, introducir un elemento,
 * modificar su precio, eliminar un producto y mostrar los productos que tenemos
 * con su precio (Utilizar Hashmap). El HashMap tendrá de llave el nombre del
 * producto y de valor el precio.
 * Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package ejercicio_6;

import Entidades.Stock;
import Servicios.StockServicios;
import menudeopciones.Menu;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StockServicios sp = new StockServicios();
        Stock productos = new Stock();
        /// Servicio manejo del Menu
        ServiciosMenu sm = new ServiciosMenu();
        // menu Principal
        String[] m = {"Productos", "Vender", "Salir"};
        // Submenu de Principal/Productos
        String[] mP = {"Cargar", "Modificar Precio", "Eliminar", "Mostrar Lista", "Volver"};
        // Submenu Principal/Productos/Cargar 
        String[] mC = {"Cargar 1 Producto", "Cargar varios Productos", "Volver"};
        // Submenu Principal/Productos/Modificar Precio 
        String[] mMP = {"Modificar 1 precio", "Modificar todos los precio (porcentaje)", "Volver"};
        // Submenu Principal/Productos/Eliminar 
        String[] mE = {"Eliminar 1", "Eliminar Varios", "Eliminar todos", "Volver"};
        // Submenu Principal/Productos/Mostrar Lista 
        String[] mML = {"Listar por Nombre/LLave", "Mostrar por Precio", "Volver"};
        // Submenu Principal/Vender 
        String[] mV = {"Vender 1", "Vender Varios", "Volver"};
        do {
            sm.show(new Menu(m, "Menu Principal: "));
            // si la opcion elejida es la de salida, sale del DO con break
            if (sm.getResultado() == m.length) {
                break;
            }
            // switch para controlar las funciones del menu
            switch (sm.getResultado()) {
                case 1: // SubMenu Productos
                    do {
                        // Muestra el SubMenu Principal/Productos
                        sm.show(new Menu(mP, "Menu de Productos: "));
                        // Si es la opción de salida lanza break al DO
                        if (sm.getResultado() == mP.length) {
                            break;
                        }
                        // consulta si no se cargaron productos y si la opcion 
                        //  es distino de 1(Carga de Productos nuevos) informa y retorna al encabezado del DO 
                        if (!sp.hayProductos(productos) && sm.getResultado() != 1) {
                            System.out.println("No se ingresaron Productos - Elija opción 1 o 5.");
                            continue;
                        }
                        // switch para controlar las funciones del menu
                        switch (sm.getResultado()) {
                            case 1:// Opción Cargar
                                do {
                                    // Muestra el Submenu Principal/Productos/Cargar
                                    sm.show(new Menu(mC, "Carga de Productos"));
                                    // si el resultado es mC.length (ultima opción del menu) sale del DO
                                    if (sm.getResultado() == mC.length) {
                                        break;
                                    }
                                    if (sm.getResultado() == 1) {
                                        //Cargar 1 Producto
                                        sp.cargarProducto(productos);
                                    } else // carga varios Productos
                                    {
                                        sp.cargarProductos(productos);
                                    }
                                } while (true);
                                break;
                            case 2:// Opción Modificar Precio

                        }
                    } while (true);
                    break;
                case 2:
                    sm.show(new Menu(mV, "Menu de Ventas"));
            }
        } while (true);

    }
}
