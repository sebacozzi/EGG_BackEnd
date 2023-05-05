/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Stock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Sebastian Cozzi
 */
public class StockServicios {

    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
    // que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
    // lea hasta el salto de linea
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    /**
     * Metodo encargado de la logica de carga del producto
     *
     * @param productos Objeto de clase Stock que contiene el HashMap con los
     * productos
     * @return boolean si se cargo o no el producto
     */
    public boolean cargarProducto(Stock productos) {
        // String para almacenar el nombre del producto
        String n;
        // encabezado
        System.out.printf("Ingresar los datos del producto %03d:%n", productos.size() + 1);
        System.out.println("------------------------------------");
        // inicio de solicitud de datos
        System.out.print("Nombre(dejar vacio para cancelar): ");
        // bucle utilizado para verificar si el producto ya se cargo, si ya se ingreso informa y vuelve a perdir el nombre
        do {
            n = leer.next();
            // si no pone el nombre del producto sale del metodo y devuelve false
            if (n.trim().isEmpty()) {
                //Sale del metodo y retorna false porque el producto no se cargo
                return false;
            }
            // consulta si ya se cargo el producto para continuar con la carga de datos
            if (productos.getStock().containsKey(n)) {
                System.out.printf("El producto %s ya existe. Ingrese otro.%n", n);
            } else {
                break;
            }
        } while (true);
        // Solicita el ingreso del precio
        System.out.print("Ingresar el precio: ");
        Double p = leer.nextDouble();
        // carga el producto al HashMap
        productos.ingresaProducto(n, p);
        // sale del metodo retornado true para confirmar que el producto se cargo
        return true;
    }

    /**
     * Metodo que se encarga de llamar repetidamente el metodo cargarProducto
     * hasta que retorne false. Si no se cargo ningun producto lo informa por
     * consola
     *
     * @param productos Objeto de clase Stock con los Productos
     */
    public void cargarProductos(Stock productos) {
        // variable usada para saber si se cargo algun producto
        int tamanio = productos.size();
        while (cargarProducto(productos)) {
        }
        if (tamanio == productos.size()) {
            System.out.println("No se cargo ningun producto.");
        }
    }

    /**
     * Metodo encargado de mostrar la lista de productos y precios formateado
     * por columnas:<br>
     * Columna
     *
     * @param productos
     */
    public void mostrar(Stock productos) {
        int l = maxNombre(productos.getStock().keySet());
        String st = "| %04d | %-" + l + "s | $ %6.2f |%n";
        int cont = 1;
        String encab = String.format("|  ID  | %-" + l + "s | Precio   |", "Descripcion");
        System.out.println(encab);
        System.out.println(multString("-", encab.length()));
        for (Map.Entry<String, Double> producto : productos.getStock().entrySet()) {
            System.out.printf(st, cont, producto.getKey(), producto.getValue());
            cont++;
        }
        System.out.println(multString("-", encab.length()));

    }

    /**
     *
     * @param productos
     */
    public void modificaPrecio(Stock productos) {
        String nombre;
        System.out.println(" Modificar precio de Producto");
        System.out.println("------------------------------");
        nombre = verificaNombre(productos, "Ingrese el nombre del producto (no escribir ningun valor para salir): ", true);
        if (nombre.trim().isEmpty()) {
            return;
        }
        System.out.printf("Precio actual: $ %4.2f%n", productos.getStock().get(nombre));
        System.out.print("Ingrese el nuevo precio:");
        Double nPrecio = leer.nextDouble();
        productos.getStock().replace(nombre, nPrecio);
    }

    /**
     * Metodo encargado de actulizar los precios a un porcentaje ingresado por
     * teclado
     *
     * @param productos Objeto Stock con la lista de productos a modificar
     */
    public void actulizaPrecios(Stock productos) {

        System.out.print("Ingrese el porcentaje de modificación: ");
        Double porcentaje = leer.nextDouble();
        for (Map.Entry<String, Double> producto : productos.getStock().entrySet()) {
            producto.setValue(producto.getValue() * (1 + (porcentaje / 100)));
        }
    }

    /**
     * Metodo que elimina un producto de la lista, llama a verifica nombre que
     * retorna un nombre valido de producto
     *
     * @param productos Objeto Stock con el HashMap de productos
     */
    public void eliminarProducto(Stock productos) {
        String nombre;
        System.out.println(" Eliminar producto: ");
        System.out.println(multString("-", " Eliminar producto: ".length()));

        productos.getStock().remove(verificaNombre(productos, "Ingrese el nombre del producto a eliminar: "));

    }

    /**
     * Metodo que devuelve true si ya se cargaron productos
     *
     * @param productos HashMap con los productos
     * @return boolean<br>
     * "true" si ya se cargo algun producto<br>
     * "false" si la lista esta vacia
     */
    public boolean hayProductos(Stock productos) {
        return !productos.isEmpty();
    }

