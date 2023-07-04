
package Utilidades;

import Utilidades.Menu.Menu;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Utils;


/**
 *
 * @author Sebasti�n Cozzi
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] op1 = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5", "Volver"};
        String[] op0 = {"Opción 1", "Opción 2", "Salir"};
        String[] op2 = {"Opción 4", "Opción 5", "Volver"};
        ServiciosMenu sm = new ServiciosMenu();
        boolean salida;
        String hola=null;
        do {
            salida = true;
            
            // crea el menu en tiempo de ejecución sin necesidad de instanciar el menu
            sm.show(new Menu(op0, "menu Principal"));
            /// para manejar una opción que crea un objeto nuevo:
            /// instanciar el objeto = null
            /// agregar este if antes del switch
            /// if ('objeto'!=null && (sm.getResultado()==1 && sm.getResultado!=op0.length)
            if (hola!=null || (sm.getResultado()==1 || sm.getResultado() == op0.length)){
                switch (sm.getResultado()) {
                    case 1:
                        do {
                            sm.show(new Menu(op1, "Menu Opción 1"));
                            switch (sm.getResultado()) {
                                case 1:
                                    System.out.println("Opción 1 elejida.");
                                    hola="hola";
                                    System.out.println(hola);
                                    break;
                                case 2:
                                    System.out.println("Opción 2 elejida.");
                                    break;
                                case 3:
                                    System.out.println("Opción 3 elejida.");
                                    break;
                                case 4:
                                    System.out.println("Opción 4 elejida.");
                                    break;
                                case 5:
                                    System.out.println("Opción 5 elejida.");
                                    break;
                                case 6:
                                    System.out.println("Volver al menu principal");
                            }
                            Utils.esperaTecla();
                            if (sm.getResultado() == 6) {
                                break;
                            }
                        } while (true);
                        break;
                    case 2:
                        sm.show(new Menu(op2, "Menu Opción 2"));
                        System.out.println("Los resultados de las opciones no estan controladas... vuelve al menu principal.");
                        Utils.esperaTecla();
                        break;
                    case 3:
                        salida = false;
                }
            } else{
                System.out.println("Inicie opción 1 - "+((sm.getResultado()!=1 || sm.getResultado() != op0.length))+hola);
                Utils.esperaTecla();
            }
        } while (salida);

    }

}
