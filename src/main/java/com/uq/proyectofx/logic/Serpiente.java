package com.uq.proyectofx.logic;

public class Serpiente  {
    private final int posInicio;
    private final int posFinal;

    public Serpiente(int posInicio, int posFinal) {
        this.posInicio = posInicio;
        this.posFinal = posFinal;
    }

    public int getPosInicio() {
        return posInicio;
    }
    public int getPosFinal() {
        return posFinal;
    }
}
