/**  a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que
 * tiene la frase ingresada.
 *  b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla
 * por pantalla. Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
 *  c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el
 * usuario y contabilizar cuántas veces se repite el carácter en la frase, por
 * ejemplo:
 *      Entrada: frase = "casa blanca". Salida: El carácter "a" se repite 4 veces.
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
package Servicios;

import Entidades.Cadena;

/**
 *
 * @author Usuario
 */
public class CadenaServicio {
/**  a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que
 * tiene la frase ingresada.
 * 
     * @param cadena
 */
public void mostrarVocales(Cadena cadena){
    String[] vocales= {"a","e","i","o","u","á","é","í","ó","ú","ü"};
    String temp = cadena.getFrase();
    for (int i = 0; i < vocales.length; i++) {
        temp = temp.replaceAll(vocales[i], "");
    }
    System.out.println(String.format("Hay %d vocales en la frase %s.", (cadena.getLongitud()-temp.length()),cadena.getFrase()));
}
    
 /**  b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla
 * por pantalla. Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
 * 
     * @param cadena
 */

public void invertirFrase(Cadena cadena){
    System.out.println("Frase ingresada: ".concat(cadena.getFrase()));
    System.out.print("Frase invertida: ");
    for (int i = 0; i < cadena.getLongitud(); i++) {
        System.out.print(cadena.getFrase().charAt((cadena.getLongitud()-1)-i));
    }
    System.out.println(".");
}


/**  c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el
 * usuario y contabilizar cuántas veces se repite el carácter en la frase, por
 * ejemplo:
 *      Entrada: frase = "casa blanca". Salida: El carácter "a" se repite 4 veces.
 * 
     * @param cadena
     * @param letra
     * @return Devuelve la cantidad de veces que se repite la letra ingresada
     *  no es sensible a mayusculas y minusculas
 */
    public int vecesRepetido(Cadena cadena,String letra){
        return cadena.getLongitud() - cadena.getFrase().toLowerCase().replaceAll(letra.toLowerCase(), "").length();
    }
    
 /**  d) Método compararLongitud(String frase), deberá comparar la longitud de la
 * frase que compone la clase con otra nueva frase ingresada por el usuario.
 * 
     * @param cadena
     * @param frase
 */
   public void compararLongitudes(Cadena cadena, String frase){
       if (cadena.getLongitud()< frase.length()) {
           System.out.println("La longitud de la frase ingresada es mayor que la guarda.");
       } else if (cadena.getLongitud()>frase.length()) {
           System.out.println("La longitud de la frase ingresada es menor que la guarda.");
       } else{
           System.out.println("La longitud de la frase y la guarda son iguales.");
       }
   }
    
 /**  e) Método unirFrases(String frase), deberá unir la frase contenida en la
 * clase Cadena con una nueva frase ingresada por el usuario y mostrar la frase
 * resultante.
 * 
     * @param cadena
     * @param frase
 */

public void unirFrase(Cadena cadena,String frase){
    cadena.setFrase(cadena.getFrase().concat(frase));
    System.out.println(String.format("Las frases unidas quedan: %s.",cadena.getFrase()));
}   
    
 /**  f) Método reemplazar(String letra), deberá reemplazar todas las letras “a”
 * que se encuentren en la frase, por algún otro carácter seleccionado por el
 * usuario y mostrar la frase resultante.
 * 
 */
public void reemplazar(Cadena cadena,String letra){
    String temp = cadena.getFrase();
    String resulta ="";
    for (int i = 0; i < temp.length(); i++) {
        if (temp.substring(i, i+1).equalsIgnoreCase("a")) {
            resulta = resulta.concat(letra);
           
        }else{
            resulta=resulta.concat(temp.substring(i, i+1));
        }

    }
    System.out.println("frase");
    System.out.println(String.format("La frase resultante remplazando las \"a\" con \"%s\" es:\n %s",letra, resulta));
    
}
    
 /**  g) Método contiene(String letra), deberá comprobar si la frase contiene una
 * letra que ingresa el usuario y devuelve verdadero si la contiene y falso si no.
     * @param cadena
     * @param letra
     * @return 
 */
    public boolean contiene(Cadena cadena, String letra){
        return cadena.getFrase().contains(letra);
    }
}
