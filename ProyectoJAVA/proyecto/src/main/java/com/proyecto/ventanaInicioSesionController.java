package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ventanaInicioSesionController {

	@FXML
	private TextField idUser;
	@FXML
	private TextField idPass;

    public PreparedStatement ps;

	public ResultSet rs;

    private static String driv = "com.mysql.jdbc.Driver";
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
                    JOptionPane.showMessageDialog(null, "No tenemos ninguna cuenta con esas características." +'\n' + "Inténtelo otra vez");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
