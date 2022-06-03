package com.uq.proyectofx.logic;

public class Jugador {
    private String nombre;
    private int posicion;

    public Jugador(){
        this.nombre = ".";
        this.posicion = 0;
    }

    public String setNombre(String nombre){
        this.nombre = nombre;
        return nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
