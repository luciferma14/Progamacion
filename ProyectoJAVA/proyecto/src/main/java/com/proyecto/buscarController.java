package com.proyecto;
import java.io.IOException;
import javafx.fxml.FXML;

public class buscarController {

    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }
    
    @FXML
    private void cambiarAFindLibros() throws IOException {
        App.setRoot("encontrarLibros");
    }
}