package com.uq.proyectofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Pantalla de inicio
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Serpientes y Escaleras");
        stage.setScene(scene);
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        /*
        //Pantalla de juego para pruebas
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
        //Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Serpientes y Escaleras");
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.show();

         */

    }

    public static void main(String[] args) {
        launch();
    }
}