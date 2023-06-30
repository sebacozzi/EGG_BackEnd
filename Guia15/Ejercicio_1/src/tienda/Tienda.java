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
import java.util.Scanner;
import menudeopciones.Menu;
import menudeopciones.ServiciosMenu;
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
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        //ArrayList<Fabricante> ftes = null;
        //Producto p = null;

        //          Servicios             //
        FabricanteServicios fs = new FabricanteServicios();
        ProductoServicios ps = new ProductoServicios();
        ServiciosMenu sm = new ServiciosMenu();
        //          Servicios             //

        //          Opciones Menu             //
        String[] menuPrincipal = {
            "Opciones de Productos",
            "Opciones de Fabricantes",
            "Salir"};
        String[] menuProductos = {
            "Mostrar el nombre de todos los productos",
            "Mostrar nombre y precio de todos los productos",
            "Mostrar porductos en un rango de precios",
            "Buscar y Mostrar todos los Portátiles",
            "Mostrar el precio y nombre del producto mas barato",
            "Agregar Producto",
            "Modificar Producto",
            "Volver"};
        String[] menuFabricantes = {
            "Mostrar Fabricantes",
            "Agregar Fabricante",
            "Editar Fabricante",
            "Volver"};

        do {
            sm.show(new Menu(menuPrincipal, "Menu de Tienda"));
            switch (sm.getResultado()) {
                case 1://            "Opciones de Productos"

                    menu1(ps, menuProductos);

                    break;
                case 2://            "Opciones de Fabricantes"

                    menu2(fs, menuFabricantes);

                    break;
            }
            if (sm.esSalir()) { //             "Salir"
                break;
            }
        } while (true);

    }

    private static void menu1(ProductoServicios ps, String[] opciones) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        int codigo_fabricante;
        FabricanteServicios fs = new FabricanteServicios();
        String nombre;
        Double precio;
        ServiciosMenu sm = new ServiciosMenu();
        do {
            sm.show(new Menu(opciones, "Menu de Productos"));
            try {
                switch (sm.getResultado()) {
                    case 1://             "Mostrar el nombre de todos los productos"

                        ps.mostrarProductos(ps.nombresProductos());

                        break;
                    case 2://             "Mostrar nombre y precio de todos los productos"

                        ps.mostrarProductos(ps.nombresYPreciosProductos());

                        break;
                    case 3://             "Mostrar porductos en un rango de precios"

                        ps.mostrarProductos(ps.productosConRangoDePrecios(120d, 202d));

                        break;
                    case 4://             "Buscar y Mostrar todos los Portátiles"

                        ps.mostrarProductos(ps.productosPorFiltroEnNombre("Portátil"));

                        break;
                    case 5://             "Mostrar el precio y nombre del producto mas barato"

                        ps.mostrarProducto(ps.productoMasBarato());

                        break;
                    case 6://             "Agregar Producto"

                        
                        System.out.println("*********** Agregar Producto ***********");
                        

                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = leer.next();
                        System.out.print("Ingrese el precio del Producto: ");
                        do {
                        try{
                        precio = leer.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un número.");
                            System.out.print("-> ");
                            continue;
                        }
                        break;
                        } while (true);
                        
                        String h = "0";
                        do {
                            System.out.print("Ingrese el codigo del fabricante (h - para ver lista de proveedores): ");
                            h = leer.next();
                            if (h.equalsIgnoreCase("h")) {
                                fs.mostrarFabricantes(fs.obtenerFabricantes());
                            } else {
                                try {
                                    codigo_fabricante = Integer.getInteger(h);
                                    break;
                                } catch (Exception e) {
                                    System.out.println("No se ingreso un entero.");
                                }

                            }
                        } while (true);
                        ps.mostrarProducto(ps.nuevoProducto(nombre, precio, codigo_fabricante));

                        break;
                    case 7://             "Modificar Producto"

                        ps.mostrarProductos(ps.obtenerProductos());

                        System.out.println("*********** Modificar Producto ***********");

                        System.out.print("Ingrese el codigo del producto: ");
                        int codigo = leer.nextInt();
                        Producto p = ps.productoPorCodigo(codigo);

                        System.out.println("Actual: " + p.getCodigoFabricante() + ". (poner \"0\" para no cambiar)");
                        System.out.print("Ingrese el nuevo codigo del fabricante: ");
                        codigo_fabricante = leer.nextInt();
                        if (codigo_fabricante == 0) {
                            codigo_fabricante = p.getCodigoFabricante();
                        }

                        System.out.println("Actual: " + p.getNombre() + ". (dejar vacio para no cambiar)");
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        nombre = leer.next();
                        if (nombre.trim().isEmpty()) {
                            nombre = p.getNombre();
                        }

                        System.out.println("Actual: " + p.getPrecio().toString() + ". (poner\"0\" para no cambiar)");
                        System.out.print("Ingrese el nuevo precio del Producto: ");
                        precio = leer.nextDouble();
                        if (precio == 0) {
                            precio = p.getPrecio();
                        }

                        ps.mostrarProducto(ps.ActualizaProducto(codigo, nombre, precio, codigo_fabricante));

                        break;
                }
                if (sm.esSalir()) { //             "Volver"
                    break;
                } else {
                    sm.esperaTecla();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sm.esperaTecla();
            }
        } while (true);

    }

    private static void menu2(FabricanteServicios fs, String[] opciones) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        String nombre;
        ServiciosMenu sm = new ServiciosMenu();
        do {
            try {
                sm.show(new Menu(opciones, "Opciones de Fabricantes"));
                switch (sm.getResultado()) {
                    case 1://            "Mostrar Fabricantes"

                        fs.mostrarFabricantes(fs.obtenerFabricantes());

                        break;
                    case 2://            "Agregar Fabricante"

                        System.out.print("Ingrese el nombre del Fabricante: ");
                        nombre = leer.next();
                        fs.mostrarFabricantes(fs.crearFabricante(nombre));

                        break;
                    case 3://            "Editar Fabricante"

                        break;
                }
                if (sm.esSalir()) { //             "Volver"
                    break;
                } else {
                    sm.esperaTecla();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                sm.esperaTecla();
            }
        } while (true);

    }
}
