package com.uq.proyectofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InicioControl {

    //IDs
    @FXML
    private Button btnJugador;
    @FXML
    private Button btnSalir;

    //OnAction
    @FXML
    void jugadores(ActionEvent event) throws IOException {
        //Pantalla de inicio
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uq/proyectofx/jugadores.fxml"));
        Parent root = fxmlLoader.load();
        JugadoresControl jugadoresControl = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Serpientes y Escaleras");
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.show();

        Stage stage2 = (Stage) this.btnJugador.getScene().getWindow();
        stage2.close();
    }
    @FXML
    void salir(ActionEvent event) {
        Stage stage2 = (Stage) this.btnSalir.getScene().getWindow();
        stage2.close();
    }
    @FXML
    void teclaSalir(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }

    }
}
