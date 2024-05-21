package com.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Usuario usuarioAutenticado;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primeraVentana"));
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        Parent root = loadFXML(fxml);
        scene.setRoot(root);
        if (fxml.equals("primeraVentana")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        }
        if (fxml.equals("busResPresDev")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        if (fxml.equals("ventanaBuscar")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        if (fxml.equals("ventanaReservar")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        if (fxml.equals("ventanaPrestar")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        if (fxml.equals("ventanaDevolver")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        }
        if (fxml.equals("ventanaRegistrarse")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        if (fxml.equals("ventanaInicioSesion")){
            Stage stage = (Stage) scene.getWindow();
            stage.setWidth(1080);
            stage.setHeight(600);
        } 
        
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private static Libro li = null;

    public static Libro getLibro() {
        return li;
    }

    public static void autenticarUsuario(Usuario usuario) {
        usuarioAutenticado = usuario;
    }

    // Este método retorna el usuario actualmente autenticado
    public static Usuario getUsuario() {
        return usuarioAutenticado;
    }

}