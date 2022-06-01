package com.uq.proyectofx.controller;

import com.uq.proyectofx.logic.Dado;
import com.uq.proyectofx.logic.Jugador;
import com.uq.proyectofx.logic.MoverFicha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Objects;

public class JuegoControl {
    public JuegoControl() {
    }
    public void initialize() {
        llenarGrid(); //llena el arraylist y el grid al momento de iniciar la ventana.
        imgDado.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/default2.png"))));
        imgDado2.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/default2.png"))));

    }

    //Ids
    @FXML
    private Button btnDado;
    @FXML
    private Label nomF1;
    @FXML
    private Label nomF2;
    @FXML
    private Label nomF3;
    @FXML
    private Label nomF4;
    @FXML
    private ImageView imgDado;
    @FXML
    private ImageView imgDado2;
    @FXML
    private GridPane tablaGrid;


    //Variables
    private int turno = 1;
    Dado dado1 = new Dado();    //Se crea el objeto dado
    Dado dado2 = new Dado();    //Se crea el objeto dado
    private ArrayList<String> numeros = new ArrayList<>();
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private Jugador jugador3 = new Jugador();
    private Jugador jugador4 = new Jugador();
    private int valorDado = 0;
    private int valorDado2 = 0;//Se usa después para el movimiento.


    //Metodos

    //Metodo para llenar el grid con los numeros de las casillas en orden al juego
    //Por ahora solo se usa para pruebas. luego se reemplaza por fichas.
    void llenarGrid(){
        int cont = 1;
        for(int fila=7; fila>=0; fila--) {
            if (fila%2==0){
                for (int col = 7; col >= 0; col--) {
                    numeros.add(String.valueOf(cont));
                    Label label = new Label(numeros.get(cont-1));
                    tablaGrid.add(label, col, fila);
                    System.out.println(numeros.get(cont-1));

                    cont++;
                }
            }else {

                for (int col=0; col<8; col++){
                    numeros.add(String.valueOf(cont));
                    Label label = new Label(numeros.get(cont-1));
                    tablaGrid.add(label, col, fila);
                    System.out.println(numeros.get(cont-1));
                    cont++;
                }
            }

        }
    }

    //Metodos para llenar los labels con los nombres de los jugadores
    public void llenarNombres(String nom1, String nom2, String nom3, String nom4){
        nomF1.setText(nom1);
        nomF2.setText(nom2);
        nomF3.setText(nom3);
        nomF4.setText(nom4);
        jugador1.setNombre(nom1);
        jugador2.setNombre(nom2);
        jugador3.setNombre(nom3);
        jugador4.setNombre(nom4);
    }

    //Metodo para determinar el valor del dado 2 segun posicion del jugador
    public int determinarValorDado2(int posJugador, int valorDado){
        int dado;
        if (posJugador > 57) {
            dado = 0;
        } else {
            dado = valorDado;
        }
        return dado;
    }

    //OnAction
    @FXML
    void lanzarDado(ActionEvent event) {
        //Determinar dados
        valorDado = dado1.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado.
        valorDado2 = dado2.lanzar();//Se obtiene el valor del dado y se guarda en la variable valorDado2.
        if (turno == 1){
            valorDado2 = determinarValorDado2(jugador1.getPosicion(), valorDado2);
            System.out.print("J1: " + (jugador1.getPosicion()+1));
            MoverFicha ficha1 = new MoverFicha (jugador1, valorDado, valorDado2);
            ficha1.moverFicha();
            System.out.println(" - "+(jugador1.getPosicion()+1));
            turno ++;
        } else if (turno == 2) {
            valorDado2 = determinarValorDado2(jugador2.getPosicion(), valorDado2);
            System.out.print("J2: " + (jugador2.getPosicion()+1));
            MoverFicha ficha2 = new MoverFicha (jugador2, valorDado, valorDado2);
            ficha2.moverFicha();
            System.out.println(" - "+(jugador2.getPosicion()+1));
            turno ++;
        } else if (turno == 3) {
            valorDado2 = determinarValorDado2(jugador3.getPosicion(), valorDado2);
            System.out.print("J3: " + (jugador3.getPosicion()+1));
            MoverFicha ficha3 = new MoverFicha (jugador3, valorDado, valorDado2);
            ficha3.moverFicha();
            System.out.println(" - "+(jugador3.getPosicion()+1));
            turno ++;
        } else if (turno == 4) {
            valorDado2 = determinarValorDado2(jugador4.getPosicion(), valorDado2);
            System.out.print("J4: " + (jugador4.getPosicion()+1));
            MoverFicha ficha4 = new MoverFicha (jugador4, valorDado, valorDado2);
            ficha4.moverFicha();
            System.out.println(" - "+(jugador4.getPosicion()+1));
            turno = 1;
        }
        imgDado.setImage(dado1.getImagen(valorDado));//Se cambia la imagen del dado segun el valor obtenido.
        imgDado2.setImage(dado2.getImagen(valorDado2));//Se cambia la imagen del dado segun el valor obtenido.

        System.out.println((valorDado)+"  "+(valorDado2)+ ": "+(valorDado+valorDado2)); //Se imprime el valor del dado en consola para verificar que funciona.
    }
    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);     //Si se presiona la tecla escape se cierra la ventana.
        }
    }
}
