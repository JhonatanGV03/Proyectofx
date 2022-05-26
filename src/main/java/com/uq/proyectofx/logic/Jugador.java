package com.uq.proyectofx.logic;

public class Jugador {
    private String nombre;
    private int turno;
    private int[][]posicion;

    public Jugador(){
        this.nombre = "";
        this.turno = 0;
        this.posicion = new int[8][8];
    }

    public String setNombre(String nombre){
        this.nombre = nombre;
        return nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int[][] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[][] posicion) {
        this.posicion = posicion;
    }
}
