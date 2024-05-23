package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
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
    public int registrar() throws IOException, SQLException {
        App.setRoot("busResPresDev");

        try {
            Connection con = DriverManager.getConnection(bibl, usr, pass);
            // Consulta SQL para insertar un nuevo usuario.
            String query = "INSERT INTO usuarios(email, apellido, nombre, password, idRol) VALUES(?, ?, ?, ?, 2)"; // 2 = id de rol usuario

            try (PreparedStatement st = con.prepareStatement(query)) {
                // Establece los valores para la consulta.
                st.setString(1, String.valueOf(idUser.getText()));
                st.setString(2, String.valueOf(idApellido.getText()));
                st.setString(3, String.valueOf(idNombre.getText()));
                st.setString(4, String.valueOf(idPass.getText()));

                // Ejecuta la consulta.
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
