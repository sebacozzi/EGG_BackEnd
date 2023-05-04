package menudeopciones;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @author Sebasti�n Cozzi
 */

public class ServiciosMenu {

    private int resultado;

    public int getResultado() {
        return resultado;
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
        // inicializaci�n de Scanner
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean salida, error;

        do {
            cls();// limpia el output
            System.out.print(menu.toString());
            salida = true;
            error = true;
            try {
                resultado = leer.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                leer.next();
                error = false;
                esperaTecla();
            }
            if (resultado > 0 && resultado <= menu.getItems().length) {
                salida = false;
            } else if (error) {
                System.out.println("ingrese un número del 1 al " + menu.getItems().length + ".");
                esperaTecla();
            }
        } while (salida);
    }

    public void esperaTecla() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Precione Enter/Intro para continuar.");
        leer.nextLine();
    }

    private static void cls() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
        } catch (AWTException e) {
        }
    }
}
