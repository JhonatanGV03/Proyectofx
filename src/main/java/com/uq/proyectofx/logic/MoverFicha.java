package com.uq.proyectofx.logic;

public class MoverFicha {
    //Variables
    private Jugador jugador;
    private int posInicial;
    private int posFinal;
    private int valorDado1;
    private int valorDado2;
    //Escaleras
    private Escalera escalera = new Escalera(7,38);
    private Escalera escalera2 = new Escalera(11,37);
    private Escalera escalera3 = new Escalera(31,46);
    private Escalera escalera4 = new Escalera(43,60);
    //Serpientes
    private Serpiente serpiente = new Serpiente(30, 2);
    private Serpiente serpiente2 = new Serpiente(40, 21);
    private Serpiente serpiente3 = new Serpiente(50, 4);
    private Serpiente serpiente4 = new Serpiente(59, 42);

    //Constructor
    public MoverFicha(Jugador jugador, int valorDado1, int valorDado2) {
        this.jugador = jugador;
        this.posInicial = jugador.getPosicion();
        this.valorDado1 = valorDado1;
        this.valorDado2 = valorDado2;
        this.posFinal = calcularPosFinal();
    }

    //Metodos
    //Calcula la posicion final del jugador de acuerdo a su posicion inicial
    public int calcularPosFinal (){

        if (posInicial < 57){
            if ((posInicial + valorDado1 + valorDado2) > 63){
                posFinal = posInicial + valorDado1;
            } else {
                posFinal = posInicial + valorDado1 + valorDado2;
            }

        } else {
            posFinal = posInicial + valorDado1;
            if (posFinal > 63){
                posFinal = posInicial;
            }

        }
        return posFinal;
    }

    //Determina si el jugador se encuentra una escalera o serpiente en la posFinal
    public int determinarPosFinal(){
        if (escalera.getPosInicio() == posFinal){
            posFinal = escalera.getPosFinal();
        } else if (escalera2.getPosInicio() == posFinal){
            posFinal = escalera2.getPosFinal();
        } else if (escalera3.getPosInicio() == posFinal){
            posFinal = escalera3.getPosFinal();
        } else if (escalera4.getPosInicio() == posFinal){
            posFinal = escalera4.getPosFinal();
        } else if (serpiente.getPosInicio() == posFinal){
            posFinal = serpiente.getPosFinal();
        } else if (serpiente2.getPosInicio() == posFinal){
            posFinal = serpiente2.getPosFinal();
        } else if (serpiente3.getPosInicio() == posFinal){
            posFinal = serpiente3.getPosFinal();
        } else if (serpiente4.getPosInicio() == posFinal){
            posFinal = serpiente4.getPosFinal();
        }
        return posFinal;
    }

    public void moverFicha(){
        jugador.setPosicion(determinarPosFinal());
    }

}
