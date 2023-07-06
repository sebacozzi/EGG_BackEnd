/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Utilidades.Utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public abstract class BaseServicios<T> {

    public void mostrar(List<T> lista) throws Exception {
        try {

            int colCount = lista.get(0).getClass().getDeclaredFields().length;// contador con el total de atributos
            
            int[] anchos = new int[colCount]; // determina el ancho maximo de cada atributo
            String[] align = new String[colCount];// alineacion del atributo (para los tipos numericos van a la derecha)
            String[] titulos = new String[colCount];
            /// obteniendo variables de ajuste

            /// ---- titulos 
            for (int i = 0; i < colCount; i++) {
                
                titulos[i] = lista.get(0).getClass().getDeclaredFields()[i].getName();
                switch (lista.get(0).getClass().getDeclaredFields()[i].getGenericType().getTypeName()) {
                    case "java.lang.Long":
                    case "java.lang.Integer":
                    case "java.lang.Double":
                        align[i] = "";
                        break;
                    default:
                        align[i] = "-";       
                }
                
            }

            /// ---- Anchos de columnas
            for (int i = 0; i < colCount; i++) {
                anchos[i] = titulos[i].length();
            }
            for (Iterator<T> it = lista.iterator(); it.hasNext();) {
                T e = it.next();
               
                for (int i = 0; i < colCount; i++) {
                    
                    Field f = e.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    if (anchos[i] < f.get(e).toString().length()) {
                        anchos[i] = f.get(e).toString().length();
                    }
                    f.setAccessible(false);
                }
            }
            ////  Mostrar Datos ////
            // Dibujar titulo

            String encabezado = "|";
            // crea el String para los titulos de columnas
            for (int i = 0; i < colCount; i++) {
                
                encabezado = encabezado.concat(" %-" + (anchos[i]) + "s");
                encabezado += " |";
                encabezado = String.format(encabezado, titulos[i]);
                
            }
            //Linea tapa encabezado
            System.out.println(Utils.mChar('_', encabezado.length() - 2));
            // nombres de campos encabezado
            System.out.println(encabezado);
            // cierre encabezado, y tapa de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));
            /// lista de campos
            String campos = "|";
            
            for (Iterator<T> it = lista.iterator(); it.hasNext();) {
                
                T e = it.next();
                
                // recorre la lista
                campos = "|";
                for (int i = 0; i < colCount; i++) { // recorre los campos/atributos del objeto
                    
                            campos = campos.concat(" %" + align[i] + anchos[i] + "s");
                    campos += " |";
                    Field f = e.getClass().getDeclaredFields()[i];
                    f.setAccessible(true); // desbloquea el atributo
                    campos = String.format(campos, f.get(e).toString()); // obtiene el toString del atributo
                    f.setAccessible(false); // bloquea el atributo
                    
                
                }
                System.out.println(campos);// imprime fila de atributos del objeto actual
                
            }
            // cierre de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));

        } catch (Exception e) {

            throw e;
        }
    }
    
    public void mostrarSegunTitulos(List<T> lista, String[] columnas) throws Exception{
        if (columnas.length==0) {
            mostrar(lista);
            return;
        }
        try {
            
            int colCount = lista.get(0).getClass().getDeclaredFields().length;// contador con el total de atributos
            
            int[] anchos = new int[colCount]; // determina el ancho maximo de cada atributo
            String[] align = new String[colCount];// alineacion del atributo (para los tipos numericos van a la derecha)
            String[] titulos = new String[colCount];
            /// obteniendo variables de ajuste

            /// ---- titulos 
            for (int i = 0; i < colCount; i++) {
                
                titulos[i] = lista.get(0).getClass().getDeclaredFields()[i].getName();
                switch (lista.get(0).getClass().getDeclaredFields()[i].getGenericType().getTypeName()) {
                    case "java.lang.Long":
                    case "java.lang.Integer":
                    case "java.lang.Double":
                        align[i] = "";
                        break;
                    default:
                        align[i] = "-";       
                }
                
            }

            /// ---- Anchos de columnas
            for (int i = 0; i < colCount; i++) {
                anchos[i] = titulos[i].length();
            }
            for (Iterator<T> it = lista.iterator(); it.hasNext();) {
                T e = it.next();
               
                for (int i = 0; i < colCount; i++) {
                    
                    Field f = e.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    if (anchos[i] < f.get(e).toString().length()) {
                        anchos[i] = f.get(e).toString().length();
                    }
                    f.setAccessible(false);
                }
            }
            ////  Mostrar Datos ////
            // Dibujar titulo

            String encabezado = "|";
            // crea el String para los titulos de columnas
            for (int i = 0; i < colCount; i++) {
                if (Arrays.asList(columnas).contains(titulos[i])) {
                    
                
                encabezado = encabezado.concat(" %-" + (anchos[i]) + "s");
                encabezado += " |";
                encabezado = String.format(encabezado, titulos[i]);
                }
            }
            //Linea tapa encabezado
            System.out.println(Utils.mChar('_', encabezado.length() - 2));
            // nombres de campos encabezado
            System.out.println(encabezado);
            // cierre encabezado, y tapa de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));
            /// lista de campos
            String campos = "|";
            
            for (Iterator<T> it = lista.iterator(); it.hasNext();) {
                
                T e = it.next();
                
                // recorre la lista
                campos = "|";
                for (int i = 0; i < colCount; i++) { // recorre los campos/atributos del objeto
                    if (Arrays.asList(columnas).contains(titulos[i])) {
                            campos = campos.concat(" %" + align[i] + anchos[i] + "s");
                    campos += " |";
                    Field f = e.getClass().getDeclaredFields()[i];
                    f.setAccessible(true); // desbloquea el atributo
                    campos = String.format(campos, f.get(e).toString()); // obtiene el toString del atributo
                    f.setAccessible(false); // bloquea el atributo
                    }
                
                }
                System.out.println(campos);// imprime fila de atributos del objeto actual
                
            }
            // cierre de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));

        } catch (Exception e) {
        }
    }
    public void mostrar1(List<String> lista, String titulo) throws Exception {
        try {
            
            int ancho = titulo.length(); // determina el ancho maximo de cada atributo
            String align = "-";// alineacion del atributo (para los tipos numericos van a la derecha)
            
            /// obteniendo variables de ajuste
            /// ---- Anchos de columnas
            for (String e : lista) {
                    if (ancho < e.length()) {
                        ancho = e.length();
                    }
            } ////  Mostrar Datos ////
            // Dibujar titulo
            
            String encabezado  = "| %-" + ancho + "s |";
                encabezado = String.format(encabezado, titulo);
            
            //Linea tapa encabezado
            System.out.println(Utils.mChar('_', encabezado.length() - 2));
            // nombres de campos encabezado
            System.out.println(encabezado);
            // cierre encabezado, y tapa de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));
            /// lista de campos
            String campos ;
            for (String e : lista) {
                // recorre la lista
                campos = "| %-" + ancho + "s |";
                campos = String.format(campos, e); // obtiene el toString del atributo
                System.out.println(campos);// imprime fila de atributos del objeto actual
            }
            // cierre de campos
            System.out.println(Utils.mChar('-', encabezado.length() - 2));

        } catch (Exception e) {

            throw e;
        }
    }
    public void mostar1(String texto,String titulo) throws Exception{
        List<String> l = new ArrayList<>();
        l.add(texto);
        mostrar1(l,titulo);
    }
    public void mostrar(T ob) throws Exception{
        List<T> l = new ArrayList<>();
        l.add(ob);
        mostrar(l);
    }
}
