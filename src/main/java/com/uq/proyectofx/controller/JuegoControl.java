package com.uq.proyectofx.controller;

import com.uq.proyectofx.logic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JuegoControl {
    public JuegoControl() {
    }

    //Ids
    @FXML
    private ImageView imgJ1;
    @FXML
    private ImageView imgJ2;
    @FXML
    private ImageView imgJ3;
    @FXML
    private ImageView imgJ4;
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
    private ImageView imgDado2;
    @FXML
    private GridPane tablaGrid;


    //Variables
    private int turno = 1;  //Turno del jugador
    private Dado dado1 = new Dado();    //Se crea el objeto dado
    private Dado dado2 = new Dado();    //Se crea el objeto dado
    private Jugador jugador1 = new Jugador(); //Se crea el objeto jugador1
    private Jugador jugador2 = new Jugador(); // " ... " jugador2
    private Jugador jugador3 = new Jugador(); // " ... " jugador3
    private Jugador jugador4 = new Jugador(); // " ... " jugador4
    private int valorDado = 0;  //Valor del dado
    private int valorDado2 = 0;//Se usa después para el movimiento.


    //Métodos
    //Método para posicionar las fichas en el tablero de juego
    void moverFichas(int posicion){
        int cont = 0;                                   //Contador para saber en qué posición está en el recorrido
        for(int fila=7; fila>=0; fila--) {              //Recorre las filas del tablero de abajo hacia arriba
            if (fila%2==0){                             //Valida si la fila es par
                for (int col = 7; col >= 0; col--) {    //Recorre las columnas del tablero de derecha a izquierda
                    posicionarFicha(cont, posicion, fila, col); //se posiciona la ficha en la posición respecto al tablero
                    cont++;                                 //Se aumenta el contador por cada iteración
                }
            }else {
                for (int col=0; col<8; col++){          //Recorre las columnas del tablero de izquierda a derecha
                    posicionarFicha(cont, posicion, fila, col);
                    cont++;
                }
            }
        }
    }
    //metodo para posicionar la ficha en la posicion respecto al tablero y respecto al turno
    public void posicionarFicha(int contador, int posicion, int fila, int col){
        if (contador == posicion){
            if (turno == 1) {
                GridPane.setRowIndex(imgJ1, fila);
                GridPane.setColumnIndex(imgJ1, col);
            } else if (turno == 2) {
                GridPane.setRowIndex(imgJ2, fila);
                GridPane.setColumnIndex(imgJ2, col);
            } else if (turno == 3) {
                GridPane.setRowIndex(imgJ3, fila);
                GridPane.setColumnIndex(imgJ3, col);
            } else if (turno == 4) {
                GridPane.setRowIndex(imgJ4, fila);
                GridPane.setColumnIndex(imgJ4, col);
            }
        }
    }

    //Metodos para llenar los labels con los nombres de los jugadores
    public void llenarNombres(String nom1, String nom2, String nom3, String nom4){
        nomF1.setText(nom1);
        nomF2.setText(nom2);
        nomF3.setText(nom3);
        nomF4.setText(nom4);
        jugador1.setNombre(nom1);
        jugador2.setNombre(nom2);
        jugador3.setNombre(nom3);
        jugador4.setNombre(nom4);
    }

    //Metodo para determinar el valor del dado 2 segun posicion del jugador
    public int determinarValorDado2(int posJugador, int valorDado2, int valorDado){
        int dado;
        if (posJugador >= 57) {
            dado = 0;
        } else {
            dado = valorDado2;
            if ((posJugador+valorDado+valorDado2)>63){
                System.out.println("La suma de los dados y la posicion del jugador es mayor a 64");
                System.out.println("Solo corre "+valorDado+" casillas");
            }
        }
        return dado;
    }
    //Metodo para determinar el ganador del juego y abrir la ventana de ganador
    public void gano (int posJugador, String nombre) throws IOException {
        if (posJugador == 63) {
            System.out.println("Ganó " + nombre.toUpperCase());
            //Abre la ventana de ganador y envia el nombre del jugador
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/proyectofx/imgs/pngwing.com.png")));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uq/proyectofx/ganador.fxml"));
            Parent root = fxmlLoader.load();
            GanadorControl ganadorControl = fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Serpientes y Escaleras - ¡¡FELICIDADES!!");
            stage.setResizable(false);
            stage.getIcons().add(image);

            ganadorControl.setNomGanador(nombre.toUpperCase());
            stage.show();
            Stage stage2 = (Stage) btnDado.getScene().getWindow();
            stage2.close();
        }
    }
    public void setImg(){
        imgDado.setImage(dado1.getImagen(valorDado));//Se cambia la imagen del dado segun el valor obtenido.
        imgDado2.setImage(dado2.getImagen(valorDado2));//Se cambia la imagen del dado segun el valor obtenido.
    }

    //Metodo para determinar posFinal del jugador en tablero
    public void mover() throws IOException {
        if (turno == 1) {
            valorDado2 = determinarValorDado2(jugador1.getPosicion(), valorDado2, valorDado);  //Se determina el valor del dado2 del jugador 1
            setImg();                                          //Se cambia la imagen del dado segun el valor obtenido.
            System.out.print("J1: " + (jugador1.getPosicion()+1));
            MoverFicha ficha1 = new MoverFicha (jugador1, valorDado, valorDado2); //Se crea un objeto de la clase MoverFicha
            ficha1.moverFicha();                        //Se cambia la posicion del jugador con este metodo
            moverFichas(jugador1.getPosicion());      //Se posiciona la ficha en el tablero
            System.out.println(" - "+(jugador1.getPosicion()+1));   //Se imprime la posicion del jugador
            gano(jugador1.getPosicion(), jugador1.getNombre());     //Se determina si el jugador gano
            turno ++;
        } else if (turno == 2) {
            valorDado2 = determinarValorDado2(jugador2.getPosicion(), valorDado2, valorDado);
            setImg();
            System.out.print("J2: " + (jugador2.getPosicion()+1));
            MoverFicha ficha2 = new MoverFicha (jugador2, valorDado, valorDado2);
            ficha2.moverFicha();
            moverFichas(jugador2.getPosicion());
            System.out.println(" - "+(jugador2.getPosicion()+1));
            gano(jugador2.getPosicion(), jugador2.getNombre());
            turno ++;
        } else if (turno == 3) {
            valorDado2 = determinarValorDado2(jugador3.getPosicion(), valorDado2, valorDado);
            setImg();
            System.out.print("J3: " + (jugador3.getPosicion()+1));
            MoverFicha ficha3 = new MoverFicha (jugador3, valorDado, valorDado2);
            ficha3.moverFicha();
            moverFichas(jugador3.getPosicion());
            System.out.println(" - "+(jugador3.getPosicion()+1));
            gano(jugador3.getPosicion(), jugador3.getNombre());
            turno ++;
        } else if (turno == 4) {
            valorDado2 = determinarValorDado2(jugador4.getPosicion(), valorDado2, valorDado);
            setImg();
            System.out.print("J4: " + (jugador4.getPosicion()+1));
            MoverFicha ficha4 = new MoverFicha (jugador4, valorDado, valorDado2);
            ficha4.moverFicha();
            moverFichas(jugador4.getPosicion());
            System.out.println(" - "+(jugador4.getPosicion()+1));
            gano(jugador4.getPosicion(), jugador4.getNombre());
            turno = 1;
        }
    }


    //OnAction
    // por cada vez que se presione el boton de dado, se lanzan los dados y se ejecuta el método mover
    @FXML
    void lanzarDado(ActionEvent event) throws IOException {
        //Determinar dados
        valorDado = dado1.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado.
        valorDado2 = dado2.lanzar();//Se obtiene el valor del dado y se guarda en la variable valorDado2.
        mover();
        System.out.println((valorDado) + "  " + (valorDado2) + ": " + (valorDado + valorDado2)); //Se imprime el valor del dado en consola para verificar que funciona.

    }

    //OnKeyPressed para salir cuando se presiona la tecla ESC.
    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);
        }
    }
}
