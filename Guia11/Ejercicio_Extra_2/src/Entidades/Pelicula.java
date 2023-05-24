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
public class Pelicula {

    private final String[] peliculas = {"Pulp Fiction", "El Padrino", "El Señor de los Anillos: La Comunidad del Anillo", "Interestelar",
        "La La Land", "Titanic", "El club de la pelea", "Memento", "El Gran Lebowski", "El Resplandor"};

    private final double[] duracion = {2.34, 2.55, 2.58, 2.49, 2.08, 3.14, 2.19, 1.53, 1.57, 2.26};

    private final int[] edadMinimas = {18, 18, 12, 13, 12, 13, 18, 16, 18, 16};

    private final String[] directores = {"Quentin Tarantino", "Francis Ford Coppola", "Peter Jackson", "Christopher Nolan",
        "Damien Chazelle", "James Cameron", "David Fincher", "Christopher Nolan", "Joel Coen, Ethan Coen", "Stanley Kubrick"};

    private String título;
    private Double duración;
    private Integer edadMinima;
    private String director;

    public Pelicula(String título, Double duración, Integer edadMinima, String director) {
        this.título = título;
        this.duración = duración;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public Pelicula() {
        int id = (int) Math.round(Math.random() * peliculas.length);
        this.título = peliculas[id];
        this.duración = duracion[id];
        this.edadMinima = edadMinimas[id];
        this.director = directores[id];
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }
    public void setPelicula(int id){
        this.título = peliculas[id];
        this.duración = duracion[id];
        this.edadMinima = edadMinimas[id];
        this.director = directores[id];
    }
    public Double getDuración() {
        return duración;
    }

    public void setDuración(Double duración) {
        this.duración = duración;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public String[] listaDePeliculas() {
        return peliculas;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula:\n    Título: " + título + ".\n    Duración: " + duración + ".\n    Edad Mínima: " + edadMinima + ".\n    Director: " + director + ".\n";
    }

}
