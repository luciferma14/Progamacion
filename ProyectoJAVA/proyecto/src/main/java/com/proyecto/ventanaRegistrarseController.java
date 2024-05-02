package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ventanaRegistrarseController {

	private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	

	@FXML
	private ComboBox idRol;
	@FXML
	private TextField idUser;
	@FXML
	private TextField idPass;
	@FXML
	private TextField idNombre;
	@FXML
	private TextField idApellido;
	

	@FXML
	public void initialize() {
		idRol.getItems().addAll("Usuario", "Administrador");
	}

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

	

	@FXML
	public int registrar(ActionEvent event) throws IOException, SQLException {

		App.setRoot("busResPresDev");

		try {
			Connection con = DriverManager.getConnection(bibl,usr,pass);
			
			try {
				Class.forName(driv);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			String query = "INSERT INTO usuarios(email, apellido, nombre, password, idRol) VALUES(?, ?, ?, ?, ?)";

			try (PreparedStatement st = con.prepareStatement(query)) {

				st.setString(1, String.valueOf(idUser.getText()));
				st.setString(2, String.valueOf(idApellido.getText()));
				st.setString(3, String.valueOf(idNombre.getText()));
				st.setString(4, String.valueOf(idPass.getText()));
				st.setString(5, String.valueOf(idRol.getPromptText()));
		
				st.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;	
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
}