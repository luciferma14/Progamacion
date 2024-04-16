package luciferma_jfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class ventanaInicioSesionController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }
}