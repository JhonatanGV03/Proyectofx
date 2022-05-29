package com.uq.proyectofx.controller;

import com.uq.proyectofx.logic.Dado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class JuegoControl {
    public JuegoControl() {
    }
    public void initialize() {
        llenarGrid();
    }

    //Ids
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
    private int valorDado = 0;
    private int valorDado2 = 0;//Se usa despues para el movimiento.


    //Metodos

    //Metodo para llenar el grid con los numeros de las casillas en orden al juego
    //Por ahora solo se usa para pruebas. luego se reemplaza por imagenes.
    void llenarGrid(){
        int cont = 1;
        for(int fila=7; fila>=0; fila--) {
            if (fila%2==0){
                for (int col = 7; col >= 0; col--) {
                    Label label = new Label(String.valueOf(cont));
                    tablaGrid.add(label, col, fila);

                    cont++;
                }
            }else {

                for (int col=0; col<8; col++){
                    Label label = new Label(String.valueOf(cont));
                    label.setAlignment(Pos.BOTTOM_RIGHT);
                    tablaGrid.add(new Label(String.valueOf(cont)), col, fila);
                    cont++;
                }
            }
        }
    }

    //Metodos para llenar los labels con los nombres de los jugadores
    public void setNomF1(String nomF1) {
        this.nomF1.setText(nomF1);
    }

    public void setNomF2(String nomF2) {
        this.nomF2.setText(nomF2);
    }

    public void setNomF3(String nomF3) {
        this.nomF3.setText(nomF3);
    }

    public void setNomF4(String nomF4) {
        this.nomF4.setText(nomF4);
    }

    //OnAction
    @FXML
    void lanzarDado(ActionEvent event) {
        //Determinar dados
        Dado dado = new Dado();    //Se crea el objeto dado
        valorDado = dado.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado.
        valorDado2 = dado.lanzar();  //Se obtiene el valor del dado y se guarda en la variable valorDado2.
        imgDado.setImage(dado.getImagen(valorDado));   //Se cambia la imagen del dado segun el valor obtenido.
        imgDado2.setImage(dado.getImagen(valorDado2));   //Se cambia la imagen del dado segun el valor obtenido.

        System.out.println(valorDado +"  "+valorDado2); //Se imprime el valor del dado en consola para verificar que funciona.
    }
    @FXML
    void salirJuego(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            System.exit(0);         //Si se presiona la tecla escape se cierra la ventana.
        }
    }
}
