package com.uq.proyectofx.logic;

import java.util.ArrayList;

public class Posiciones {
    private ArrayList<Integer> posiciones = new ArrayList<Integer>();


    public Posiciones() {
        llenarPosiciones();

    }
    public void llenarPosiciones (){
        posiciones.ensureCapacity(64);
        for (int i = 0; i < 64; i++){
            posiciones.add(i+1);
        }
    }
    public ArrayList<Integer> getPosiciones() {
        return posiciones;
    }
}
