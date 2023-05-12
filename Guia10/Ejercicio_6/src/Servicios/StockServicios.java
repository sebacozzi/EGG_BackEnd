/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Stock;
import java.util.ArrayList;
import java.util.HashMap;
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
        // Bucle encargado de llamar cargarProducto hasta que devuelva false(no se carga otro producto)
        while (cargarProducto(productos)) {
        }
        // Notifica si se cargo algun producto nuevo
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
            // Variable utilizada para guardar la longitud del nombre mas largo
        int l = maxNombre(productos.getStock().keySet());
            // Formato estandar para cada item de la lista 
        String st = "| %04d | %-" + l + "s | $ %6.2f |%n";
            // contador para indices de items
        int cont = 1;
            // Formato para el encabezado de la lista con los titulos
        String encab = String.format("|  ID  | %-" + l + "s | Precio   |", "Descripcion");
        System.out.println(encab);
            // Escribe guiones debajo del encabezado
        System.out.println(multString("-", encab.length()));
            // Bucle que recorre el HashMap y lo muestra por pantalla utilizando el formato guardado es "st"
        for (Map.Entry<String, Double> producto : productos.getStock().entrySet()) {
            System.out.printf(st, cont, producto.getKey(), producto.getValue());
                // Incrementa el contador de items
            cont++;
        }
            // cierra la lista con guiones
        System.out.println(multString("-", encab.length()));
    }

    /**
     * Metodo que permite elegir un producto e ingresar un nuevo precio de producto
     * @param productos Objeto Stock con la lista de productos
     */
    public void modificaPrecio(Stock productos) {
            // Variable donde se va almacenar el nombre del producto a modificar
        String nombre;
            // Mensaje de bienvenida
        System.out.println(" Modificar precio de Producto");
        System.out.println("------------------------------");
            // Solicita al usuario el nombre del producto validado
        nombre = verificaNombre(productos, "Ingrese el nombre del producto (no escribir ningun valor para salir): ", true);
            // Si no se ingreso nada sale del metodo
        if (nombre.trim().isEmpty()) {
            return;
        }
            // Muestra el detalle del producto a modificar
        System.out.printf("Precio actual: $ %4.2f%n", productos.getStock().get(nombre));
        System.out.print("Ingrese el nuevo precio:");
            // Actualiza el precio del producto
        productos.getStock().replace(nombre, leer.nextDouble());
    }

    /**
     * Metodo encargado de actulizar los precios a un porcentaje ingresado por
     * teclado
     *
     * @param productos Objeto Stock con la lista de productos a modificar
     */
    public void actulizaPrecios(Stock productos) {
            // Mensaje de bienvenida
        System.out.println(" Modificación masiva de precios");
        System.out.println("--------------------------------");
        System.out.print("Ingrese el porcentaje de modificación: ");
            // Solicita el porcentaje al usuario
        Double porcentaje = leer.nextDouble();
            // Bucle para recorrer el HashMap y actualizar los precios de a uno
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
            // Variable donde se va a almacenar el nombre del producto a eliminar
        String nombre;
            // Mensaje de Bienvenida
        System.out.println(" Eliminar producto: ");
        System.out.println(multString("-", " Eliminar producto: ".length()));
            //Solicita el nombre al usuario
        nombre=verificaNombre(productos, "Ingrese el nombre del producto a eliminar: ",true);
            // Verifica si esta vacio para continuar
        if (nombre.trim().isEmpty()) {
            System.out.println("No se ingreso ningun producto. Saliendo...");
            return;
        }
            // Elimina el producto
        productos.getStock().remove(nombre);

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
     * @param productos Objeto Stock con la lista de productos disponibles
     * 
     */
    public void venderProducto(Stock productos) {
            // Variable donde se va a almacenar el nombre del producto a vender
        String nombre;
            // HashMap donde se van a guardar los items de la venta
        HashMap<String, Double[]> items = new HashMap();
            // Mensaje de bienvenida
        System.out.println(" Venta de producto unico:");
        System.out.println("--------------------------");
            // Solicita el nombre del producto al usuario
        nombre = verificaNombre(productos, "Ingrese el nombre del producto a vender (dejar vacio para salir) : ", true);
            // Si el nombre esta vacio sale e informa
        if (nombre.trim().isEmpty()) {
            System.out.println("No se ingreso un nombre, saliendo de venta...");
            return;
        }
            // Solicita la cantidad a vender
        System.out.print("Ingrese la cantidad a vender: ");
            // Agrega el nombre del producto(key) y el precio y la cantidad como Array 
        items.put(nombre, new Double[]{leer.nextDouble(),productos.getStock().get(nombre)});
        System.out.println("");
            //Mustra por pantalla el detalle de la venta
        mostrarVenta(items);
        System.out.println("");
    }
    /**
     * Metodo que permite agregar varios productos a la una venta<br>
     * Si el producto ya fue cargado incrementa la cantidad
     * @param productos Objeto Stock con la lista de productos disponibles
     */
    public void venderProductos(Stock productos) {
            // Variable donde se va almacendo el nombre del producto
        String nombre;
            // HashMap con el detalle de la venta
        HashMap<String, Double[]> items = new HashMap();
            // Mensaje de bienvenida
        System.out.println(" Venta de productos:");
        System.out.println("--------------------------");
            //Bucle que va solicitando los nombres y las cantidades
        do{
                //Solicita el nombre del producto
            nombre = verificaNombre(productos, "Ingrese el nombre del producto a vender (dejar vacio para salir) : ", true);
                // Si el nombre esta vacio se prepara para salir del metodo
            if (nombre.trim().isEmpty()) {
                    // Si items está vacio sale y muestra un mensaje
                if(items.isEmpty()){
                    System.out.println("No se ingresaron datos, saliendo de venta...");
                    return;
                }
                    // En el caso de que items tenga datos informa que se finalizo la venta y muestra el detalle
                System.out.println("Venta finalizada.");
                System.out.println(" Detalle de Venta:");
                System.out.println("-------------------");
                mostrarVenta(items);
                    //Sale del metodo
                return;
            }
                // Solicita la cantidad
            System.out.print("Ingrese la cantidad a vender: ");
                // Si el producto ya está en la venta, le agrega la cantidad ingresada
                // Sino crea el item nuevo
            if (items.containsKey(nombre)) {
                items.replace(nombre, new Double[]{items.get(nombre)[0] + leer.nextDouble(), productos.getStock().get(nombre)});
            } else {
                items.put(nombre, new Double[]{leer.nextDouble(),productos.getStock().get(nombre)});
            }
                // Muestra el detalle de la venta parcial
            System.out.println("");
            mostrarVenta(items);
            System.out.println("");
        } while (true);
    }
    
    /** 
     * Metodo encargado de mostrar por consola el detalle de la venta<br>
     * finaliza con el total de la venta
     * @param productos HashMap con los items de la venta
     */
    private void mostrarVenta(HashMap<String, Double[]> productos) {
            // Variable que almacena la longitud del item mas largo
        int l = maxNombre(productos.keySet());
            // Acumulador para el total de la venta
        Double total = 0.0;
            // Verifica que hay items cargador, si no hay Sale del metodo
        if (productos.isEmpty()) {
            return;
        }
            // Chequea si el titulo "Descripcion" sea mayor que el nombre de producto mas largo
        if (l < 11) {
            l = 11;
        }
            // Formato para los items de la venta
        String st = "| %5s | %-" + l + "s | $ %6.2f |%n";
            // Formato para el encabezado
        String encab = String.format("| Cant  | %-" + l + "s | Precio   |", "Descripcion");
        System.out.println(encab);
            //Escribe guiones debajo del encabezado
        System.out.println(multString("-", encab.length()));
            // Bucle encargado de recorrer el HashMap y mostrar por consola los items
        for (Map.Entry<String, Double[]> producto : productos.entrySet()) {
            System.out.printf(st, String.format("%3.2f", producto.getValue()[0]), producto.getKey(), producto.getValue()[1]);
                // Suma al total la cantidad por precio del producto
            total += producto.getValue()[0] * producto.getValue()[1];
        }
            // Cierre del recuadro de detalle
        System.out.println(multString("-", encab.length()));
            // Muestra el total de la venta
        System.out.printf("%" + l+8 + "s    $ %6.2f  %n", "Total:", total);

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
            // Variable donde se almacena el nombre
        String nombre = "";
            // Bucle usado para volver a perdir un nombre hasta que se encuentre en 
            // productos o no se ingrese ningun valor
        do {
                // Muestra el mensaje pasado por parametro
            System.out.print(textoAMostrar);
                //solicita el ingreso del nombre
            nombre = leer.next();
                // si esta vacio sale(con devuelveVacio = true) o muestra mensaje (con devuelveVacio = false)
            if (nombre.trim().isEmpty()) {
                if (devuelveVacio) {
                    break;
                } else {
                    System.out.println("No se ingreso ningun nombre de producto.");
                }
                // else i
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
