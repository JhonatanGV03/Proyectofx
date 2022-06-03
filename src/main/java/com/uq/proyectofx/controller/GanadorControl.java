package com.uq.proyectofx.controller;

import com.uq.proyectofx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GanadorControl {

    //IDs
    @FXML
    private Button btnJugar;
    @FXML
    private Button btnSalir;
    @FXML
    private Text txtField;

    //Variables

    //Metodos
    public void setNomGanador(String nomGanador){
        txtField.setText("¡¡ FELICIDADES "+nomGanador+" GANASTE !!");
    }


    //OnAction
    @FXML
    void jugar(ActionEvent event) throws IOException {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage stage = new Stage();
        stage.setTitle("Serpientes y Escaleras");
        stage.setScene(scene);
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    void salir() {
        System.exit(0);
    }
    @FXML
    void teclaSalir(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            salir();
        }
    }

}