    /**
     * Metodo que permite eliminar varios productos en un solo metodo. <br>
     * primero solicita los nombres de productos almacenandolos en un ArrayList
     * y luego elimina todos juntos
     *
     * @param productos Objeto Stock con la lista de Productos
     */
    public void eliminarVarios(Stock productos) {
        // ArrayList de String donde se van a ir almacenando los nombres de los 
        // productos a eliminar
        ArrayList<String> lista = new ArrayList();
        // variable donde se van almacenando los nombres ingresados
        String nombre;
        System.out.println(" Eliminar Varios Productos: ");
        System.out.println(multString("-", " Eliminar Varios Productos: ".length()));
        // Bucle que se utiliza para llenar el ArrayList con los nombres.
        //  Sale cuando nombre está vacio
        do {
            nombre = verificaNombre(productos, "Ingrese los nombres de los productos (no escribir nada para salir): ", true);
            if (nombre.trim().isEmpty()) {
                break;
            }
            lista.add(nombre);
        } while (true);
        // Verifica si se cargo algun nombre
        if (lista.isEmpty()) {
            System.out.println("No se ingreso ningun producto para eliminar.");
            return;
        }
        // Bucle que recorre el ArrayList de nombres y va eliminando los items
        for (String string : lista) {
            productos.getStock().remove(string);
        }
    }

    /**
     * Metodo que vacia la lista de productos
     *
     * @param productos
     */
    public void eliminarTodos(Stock productos) {
        productos.getStock().clear();
    }

    /**
     * Metodo que te pide un producto y te muestra una tabla con ese producto,
     * la cantidad el precio del producto y abajo el total de la venta
     *
     * @param productos
     * @return
     */
    public void venderProducto(Stock productos) {
        Double[] detalle = new Double[2];
        String nombre;
        HashMap<String, Double[]> items = new HashMap();
        System.out.println(" Venta de producto unico:");
        System.out.println("--------------------------");
        nombre = verificaNombre(productos, "Ingrese el nombre del producto a vender (dejar en vacio para salir) : ", true);
        if (nombre.trim().isEmpty()) {
            System.out.println("No se ingreso un nombre, saliendo de venta...");
            return;
        }
        System.out.print("Ingrese la cantidad a vender: ");
        detalle[0] = leer.nextDouble();
        detalle[1] = productos.getStock().get(nombre);
        items.put(nombre, detalle);
        System.out.println("");
        mostrarVenta(items);
        System.out.println("");
        //System.out.println("No implementado");
    }

    public void venderProductos(Stock productos) {
        String nombre;
        HashMap<String, Double[]> items = new HashMap();
        System.out.println(" Venta de productos:");
        System.out.println("--------------------------");
        do{
        nombre = verificaNombre(productos, "Ingrese el nombre del producto a vender (dejar en vacio para salir) : ", true);
        if (nombre.trim().isEmpty()) {
            if(items.isEmpty()){
                System.out.println("No se ingreso un nombre, saliendo de venta...");
                return;
            }
            System.out.println("Venta finalizada.");
            System.out.println(" Detalle de Venta:");
            System.out.println("-------------------");
            mostrarVenta(items);
            return;
        }
        System.out.print("Ingrese la cantidad a vender: ");
        items.put(nombre, new Double[]{leer.nextDouble(),productos.getStock().get(nombre)});
        System.out.println("");
        mostrarVenta(items);
        System.out.println("");
        } while (true);
        //System.out.println("No implementado");
    }

    private void mostrarVenta(HashMap<String, Double[]> productos) {
        int l = maxNombre(productos.keySet());
        Double total = 0.0;
        if (!productos.isEmpty()) {

        }
        if (l < 11) {
            l = 11;
        }
        String st = "| %5s | %-" + l + "s | $ %6.2f |%n";
        String encab = String.format("| Cant  | %-" + l + "s | Precio   |", "Descripcion");
        System.out.println(encab);
        System.out.println(multString("-", encab.length()));
        for (Map.Entry<String, Double[]> producto : productos.entrySet()) {
            System.out.printf(st, String.format("%3.2f", producto.getValue()[0]), producto.getKey(), producto.getValue()[1]);
            total += producto.getValue()[0] * producto.getValue()[1];
        }
        System.out.println(multString("-", encab.length()));

        System.out.printf("         %" + l + "s    $ %6.2f  %n", "Total:", total);

    }

    /**
     * Metodo que se ingresa un nombre de producto y sale cuando sea un nombre
     * valido
     *
     * @param productos Objeto Stock con la lista de productos
     * @param textoAMostrar texto que va mostrar informando para que es la
     * validación
     * @param devuelveVacio boolean que permite salir del metodo si no se
     * ingreso ningun valor
     * @return String con el nombre validado
     */
    private String verificaNombre(Stock productos, String textoAMostrar, boolean devuelveVacio) {
        String nombre = "";
        do {
            System.out.print(textoAMostrar);
            nombre = leer.next();
            if (nombre.trim().isEmpty()) {
                if (devuelveVacio) {
                    break;
                } else {
                    System.out.println("No se ingreso ningun nombre de producto.");
                }
            } else if (!productos.getStock().containsKey(nombre)) {
                System.out.printf("El producto %s no existe.%n", nombre);
            } else {
                break;
            }
        } while (true);
        return nombre;
    }

    private String verificaNombre(Stock productos, String textoAMostrar) {
        return verificaNombre(productos, textoAMostrar, false);
    }

    /**
     * Metodo para repertir un string n cantidad de veces (multi)
     *
     * @param s String a repertir
     * @param multi cantidad de veces se va a repetir
     * @return String con s repetido "multi" cantidad de veces
     */
    private String multString(String s, int multi) {
        String r = "";
        for (int i = 0; i < multi; i++) {
            r = r.concat(s);
        }
        return r;
    }

    private int maxNombre(Set<String> nombres) {
        int res = 0;
        for (String producto : nombres) {
            if (producto.length() > res) {
                res = producto.length();
            }
        }
        return res;
    }

}
