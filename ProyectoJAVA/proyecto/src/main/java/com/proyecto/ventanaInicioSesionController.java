package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ventanaInicioSesionController {

	@FXML
	private TextField idUser;
	@FXML
	private TextField idPass;

    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	


    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    public void Ingresar(ActionEvent event) throws SQLException, IOException {

        String username = idUser.getText();
        String password = idPass.getText();

        try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
            String query = "SELECT idUsuario, nombre, email FROM usuarios WHERE email = ? AND password = ?";
            
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();

                if (rs.next()) {

                    Integer idUsuario = rs.getInt("idUsuario");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");

                    Usuario usuario = new Usuario(idUsuario, nombre, email);

                    App.autenticarUsuario(usuario);

                    App.setRoot("busResPresDev");

                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("No se encontraron usuarios");
                    alert.setHeaderText(null);
                    alert.setContentText("No tenemos ninguna cuenta con esas características.\" + '\\n" + "' + \"Inténtelo otra vez.");
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
