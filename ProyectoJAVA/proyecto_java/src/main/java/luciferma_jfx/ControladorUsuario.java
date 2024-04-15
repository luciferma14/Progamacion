import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class ControladorUsuario {

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoPassword;

    @FXML
    private Button idInciarSesion;

    @FXML
    private Button idRegistrar;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String email = campoEmail.getText();
        String password = campoPassword.getText();

        // Validar credenciales (simulación)
        if (email.equals(email) && password.equals(password)) {
            // Iniciar sesión exitosa
            mostrarAlerta("¡Inicio de sesión exitoso!");
            // Cerrar la ventana actual (opcional)
            // stage.close();
        } else {
            // Credenciales incorrectas
            mostrarAlerta("Credenciales incorrectas. Inténtalo de nuevo.");
        }
    }

    @FXML
    private void registrarse(ActionEvent event) {
        // Implementar la lógica para registrar un nuevo usuario
        // (mostrar un formulario, guardar datos en la base de datos, etc.)
        mostrarAlerta("¡Función de registro no disponible aún!");
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuarios");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
