package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class ventanaRegistrarseController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }
}