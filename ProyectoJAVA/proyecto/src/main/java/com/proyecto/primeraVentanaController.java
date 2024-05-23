package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Controlador de la primera ventana.
 */
public class primeraVentanaController {

    /**
     * Cambia a la ventana de iniciar sesión.
     * 
     * @throws IOException si ocurre un error al cambiar de ventana
     */
    @FXML
    private void cambiarAInicioSesion() throws IOException {
        App.setRoot("ventanaInicioSesion");
    }

    /**
     * Cambia a la ventana de registrarse.
     * 
     * @throws IOException si ocurre un error al cambiar de ventana
     */
    @FXML
    private void cambiarARegistrarse() throws IOException {
        App.setRoot("ventanaRegistrarse");
    }
}