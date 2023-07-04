/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import Libreria.Persistencias.EditorialDAO;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.UUID;
import java.lang.reflect.Field;

/**
 *
 * @author Sebastian Cozzi
 */
public class ServiciosEditorial extends BaseServicios<Editorial>{

    private final EditorialDAO eDAO;

    public ServiciosEditorial() {
        eDAO = new EditorialDAO();
    }

    public Editorial buscarEditorial(String idEditorial) {
        return eDAO.buscarEditorial(idEditorial);
    }

    public List<Editorial> listaDeEditoriales() throws Exception {
        return eDAO.listaCompleta();
    }

    public List<String> listaDeNombresDeEditoriales() {
        return eDAO.listaDeNombres();
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        return eDAO.EditorialPorNombre(nombre);
    }

    public Editorial crearEditorial(String nombre) throws Exception {
        try {
            Editorial e = new Editorial();
            e.setId(UUID.randomUUID().toString());
            e.setNombre(nombre);
            e.setAlta(true);
            eDAO.guardar(e);
            return eDAO.EditorialPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    /*public void mostrar(List<Editorial> lista) throws Exception {
        try {

            int colCount = lista.get(0).getClass().getDeclaredFields().length; // contador con el total de atributos
            int[] anchos = new int[colCount]; // determina el ancho maximo de cada atributo
            char[] align = new char[colCount];// alineacion del atributo (para los tipos numericos van a la derecha)
            String[] titulos = new String[colCount];
            /// obteniendo variables de ajuste

            /// ---- titulos 
            for (int i = 0; i < colCount; i++) {
                titulos[i] = lista.get(0).getClass().getDeclaredFields()[i].getName();
                switch (lista.get(0).getClass().getDeclaredFields()[i].getGenericType().getTypeName()) {
                    case "java.lang.Long":
                    case "java.lang.Integer":
                    case "java.lang.Double":
                        align[i] = '-';
                        break;
                    default:
                        align[i] = ' ';
                }
            }

            /// ---- Anchos de columnas
            Object o;
            for (Editorial e : lista) {
                o = e;
                for (int i = 0; i < colCount; i++) {
                    Field f = e.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    if (anchos[i] < f.get(o).toString().length()) {
                        anchos[i] = f.get(o).toString().length();
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
            System.out.println(Utils.mChar('_',encabezado.length()-2));
            // nombres de campos encabezado
            System.out.println(encabezado);
            // cierre encabezado, y tapa de campos
            System.out.println(Utils.mChar('-',encabezado.length()-2));
            /// lista de campos
            String campos = "|";
            for (Editorial e : lista) { // recorre la lista
                campos = "|";
            for (int i = 0; i < colCount; i++) { // recorre los campos/atributos del objeto
                campos = campos.concat(" %"+ align[i] + (anchos[i]) + "s");
                campos += " |";
                Field f=e.getClass().getDeclaredFields()[i];
                f.setAccessible(true); // desbloquea el atributo
                campos = String.format(campos, f.get(e).toString()); // obtiene el toString del atributo
                f.setAccessible(false); // bloquea el atributo
            }
                System.out.println(campos);// imprime fila de atributos del objeto actual
            }
            // cierre de campos
            System.out.println(Utils.mChar('-',encabezado.length()-2));
            

        } catch (Exception e) {

            throw e;
        }

    }*/
}
/*public void mostrarFabricantes(Collection<Fabricante> fs) {
        try {

            int[] anchos = new int[fDAO.colCount + 1];

            // Define el ancho final de las columnas
            for (int i = 1; i <= fDAO.colCount; i++) {
                if (fDAO.anchoColumnas[i] < fDAO.listaColumnas[i].length()) {
                    anchos[i] = fDAO.listaColumnas[i].length();
                } else {
                    anchos[i] = fDAO.anchoColumnas[i];
                }
                if (fDAO.tipoColumnas[i].equalsIgnoreCase("s")) {
                    anchos[i] = anchos[i] * -1;
                }
            }

            // Genera encabezado
            String linea = "|";
            for (int i = 1; i <= fDAO.colCount; i++) {
                linea = linea.concat(" %" + (anchos[i]) + "s");
                linea += " |";
                linea = String.format(linea, fDAO.listaColumnas[i]);
            }
            System.out.print(" ");
            int lS = linea.length() - 2;
            for (int i = 0; i < lS; i++) {
                System.out.print("_");
            }
            System.out.println("");
            System.out.println(linea);
            System.out.print("|");
            for (int i = 0; i < lS; i++) {
                System.out.print("-");
            }
            System.out.println("|");
            for (Fabricante f : fs) {
                linea = "|";
                for (int i = 1; i <= fDAO.colCount; i++) {
                    linea = linea.concat(String.format(" %%%ds", anchos[i]));
                    linea += " |";
                    linea = String.format(linea, f.getValue(fDAO.listaColumnas[i]));
                }
                linea += "\n";
                System.out.print(linea);
            }
            System.out.print(" ");
            for (int i = 0; i < lS; i++) {
                System.out.print("-");
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }-*/
