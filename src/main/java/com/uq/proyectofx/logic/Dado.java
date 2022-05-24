package com.uq.proyectofx.logic;

import javafx.scene.image.Image;

import java.util.Objects;

public class Dado {
    private int valor;
    public Dado(){

    }
    public int lanzar(){
        valor = (int) (Math.random()*6+1);  //Se obtiene un numero aleatorio entre 1 y 6.
        return valor;
    }
    public Image getImagen(int valor){      //Se obtiene la imagen del dado segun el valor obtenido.
        Image uno = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado1.png")));
        Image dos = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado2.png")));
        Image tres = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado3.png")));
        Image cuatro = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado4.png")));
        Image cinco = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado5.png")));
        Image seis = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/Dado6.png")));

        Image dado = uno;
        switch (valor) {
            case 1:
                break;
            case 2:
                dado = dos;
                break;
            case 3:
                dado = tres;
                break;
            case 4:
                dado = cuatro;
                break;
            case 5:
                dado = cinco;
                break;
            case 6:
                dado = seis;
                break;
            default:
                dado = null;
                break;
        }
        return dado;
    }

}
