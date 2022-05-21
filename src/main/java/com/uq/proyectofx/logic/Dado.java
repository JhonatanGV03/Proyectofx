package com.uq.proyectofx.logic;

public class Dado {
    private int valor;
    public Dado(){

    }

    public int lanzar(){
        valor = (int) (Math.random()*6+1);
        return valor;
    }
}
