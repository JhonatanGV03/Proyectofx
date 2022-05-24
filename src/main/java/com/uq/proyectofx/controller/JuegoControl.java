package com.uq.proyectofx.controller;

import com.uq.proyectofx.logic.Dado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class JuegoControl {
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
    private GridPane tablaGrid;

    //Variables
    private int valorDado = 0; //Se usa despues para el movimiento.

    //OnAction
    @FXML
    void lanzarDado(ActionEvent event) {
        Dado dado = new Dado();    //Se crea el objeto dado
        valorDado = dado.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado.
        imgDado.setImage(dado.getImagen(valorDado));   //Se cambia la imagen del dado segun el valor obtenido.

        System.out.println(valorDado); //Se imprime el valor del dado en consola para verificar que funciona.
    }


    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);         //Si se presiona la tecla escape se cierra la ventana.
        }
    }

}
