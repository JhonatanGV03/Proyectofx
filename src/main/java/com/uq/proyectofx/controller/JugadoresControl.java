package com.uq.proyectofx.controller;

import com.uq.proyectofx.logic.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JugadoresControl {
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    Jugador jugador3 = new Jugador();
    Jugador jugador4 = new Jugador();

    //IDs
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

    //OnAction
    @FXML
    void saveNombre1(ActionEvent event) {
        jugador1.setNombre(nom1.getTypeSelector());
        nom2.requestFocus();
        System.out.println("J1: "+jugador1.getNombre());
    }
    @FXML
    void saveNombre2(ActionEvent event) {
        jugador2.setNombre(nom2.getText());
        nom3.requestFocus();

        System.out.println("J2: "+jugador2.getNombre());

    }
    @FXML
    void saveNombre3(ActionEvent event) {
        jugador3.setNombre(nom3.getText());
        nom4.requestFocus();

        System.out.println("J3: "+jugador3.getNombre());

    }
    @FXML
    void saveNombre4(ActionEvent event) {
        jugador4.setNombre(nom4.getText());
        btnJugar.requestFocus();

        System.out.println("J4: "+jugador4.getNombre());
    }
    @FXML
    void jugar(ActionEvent event) {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uq/proyectofx/juego.fxml"));
        Parent root;
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
        stage.getIcons().add(image);
        stage.show();

        //Enviar nombres a juegoControl
        juegoControl.setNomF1(jugador1.getNombre());
        juegoControl.setNomF2(jugador2.getNombre());
        juegoControl.setNomF3(jugador3.getNombre());
        juegoControl.setNomF4(jugador4.getNombre());

        Stage stage2 = (Stage) this.btnJugar.getScene().getWindow();
        stage2.close();
    }
    @FXML
    void salirVen(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }

}
