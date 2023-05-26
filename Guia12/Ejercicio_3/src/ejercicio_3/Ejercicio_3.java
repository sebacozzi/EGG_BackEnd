/*Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de
2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
electrodomésticos, 2000 para lavadora y 5000 para televisor.
 */
package ejercicio_3;
 
/**
 *
 * @author Sebastian Cozzi
 */
import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import java.io.PrintStream;
import java.util.ArrayList;

public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] colores={"BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS"};
        char[] consumos={'A','B','C','D','E','F'};
        ArrayList<Electrodomestico> arrayElectro = new ArrayList();
        for (int i = 0; i < 4; i++) {
            if (Math.round(Math.random())==1) {
                arrayElectro.add(new Lavadora(Math.random()*40, Math.random()*10000, 
                        colores[(int)Math.random()*colores.length], 
                        consumos[(int)Math.random()*consumos.length], Math.random()*95));
            }else{
                arrayElectro.add(new Televisor(Math.random()*75,Math.round(Math.random())==1,
                        Math.random()*15000,colores[(int) (Math.random() * colores.length - 1)], 
                        consumos[(int) (Math.random() * consumos.length - 1)], Math.random()*95));
            }
        }
        Double  sumaPrecios=0d;
        for (Electrodomestico electrodomestico : arrayElectro) {
            if (electrodomestico instanceof Lavadora) {
                Lavadora l1 = (Lavadora) electrodomestico;
                sumaPrecios += l1.precioFinal();
                System.out.printf("Precio de la lavadora: $ %.3f.-\n", l1.precioFinal());
            } else if (electrodomestico instanceof Televisor) {
                Televisor t1= (Televisor) electrodomestico;
                sumaPrecios += t1.precioFinal();
                System.out.printf("Precio del televisor: $ %.3f.-\n",t1.precioFinal());
            }
        }
        System.out.println("");
        System.out.printf("Precio total de los electrodomesticos: $ %.3f.-\n", sumaPrecios);
    }
    
}
