/** Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
 * edificio tendrá como métodos:
 * • Método calcularSuperficie(): calcula la superficie del edificio.
 * • Método calcularVolumen(): calcula el volumen del edifico.
 * Estos métodos serán abstractos y los implementarán las siguientes clases:
 * • Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o
 * Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.
 * • Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas
 * por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y
 * los atributos del padre.
 * De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
 * usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
 * (suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
 * cuantas personas entrarían en un piso y cuantas en todo el edificio.
 *
 * 16
 * Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
 * dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
 * métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
 * superficie y el volumen de cada edificio.
 * Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
 * techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
 * cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package ejercicio_extra_2;

import Entidades.Edificio;
import Entidades.EdificioDeOficinas;
import Entidades.Polideportivo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_Extra_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Edificio> edificios = new ArrayList();
        int contAbierto =0;
        int contTechado =0;
        creaEdificios(edificios);
        Iterator it = edificios.iterator();

        while (it.hasNext()) {
            Edificio ed = (Edificio) it.next();
            System.out.printf("La superficie del %s es: %.3f.\n",
                    ed.getClass().toString().substring(ed.getClass().toString().indexOf(".") + 1),
                    ed.calcularSuperficie());
            if (ed.calcularVolumen() != 0) {
                System.out.printf("El volumen del %s es: %.3f.\n",
                        ed.getClass().toString().substring(ed.getClass().toString().indexOf(".") + 1),
                        ed.calcularVolumen());
                contTechado++;
            } else contAbierto++;
            System.out.println("");
        }
        System.out.printf("De los polideportivos hay %d techados y %d abiertos.\n", contTechado, contAbierto);
        for (Edificio edificio : edificios) {
            if (edificio instanceof EdificioDeOficinas) {
                EdificioDeOficinas eofi = (EdificioDeOficinas) edificio;
                eofi.cantPersonas();
            }
        }
    }

    private static void creaEdificios(List<Edificio> edif) {
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0) {
                Polideportivo p = new Polideportivo(Math.round(Math.random()) == 1., "Polideportivo N° " + i, 150d * i, 2.58 * i, 37d * i);
                edif.add(p);

            } else {
                EdificioDeOficinas eo = new EdificioDeOficinas(2 * i, 4 * i, 3 * i, 8d * i, 3 * 3d * i, 12d * i);
                edif.add(eo);
            }
        }
    }
}
