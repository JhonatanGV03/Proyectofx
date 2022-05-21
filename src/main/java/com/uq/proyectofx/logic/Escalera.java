package com.uq.proyectofx.logic;

public class Escalera {
    private final int inicioE;
    private final int finE;

    public Escalera(int inicioE){
        this.inicioE = inicioE;
        this.finE = inicioE * (-1);
    }
}
