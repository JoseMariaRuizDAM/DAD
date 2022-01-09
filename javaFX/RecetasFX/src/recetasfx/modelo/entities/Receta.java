/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.entities;

/**
 *
 * @author Jose
 */
public class Receta {
    
    String nombre, autor, tipoReceta, ingredientes, pasos;
    int comensales, tiempoPreparacion, calorias;
    
    
    /**
     * Constructor que recoge todos los datos de la receta
     */
    public Receta(String titulo, String autor, String tipoReceta, String ingredientes, String pasos, int comensales, int tiempoPreparacion, int calorias) {
        this.nombre = titulo;
        this.autor = autor;
        this.tipoReceta = tipoReceta;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.comensales = comensales;
        this.tiempoPreparacion = tiempoPreparacion;
        this.calorias = calorias;
    }

    /**
     * Constructor por defecto
     */
    public Receta(){}
    
    //Comienzo de Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipoReceta() {
        return tipoReceta;
    }

    public void setTipoReceta(String tipoReceta) {
        this.tipoReceta = tipoReceta;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
