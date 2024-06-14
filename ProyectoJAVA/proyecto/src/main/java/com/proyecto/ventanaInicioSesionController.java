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
 * Controlador de la ventana que nos permite iniciar sesión.
 */
public class ventanaInicioSesionController {

	@FXML
	private TextField idUser;
	@FXML
	private TextField idPass;

    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	


    /**
     * Cambia a la primera ventana de la aplicación.
     * 
     * @throws IOException por si ocurre algún error al cambiar la ventana
     */
    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    /**
     * Nos permite iniciar sesión mediante la base de datos.
     * 
     * @throws SQLException por si ocurre algún error con la base de datos
     * @throws IOException por si ocurre un error
     */
    @FXML
    public void Ingresar() throws SQLException, IOException {

        String username = idUser.getText();
        String password = idPass.getText();

        try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
            String query = "SELECT idUsuario, nombre, email FROM usuarios WHERE email = ? AND password = ?";
            
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();

                // Procesa los resultados.
                if (rs.next()) {
                    Integer idUsuario = rs.getInt("idUsuario");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");

                    Usuario usuario = new Usuario(idUsuario, nombre, email);

                    App.autenticarUsuario(usuario);

                    App.setRoot("busResPresDev");

                } else {
                    // Muestra una alerta si no se ha encontrado el usuario.
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("No se encontraron usuarios");
                    alert.setHeaderText(null);
                    alert.setContentText("No tenemos ninguna cuenta con esas características. Inténtelo otra vez.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}