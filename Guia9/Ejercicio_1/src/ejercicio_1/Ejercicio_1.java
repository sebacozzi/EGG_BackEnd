/**Realizar una clase llamada Cadena, en el paquete de entidades, que tenga como
 * atributos una frase (String) y su longitud. Agregar constructor vacío y con
 * atributo frase solamente. Agregar getters y setters. El constructor con frase
 * como atributo debe setear la longitud de la frase de manera automática. Crear
 * una clase CadenaServicio en el paquete servicios que implemente los
 * siguientes métodos:
 *  a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que
 * tiene la frase ingresada.
 *  b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla
 * por pantalla. Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
 *  c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el
 * usuario y contabilizar cuántas veces se repite el carácter en la frase, por
 * ejemplo:
 *      Entrada: frase = "casa blanca". Salida: El carácter 'a' se repite 4 veces.
 *  d) Método compararLongitud(String frase), deberá comparar la longitud de la
 * frase que compone la clase con otra nueva frase ingresada por el usuario.
 *  e) Método unirFrases(String frase), deberá unir la frase contenida en la
 * clase Cadena con una nueva frase ingresada por el usuario y mostrar la frase
 * resultante.
 *  f) Método reemplazar(String letra), deberá reemplazar todas las letras “a”
 * que se encuentren en la frase, por algún otro carácter seleccionado por el
 * usuario y mostrar la frase resultante.
 *  g) Método contiene(String letra), deberá comprobar si la frase contiene una
 * letra que ingresa el usuario y devuelve verdadero si la contiene y falso si no.
 */
package ejercicio_1;

import Entidades.Cadena;
import Servicios.CadenaServicio;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer=new Scanner(System.in).useDelimiter("\n");
        Cadena cd = new Cadena("Hola Mundo");
        CadenaServicio cs = new CadenaServicio();
        //a)
        System.out.println("a) Método mostrarVocales()");
        cs.mostrarVocales(cd);
        System.out.println("");
        //b)
        System.out.println("b) Método invertirFrase()");
        cs.invertirFrase(cd);
        System.out.println("");
        //c)
        System.out.println("c) Método vecesRepetido(String letra)");
        System.out.print("Ingrese una letra: ");
        String letra= leer.next().substring(0, 1);
        System.out.println(String.format("La letra \"%s\" se repite %d veces.", letra, cs.vecesRepetido(cd,letra)));
        System.out.println("");
        leer.nextLine();
        //d)
        System.out.println("d) Método compararLongitud(String frase)");
        System.out.println("Ingrese una frase nueva para comparar la longitud con la frase guardada:");
        cs.compararLongitudes(cd,leer.nextLine());
        System.out.println("");
        //e)
        System.out.println("e) Método unirFrases(String frase)");
        System.out.println("Ingrese una frase para unirla a la anterior:");
        cs.unirFrase(cd, leer.nextLine());
        System.out.println("");
        //f)
        System.out.println("f) Método reemplazar(String letra)");
        System.out.print("Ingrese una letra para reemplazar las \"a\" de la frase: ");
        cs.reemplazar(cd, leer.next().substring(0, 1));
        System.out.println("");
        //g)
        System.out.println("g) Método contiene(String letra)");
        System.out.print("Ingrese una letra para verificar si está en la frase: ");
        if (cs.contiene(cd,leer.next().substring(0, 1))) {
            System.out.println("La letra ingresada está en la frase.");
        }else {
            System.out.println("La letra ingresada no se encuentra en la frase.");
        }
    }
    
}
