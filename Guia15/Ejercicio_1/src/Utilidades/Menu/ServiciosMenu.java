package Utilidades.Menu;

import Utilidades.Utils.Utils;
import java.util.InputMismatchException;
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
}
