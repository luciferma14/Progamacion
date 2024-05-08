package com.proyecto;

import java.io.IOException;

import javafx.fxml.FXML;

public class encontrarLibrosController {

    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }
    
}
