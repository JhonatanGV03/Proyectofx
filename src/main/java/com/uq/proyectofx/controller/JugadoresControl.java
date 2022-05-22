package com.uq.proyectofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class JugadoresControl {
    @FXML
    private Button btnJugar;

    @FXML
    private TextField nom1;

    @FXML
    private TextField nom2;

    @FXML
    private TextField nom3;

    @FXML
    private TextField nom4;

    @FXML
    void jugar(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uq/proyectofx/juego.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JuegoControl juegoControl = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Serpientes y Escaleras");
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnJugar.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void salirVen(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

    @FXML
    void saveNombre1(ActionEvent event) {

    }

    @FXML
    void saveNombre2(ActionEvent event) {

    }

    @FXML
    void saveNombre3(ActionEvent event) {

    }

    @FXML
    void saveNombre4(ActionEvent event) {

    }
}
