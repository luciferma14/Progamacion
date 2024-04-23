package com.proyecto;
import java.io.IOException;
import javafx.fxml.FXML;

public class busResPresDevController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }
    
}
