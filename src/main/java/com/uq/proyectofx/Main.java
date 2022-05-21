package com.uq.proyectofx;

import com.uq.proyectofx.logic.Dado;
import com.uq.proyectofx.logic.Tablero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Serpientes y Escaleras");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        //Prueba de tableros
        Tablero tablero = new Tablero();
        String s = tablero.toString();
        System.out.println(s);
        String s2 = tablero.toString2();
        System.out.println(s2);

        //Prueba de dado
        Dado dado = new Dado();
        for(int i=0; i<10; i++){
            System.out.println(dado.lanzar());
        }
    }
}