package com.uq.proyectofx.logic;

public class Tablero {

    private final int[][] tablero = new int [8][8];
    private final int[][] tablero2 = new int [8][8];


    public Tablero() {
        llenarTablero();
    }

    public void llenarTablero(){
        int cont = 1;
        for(int fila=7; fila>=0; fila--) {
            if (fila%2==0){
                for (int col = 7; col >= 0; col--) {
                    tablero[fila][col] = 0; //cont;
                    tablero2[fila][col] = cont;
                    cont++;
                }
            }else {

                for (int col=0; col<8; col++){
                    tablero[fila][col]= 0; //cont;
                    tablero2[fila][col] = cont;
                    cont++;
                }
            }
        }
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int[][] getTablero2() {
        return tablero2;
    }

    @Override
    public String toString() {
        String resultado= "";
        for(int i =0; i< tablero.length; i++){
            String linea= "";
            for(int j=0; j< tablero[i].length; j++){
                linea += tablero[i][j] + " ";
            }
            resultado += linea + "\n";

        }
        return resultado;
    }
    public String toString2() {
        String resultado= "";
        for(int i =0; i< tablero2.length; i++){
            String linea= "";
            for(int j=0; j< tablero2[i].length; j++){
                linea += tablero2[i][j] + " ";
            }
            resultado += linea + "\n";

        }
        return resultado;
    }
}
