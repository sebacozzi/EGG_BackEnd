/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Stock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class StockServicios {

    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
    // que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
    // lea hasta el salto de linea
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    private Object nombre;
    
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
     * @param productos Objeto de clase Stock con los Productos
     */
    public void cargarProductos(Stock productos) {
        // variable usada para saber si se cargo algun producto
        int tamanio = productos.size();
        while (cargarProducto(productos)) {
        }
        if (tamanio==productos.size()) 
            System.out.println("No se cargo ningun producto.");
    }
    /**
     * Metodo encargado de mostrar la lista de productos y precios
     * @param productos 
     */
    public void mostrar(Stock productos){
        int l=productos.maxNombre();
        String st="| %04d | %-"+l+"s | $ %6.2f |%n";
        int cont=1;
        String encab=String.format("|  ID  | %-"+l+"s | Precio   |","Descripcion", "Descripción");
        System.out.println(encab);
        System.out.println(multString("-",encab.length()));
        for (Map.Entry<String,Double> producto : productos.getStock().entrySet()) {
            System.out.printf(st,cont,producto.getKey(),producto.getValue());
            cont++;
        }
        System.out.println(multString("-",encab.length()));
    }
    /**
     * 
     * @param productos 
     */
    public void modificaPrecio(Stock productos) {
        System.out.println(" Modificar precio de Producto");
        System.out.println("------------------------------");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre;
        do{
            nombre = leer.next();
            if (nombre.trim().isEmpty()){
                System.out.println("No ingreso ningun nombre... vuelva a intentar.");
            } else if (!productos.getStock().containsKey(nombre)) {
                System.out.printf("El producto %s no existe.%n",nombre);
            }else break;
        } while (true);
        System.out.printf("Precio actual: $ %4.2f%n",productos.getStock().get(nombre));
        System.out.print("Ingrese el nuevo precio:");
        Double nPrecio = leer.nextDouble();
        productos.getStock().replace(nombre, nPrecio);
        
    }
    /**
 * 
 * @param productos 
 */
    public void actulizaPrecios(Stock productos) {
        
        System.out.print("Ingrese el porcentaje de modificación: ");
        Double porcentaje = leer.nextDouble();
         for (Map.Entry<String,Double> producto : productos.getStock().entrySet()) {
            producto.setValue(producto.getValue()*(1+(porcentaje/100)));
        }
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
    private String multString(String s,int multi){
        String r="";
        for (int i = 0; i < multi; i++) {
            r = r.concat(s);
        }
        return r;
    }

}
