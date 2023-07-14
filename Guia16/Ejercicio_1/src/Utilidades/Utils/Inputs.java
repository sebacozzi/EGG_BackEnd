/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Utils;

import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Inputs {
    
    /// *********** Inicio int y Integer *********** ///
    public static int inputI(String mensaje) {
        return inputInteger(mensaje).intValue();
    }
    
    public static Integer inputInteger(String mensaje) {
        Integer val;
        String ingreso="";
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.print(mensaje);
        do {
            try {
                ingreso = leer.next();
                val = Integer.getInteger(ingreso);
                break;
            } catch (Exception e) {
                System.out.println("["+ingreso+"]");
                if(ingreso==null) {
                    return null;
                }
                System.out.printf("%s no es un número entero.\n -> ", ingreso);
            }
        } while (true);
        return val;
    }
    /// *********** Fin int y Integer *********** ///
    
    /// *********** Inicio long y Long *********** ///
    public static long inputL(String mensaje){
        return inputLong(mensaje).longValue();
    }
    
    public static Long inputLong(String mensaje) {
        Long val;
        String ingreso="";
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        boolean Estado = true;
        
        do {
            try {
                if(Estado){
                    System.out.print(mensaje);
                } else
                    System.out.printf("%s no es un número entero largo.\n -> ", ingreso);
                ingreso = leer.nextLine();
                val = Long.parseLong(ingreso);
                break;
            } catch (Exception e) {
                if (ingreso.trim().isEmpty()) {
                    return null;
                }
                Estado = false;
            }
        } while (true);
        return val;
    }
    /// *********** Fin long y Long *********** ///
    
    /// *********** Inicio double y Double *********** ///
    public static double inputD(String mensaje) {
        return inputDouble(mensaje).doubleValue();
    }
    
    public static Double inputDouble(String mensaje) {
        Double val;
        String ingreso="";
        String subMsg= "";
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.print(mensaje);
        do {
            try {
                ingreso = leer.next();
                val = Double.valueOf(ingreso);
                break;
            } catch (NumberFormatException e) {
                if (ingreso.contains(".")) {
                    subMsg = "Ingreso \".\" en lugar de \",\" como separador decimal.";
                } else if (ingreso.contains(",")) {
                    subMsg = "Ingreso \",\" en lugar de \".\" como separador decimal.";
                }
                System.out.printf("%s no es un número decimal largo.%s\n -> ",ingreso,subMsg);
                subMsg="";
            }
        } while (true);
        return val;
    }
    /// *********** Fin double y Doble *********** ///
    
    /// *********** Inicio float y Float *********** ///
    public static float inputF(String mensaje) {
        return inputFloat(mensaje).floatValue();
    }
    
    public static Float inputFloat(String mensaje) {
        Float val;
        String ingreso="";
        String subMsg= "";
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        System.out.print(mensaje);
        do {
            try {
                ingreso = leer.next();
                val = Float.valueOf(ingreso);
                break;
            } catch (NumberFormatException e) {
                if (ingreso.contains(".")) {
                    subMsg = "Ingreso \".\" en lugar de \",\" como separador decimal.";
                } else if (ingreso.contains(",")) {
                    subMsg = "Ingreso \",\" en lugar de \".\" como separador decimal.";
                }
                System.out.printf("%s no es un número decimal largo.%s\n -> ",ingreso,subMsg);
                subMsg="";
            }
        } while (true);
        return val;
    }
    /// *********** Fin float y Float *********** ///

    
}
