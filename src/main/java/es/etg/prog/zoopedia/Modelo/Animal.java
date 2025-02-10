package main.java.es.etg.prog.zoopedia.Modelo;

public class Animal {
    private String nombre;
    private Tipo tipo;
    private int numCuernos;
    private int numColmillos;
    private int puntos;
    private boolean favorito;
    private Nivel nivel;

    public Animal(){}

    public Animal(String nombre, Tipo tipo, int numCuernos, int numColmillos){
        this.nombre = nombre;
        this.tipo = tipo;
        this.numCuernos = numCuernos;
        this.numColmillos = numColmillos;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Tipo getTipo(){
        return tipo;
    }

    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public int getNumCuernos(){
        return numCuernos;
    }

    public void setNumCuernos(int numCuernos) {
        this.numCuernos = numCuernos;
    }

    public int getNumColmillos(){
        return numColmillos;
    }

    public void setNumColmillos(int numColmillos) {
        this.numColmillos = numColmillos;
    }

    public boolean getFavorito(){
        return favorito;
    }

    public void setFavorito(boolean favorito){
        this.favorito = favorito;
    }

    public void setNivel(Nivel nivel){
        this.nivel = nivel;
    }

    public Nivel getNivel(){
        return nivel;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }

    @Override
    public String toString(){
        return "Animal" + "\n" +
        "Nombre: " + nombre + "\n" +
        "Tipo: " + tipo + "\n" +
        "Cuernos: " + numCuernos + "\n" +
        "Colmillos: " + numColmillos + "\n" +
        "Puntos: " + puntos + "\n" +
        "Nivel: " + nivel + "\n" +
        "Favorito: " + favorito;
    }
}