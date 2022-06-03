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
    public void initialize() {
       // recorrerTabla(); //llena el arraylist y el grid al momento de iniciar la ventana.
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
    private int turno = 1;
    private Dado dado1 = new Dado();    //Se crea el objeto dado
    private Dado dado2 = new Dado();    //Se crea el objeto dado
    private Posiciones posiciones = new Posiciones();
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private Jugador jugador3 = new Jugador();
    private Jugador jugador4 = new Jugador();
    private int valorDado = 0;
    private int valorDado2 = 0;//Se usa después para el movimiento.


    //Metodos
    //Metodo para llenar el grid con los numeros de las casillas en orden al juego.
    void recorrerTabla(){
        int cont = 0;
        for(int fila=7; fila>=0; fila--) {
            if (fila%2==0){
                for (int col = 7; col >= 0; col--) {
                    Label label = new Label(posiciones.getPosiciones().get(cont).toString());
                    tablaGrid.add(label, col, fila);
                    cont++;
                }
            }else {

                for (int col=0; col<8; col++){
                    Label label = new Label(posiciones.getPosiciones().get(cont).toString());
                    tablaGrid.add(label, col, fila);
                    cont++;
                }
            }

        }
    }
    //Metodo para posicionar las fichas en el tablero
    void posicionarFichas(int posicion){
        int cont = 0;
        for(int fila=7; fila>=0; fila--) {
            if (fila%2==0){
                for (int col = 7; col >= 0; col--) {
                    if (cont == posicion){
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
                    cont++;
                }
            }else {
                for (int col=0; col<8; col++){
                    if (cont == posicion){
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
                    cont++;
                }
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
    public int determinarValorDado2(int posJugador, int valorDado){
        int dado;
        if (posJugador >= 57) {
            dado = 0;
        } else {
            dado = valorDado;
        }
        return dado;
    }

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
    public void posFinal() throws IOException {
        if (turno == 1) {
            valorDado2 = determinarValorDado2(jugador1.getPosicion(), valorDado2);
            setImg();
            System.out.print("J1: " + (jugador1.getPosicion()+1));
            MoverFicha ficha1 = new MoverFicha (jugador1, valorDado, valorDado2);
            ficha1.moverFicha();
            posicionarFichas(jugador1.getPosicion());
            System.out.println(" - "+(jugador1.getPosicion()+1));
            gano(jugador1.getPosicion(), jugador1.getNombre());
            turno ++;
        } else if (turno == 2) {
            valorDado2 = determinarValorDado2(jugador2.getPosicion(), valorDado2);
            setImg();
            System.out.print("J2: " + (jugador2.getPosicion()+1));
            MoverFicha ficha2 = new MoverFicha (jugador2, valorDado, valorDado2);
            ficha2.moverFicha();
            posicionarFichas(jugador2.getPosicion());
            System.out.println(" - "+(jugador2.getPosicion()+1));
            gano(jugador2.getPosicion(), jugador2.getNombre());
            turno ++;
        } else if (turno == 3) {
            valorDado2 = determinarValorDado2(jugador3.getPosicion(), valorDado2);
            setImg();
            System.out.print("J3: " + (jugador3.getPosicion()+1));
            MoverFicha ficha3 = new MoverFicha (jugador3, valorDado, valorDado2);
            ficha3.moverFicha();
            posicionarFichas(jugador3.getPosicion());
            System.out.println(" - "+(jugador3.getPosicion()+1));
            gano(jugador3.getPosicion(), jugador3.getNombre());
            turno ++;
        } else if (turno == 4) {
            valorDado2 = determinarValorDado2(jugador4.getPosicion(), valorDado2);
            setImg();
            System.out.print("J4: " + (jugador4.getPosicion()+1));
            MoverFicha ficha4 = new MoverFicha (jugador4, valorDado, valorDado2);
            ficha4.moverFicha();
            posicionarFichas(jugador4.getPosicion());
            System.out.println(" - "+(jugador4.getPosicion()+1));
            gano(jugador4.getPosicion(), jugador4.getNombre());
            turno = 1;
        }
    }


    //OnAction
    @FXML
    void lanzarDado(ActionEvent event) throws IOException {
        //Determinar dados
        valorDado = dado1.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado.
        valorDado2 = dado2.lanzar();//Se obtiene el valor del dado y se guarda en la variable valorDado2.
        posFinal();
        System.out.println((valorDado) + "  " + (valorDado2) + ": " + (valorDado + valorDado2)); //Se imprime el valor del dado en consola para verificar que funciona.

    }
    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);     //Si se presiona la tecla escape se cierra la ventana.
        }
    }
}
