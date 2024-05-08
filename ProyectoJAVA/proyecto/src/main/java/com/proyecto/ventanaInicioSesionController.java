package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ventanaInicioSesionController {

    @FXML
	private ComboBox idRol;
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
	public void initialize() {
		idRol.getItems().addAll("Usuario", "Administrador");
	}

    @FXML
    public void Ingresar(ActionEvent event) throws SQLException, IOException {

        String username = idUser.getText();
        String password = idPass.getText();

        try {
            Connection con = DriverManager.getConnection(bibl, usr, pass);

            String query = "SELECT email, password FROM usuarios WHERE email = ? AND password = ?";

            try (PreparedStatement st = con.prepareStatement(query)) {

                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                  
                    JOptionPane.showMessageDialog(null, "Ingreso exitoso");
                    
                    App.setRoot("busResPresDev");
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Ingreso Fallido");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
