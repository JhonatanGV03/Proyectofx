package com.uq.proyectofx.controller;

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
    private String nombre1 = "";
    private String nombre2 = "";
    private String nombre3 = "";
    private String nombre4 = "";

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
        nombre1 = nom1.getText();
        nom2.requestFocus();
        System.out.println("J1: "+nombre1);
    }
    @FXML
    void saveNombre2(ActionEvent event) {
        nombre2 = nom2.getText();
        nom3.requestFocus();

        System.out.println("J2: "+nombre2);

    }
    @FXML
    void saveNombre3(ActionEvent event) {
       nombre3 = nom3.getText();
        nom4.requestFocus();

        System.out.println("J3: "+nombre3);

    }
    @FXML
    void saveNombre4(ActionEvent event) {
        nombre4 = nom4.getText();
        btnJugar.requestFocus();

        System.out.println("J4: "+nombre4);
    }
    @FXML
    void jugar(ActionEvent event) throws IOException {
        //Se carga la ventana de juego.
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uq/proyectofx/juego.fxml"));
        Parent root;
        root = fxmlLoader.load();
        JuegoControl juegoControl = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Serpientes y Escaleras");
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.show();

        //Enviar nombres a juegoControl
        juegoControl.llenarNombres(nombre1, nombre2, nombre3, nombre4);

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
