package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class ventanaInicioSesionController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    private void cambiaABusResPresDev() throws IOException {
        App.setRoot("busResPresDev");
    }
}