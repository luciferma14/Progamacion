package luciferma_jfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class primeraVentanaController {

    @FXML
    private void cambiarAInicioSesion() throws IOException {
        App.setRoot("ventanaInicioSesion");
    }
}
