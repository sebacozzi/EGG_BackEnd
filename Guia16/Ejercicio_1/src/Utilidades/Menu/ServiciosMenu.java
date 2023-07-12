package Utilidades.Menu;

import Utilidades.Utils.Utils;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sebasti�n Cozzi
 */
public class ServiciosMenu {
    // Scanner encargado de capturar los ingresos por teclado, "ISO-8859-1" es para
    // que tome los caracteres con acento y la ñ, useDelimiter es para que el next()
    // lea hasta el salto de linea

    Scanner leer = new Scanner(System.in, "ISO-8859-1")/*.useDelimiter("\n")*/;
    private int resultado;
    private boolean esSalir = false;
    private String textResultado="";

    public int getResultado() {
        return resultado;
    }

    public boolean esSalir() {
        return esSalir;
    }

    /**
     * Metodo que muestra el menu de opciones (numericas) y sale cuando se
     * ingresa una opci�n valida. controla lo que se ingresa sea un n�mero. el
     * valor de la opci�n elegida se obtiene con getResultado()
     * <pre> {@code obj.show(Menu menu)}
     * </pre>
     *
     * @param menu Parametro de tipo Menu que se va a utilzar para mostrar
     */
    public void show(Menu menu) {

        boolean salida, error;

        do {
            Utils.cls();// limpia el output
            System.out.print(menu.toString());
            salida = true;
            error = true;
            try {
                resultado = leer.nextInt();
                esSalir = resultado == menu.getItems().length;
                textResultado = menu.getItems()[resultado-1];
            } catch (InputMismatchException e) {
                System.out.printf("Debe ingresar un número. Ingreso %s.\n", resultado);
                leer.next();
                error = false;
                Utils.esperaTecla();
            }
            if (resultado > 0 && resultado <= menu.getItems().length) {
                salida = false;
            } else if (error) {
                System.out.println("ingrese un número del 1 al " + menu.getItems().length + ".");
                Utils.esperaTecla();
            }
        } while (salida);
    }
    
    public void showMenu(String[] opciones,String titulo){
        show(new Menu(opciones,titulo));
    }
    
    public int preguntaInt(String texto) {
        boolean salida = false;
        do {
            System.out.print(texto);

            try {
                salida = false;
                resultado = leer.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Opción incorrecta,ingrese un número entero!");
                leer.next();
                salida = true;
            }
        } while (salida);
        return resultado;
    }

    public boolean preguntaSN(String texto) {
        do {
            System.out.print(texto);
            switch (leer.next().toLowerCase().charAt(0)) {
                case 's':
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Opción incorrecta, es s o n!!");
            }
        } while (true);

    }
    
    public static HashMap<Integer,String> multipleChoice(List<String> opciones, String titulo){
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
       HashMap<Integer,String> resultado= new HashMap();
       int indice =1;
       /// dibuja opciones
        System.out.println(" "+titulo);
        System.out.println(Utils.mChar('-', titulo.length()));
        for (String opcion : opciones) {
            System.out.printf("%"+ ((int) Math.log(opciones.size()))+"d) %s.\n",indice,opcion);
            indice++;
        }
        System.out.print("Elija una opción: ");
        do {
           int i=0;
            try {
                 i= leer.nextInt();
                resultado.put(i, opciones.get(i-1));
                break;
            } catch (InputMismatchException e) {
                System.out.println("No se ingreso un número... debe ingresar de 1 a "+opciones.size()+'.');
                leer.next();
                System.out.print("-> ");
                continue;
            } catch (Exception ex){
                System.out.println("Se ingreso un número, pero debe ser del 1 a "+opciones.size()+'.');
                System.out.print("-> ");
                continue;
            }
        } while (true);
        
        return resultado;
    }
    
    public String getStringMC(HashMap<Integer,String> resultado){
        return (String) resultado.values().toArray()[0];
    }
    public int getintMC(HashMap<Integer,String> resultado){
        return (int) resultado.keySet().toArray()[0];
    }
    
    public static boolean preguntaSNExt(String texto) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        do {
            System.out.print(texto);
            switch (leer.next().toLowerCase().charAt(0)) {
                case 's':
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Opción incorrecta, es s o n!!");
            }
        } while (true);

    }
}
