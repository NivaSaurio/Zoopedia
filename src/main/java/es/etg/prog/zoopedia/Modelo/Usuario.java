package main.java.es.etg.prog.zoopedia.Modelo;

import java.util.ArrayList;

public class Usuario{
    private String nombre;
    private int puntos;
    private static ArrayList<Animal> listaAnimales = new ArrayList<>(); 

    public Usuario(){}

    public Usuario(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getPuntos(){
        return puntos;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public void agregarAnimal(Animal animal){
        listaAnimales.add(animal);
    }

    public ArrayList<Animal> getListaAnimales(){
        return listaAnimales;
    }

}