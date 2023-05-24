/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián Cozzi
 */
public class Expectador {

    private final String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro",
        "Gabriela", "Diego", "Silvia", "Javier", "Valentina", "Santiago", "Mariana",
        "Andrés", "Florencia", "Emilio", "Victoria", "Hugo", "Julia"};

    private final String[] apellidos = {"González", "Rodríguez", "Fernández", "López", "Martínez",
        "Gómez", "Pérez", "Sánchez", "Romero", "Torres", "Díaz", "Morales", "Vargas",
        "Rojas", "Acosta", "Molina", "Suárez", "Ramos", "Silva", "Cabrera"};
    private String nombre;
    private Integer edad;
    private Double dinero;
    private String butaca;

    @Override
    public String toString() {
        return "Expectador:"
                + "\n    Nombre: " + nombre
                + ".\n     Edad: " + edad
                + "\n    Dinero: $ " + dinero
                + ".-\n    Butaca: " + butaca + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

    public String getButaca() {
        return butaca;
    }

    public void setButaca(String butaca) {
        this.butaca = butaca;
    }

    /**
     * Crea Expectador en forma aleatoria con base a 20 nombre y 20 apellidos,
     * La edad en el rango de 5 a 60 años y dinero de 0 a 500 y no ocupa ninguna
     * butaca
     */
    public Expectador() {
        this.nombre = randNombre() + " " + randApellido();
        this.edad = (int) Math.round(Math.random() * 55) + 5;
        this.dinero = Math.random() * 500;
        this.butaca = "";
    }

    private String randNombre() {
        return nombres[(int) Math.round(Math.random() * (nombres.length-1))];
    }

    private String randApellido() {
        return apellidos[(int) Math.round(Math.random() * (nombres.length-1))];
    }
}
