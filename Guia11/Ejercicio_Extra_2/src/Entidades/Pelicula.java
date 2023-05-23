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
class Pelicula {
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
        this.título = "El Señor de los anillos";
        this.duración = 2.5;
        this.edadMinima = 16;
        this.director = "No se";
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
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

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula:\n    Título: " + título + ".\n    Duración: " + duración + ".\n    Edad Mínima: " + edadMinima + ".\n    Director: " + director + ".\n";
    }
    
}
