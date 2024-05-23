package com.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación que extiende de javafx.application.Application.
 */
public class App extends Application {

    private static Scene scene; // Escena actual
    private static Usuario usuarioAutenticado; // Usuario autenticado en la aplicación

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primeraVentana")); // Carga la primera ventana al iniciar la aplicación
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método estático para cambiar la escena actual.
     * 
     * @param fxml nombre del archivo FXML de la nueva escena
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    static void setRoot(String fxml) throws IOException {
        Parent root = loadFXML(fxml); // Carga el archivo FXML
        scene.setRoot(root); // Establece la nueva escena
        // Ajusta el tamaño de la ventana según la escena
        Stage stage = (Stage) scene.getWindow();
        stage.setWidth(1080);
        stage.setHeight(600);
    }

    /**
     * Carga un archivo FXML y retorna su raíz.
     * 
     * @param fxml nombre del archivo FXML
     * @return la raíz del archivo FXML
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load(); // Carga el archivo FXML y retorna su raíz
    }

    public static void main(String[] args) {
        launch();
    }

    // Métodos para obtener y autenticar usuarios
    private static Libro li = null;

    public static Libro getLibro() {
        return li;
    }

    public static void autenticarUsuario(Usuario usuario) {
        usuarioAutenticado = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioAutenticado;
    }
}