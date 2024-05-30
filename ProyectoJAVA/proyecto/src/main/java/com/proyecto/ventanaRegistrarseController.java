package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * Controlador de la ventana que nos permite registrarnos.
 */
public class ventanaRegistrarseController {

    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr = "root";
    private static String pass = "dbrootpass";

    @FXML
    private TextField idUser;
    @FXML
    private TextField idPass;
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idApellido;

    /**
     * Cambia a la primera ventana de la aplicación.
     * 
     * @throws IOException si ocurre algún error al cambiar la ventana
     */
    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    /**
     * Nos permite registrar a los usuarios en la biblioteca.
     * 
     * @return 0 si se registra correctamente
     * @throws IOException si ocurre algún error
     * @throws SQLException si ocurre algún error con la base de datos
     */
    @FXML
    public int registrar() throws IOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet recogeId = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(bibl, usr, pass);

            // Consulta SQL para insertar un nuevo usuario.
            String query = "INSERT INTO usuarios(email, apellido, nombre, password, idRol) VALUES(?, ?, ?, ?, 2)"; // 2 = id de rol usuario

            st = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            // Establece los valores para la consulta.
            st.setString(1, idUser.getText());
            st.setString(2, idApellido.getText());
            st.setString(3, idNombre.getText());
            st.setString(4, idPass.getText());

            // Ejecuta la consulta.
            st.executeUpdate();

            // Obtén el ID generado.
            recogeId = st.getGeneratedKeys();
            Usuario usuario = null;

            if (recogeId.next()) {
                int userId = recogeId.getInt(1);
                usuario = new Usuario(userId, idNombre.getText(), idUser.getText());
            }

            // Autenticar usuario y cambiar la ventana
            App.autenticarUsuario(usuario);
            App.setRoot("busResPresDev");

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se ha podido crear el usuario");
            alert.showAndWait();
        }
        return 0;
    }
}