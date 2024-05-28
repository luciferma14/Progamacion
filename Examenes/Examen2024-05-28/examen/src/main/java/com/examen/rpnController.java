package com.examen;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class rpnController{

    /**
     * Filas números.
     */
    @FXML
    private Label numeros;
    @FXML
    private Label fila1;
    @FXML
    private Label fila2;
    @FXML
    private Label fila3;
    @FXML
    private Label fila4;
    @FXML
    private Label fila5;
    @FXML
    private Label fila6;
    @FXML
    private Label fila7;
    @FXML
    private Label fila8;
    @FXML
    private Label fila9;

    /**
     * Botones calculadora.
     */
    @FXML
    private Button cero;
    @FXML
    private Button uno;
    @FXML
    private Button dos;
    @FXML
    private Button tres;
    @FXML
    private Button cuatro;
    @FXML
    private Button cinco;
    @FXML
    private Button seis;
    @FXML
    private Button siete;
    @FXML
    private Button ocho;
    @FXML
    private Button nueve;
    @FXML
    private Button enter;
    @FXML
    private Button suma;
    @FXML
    private Button resta;
    @FXML
    private Button multiplicar;
    @FXML
    private Button dividir;


    @FXML
    private void añadirCero(){
        numeros.setText(numeros.getText() + 0);
        
    }
    @FXML
    private void añadirUno(){
        numeros.setText(numeros.getText() + 1);
    }
    @FXML
    private void añadirDos(){
        numeros.setText(numeros.getText() + 2);
    }
    @FXML
    private void añadirTres(){
        numeros.setText(numeros.getText() + 3);
    }
    @FXML
    private void añadirCuatro(){
        numeros.setText(numeros.getText() + 4);
    }
    @FXML
    private void añadirCinco(){
        numeros.setText(numeros.getText() + 5);
    }
    @FXML
    private void añadirSeis(){
        numeros.setText(numeros.getText() + 6);
    }
    @FXML
    private void añadirSiete(){
        numeros.setText(numeros.getText() + 7);
    }
    @FXML
    private void añadirOcho(){
        numeros.setText(numeros.getText() + 8);
    }
    @FXML
    private void añadirNueve(){
        numeros.setText(numeros.getText() + 9);
    }
    @FXML
    private void añadirPunto(){
        numeros.setText(numeros.getText() + ".");
    }
    @FXML
    private void sum(){
        sumar();
    }
    @FXML
    private void res(){
        restar();
    }
    @FXML
    private void div(){
        divide();
    }
    @FXML
    private void mult(){
        multiplicar();
    }


    @FXML
    private void enter(){ 
        String texto = numeros.getText();
        String f1 = fila1.getText();
        if(texto.isEmpty()){
            numeros.setText("0");
            }else{
                double resultado = Double.parseDouble(texto);
                numeros.setText(String.valueOf(resultado));
            }if (!f1.isEmpty()){
                fila2.setText(f1);
            }
        fila1.setText(numeros.getText());
        numeros.setText("");
    }

    public void sumar(){
        String f1 = fila1.getText();
        String f2 = fila2.getText();
        double num1 = Double.parseDouble(f1);
        double num2 = Double.parseDouble(f2);
        double resultado = num2 + num1;
        fila1.setText(String.valueOf(resultado));
        fila2.setText("0.0");
        numeros.setText("");
    }

    public void restar(){
        String f1 = fila1.getText();
        String f2 = fila2.getText();
        double num1 = Double.parseDouble(f1);
        double num2 = Double.parseDouble(f2);
        double resultado = num2 - num1;
        fila1.setText(String.valueOf(resultado));
        fila2.setText("0.0");
        numeros.setText("");
    }

    public void divide(){
        String f1 = fila1.getText();
        String f2 = fila2.getText();
        double num1 = Double.parseDouble(f1);
        double num2 = Double.parseDouble(f2);
        double resultado = num2 / num1;
        fila1.setText(String.valueOf(resultado));
        fila2.setText("0.0");
        numeros.setText("");
        if(num1 == 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se puede dividir entre 0");
            alert.showAndWait();
        }
    }

    public void multiplicar(){
        String f1 = fila1.getText();
        String f2 = fila2.getText();
        double num1 = Double.parseDouble(f1);
        double num2 = Double.parseDouble(f2);
        double resultado = num2 * num1;
        fila1.setText(String.valueOf(resultado));
        fila2.setText("0.0");
        numeros.setText("");
        if(num1 == 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se puede multiplicar por 0");
            alert.showAndWait();
        }
    }
    

}