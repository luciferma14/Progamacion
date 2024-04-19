package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class botonRegistrarController {

    @FXML
    private void cambiaABusResPresDev() throws IOException {
        App.setRoot("busResPresDev");
    }
}