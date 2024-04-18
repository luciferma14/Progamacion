package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class primeraVentanaController {

    @FXML
    private void cambiarAInicioSesion() throws IOException {
        App.setRoot("ventanaInicioSesion");
    }

    @FXML
    private void cambiarARegistrarse() throws IOException {
        App.setRoot("ventanaRegistrarse");
    }
}