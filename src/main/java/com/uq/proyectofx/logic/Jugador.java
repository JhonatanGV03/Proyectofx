package com.uq.proyectofx.logic;

public class Jugador {
    private final String nombre;
    private int puntos;
    private int turno;
    private int[][]posicion;

    public Jugador(){
        this.nombre = "";
        this.puntos = 0;
        this.turno = 0;
        this.posicion = new int[8][8];
    }



    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
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
