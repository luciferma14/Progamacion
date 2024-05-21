package com.proyecto;
import java.io.IOException;
import javafx.fxml.FXML;

public class busResPresDevController {

    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }

    @FXML
    private void cambiaAReservar() throws IOException {
        App.setRoot("ventanaReservar");
    }

    @FXML
    private void cambiaAPrestar() throws IOException {
        App.setRoot("ventanaPrestar");
    }

    @FXML
    private void cambiaADevolver() throws IOException {
        App.setRoot("ventanaDevolver");
    }
    
    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }
}
