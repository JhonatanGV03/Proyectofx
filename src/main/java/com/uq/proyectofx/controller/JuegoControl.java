package com.uq.proyectofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class JuegoControl {

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
    private SubScene sceneDado;

    @FXML
    private GridPane tablaGrid;

    @FXML
    void lanzarDado(ActionEvent event) {

    }

    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

}
