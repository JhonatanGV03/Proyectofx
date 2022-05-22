package com.uq.proyectofx;

import com.uq.proyectofx.logic.Dado;
import com.uq.proyectofx.logic.Tablero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       // Image image = new Image("/com/uq/proyectofx/pngwing.com.png");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Serpientes y Escaleras");
        stage.setScene(scene);
        //stage.getIcons().add(image);
        stage.show();

        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();

        //Pruebas en consola
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