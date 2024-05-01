package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ventanaRegistrarseController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
	private TextField idUser;
	@FXML
	private TextField idPass;
	@FXML
	private TextField idNombre;
	@FXML
	private TextField idApellido;

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql:33006/biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	


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
				
			String query = "INSERT INTO usuarios(email, apellido, nombre, password, idRol) VALUES(?, ?, ?, ?)";

			try (PreparedStatement st = con.prepareStatement(query)) {

				st.setString(1, String.valueOf(idUser));
				st.setString(2, String.valueOf(idApellido));
				st.setString(3, String.valueOf(idNombre));
				st.setString(4, String.valueOf(idPass));
		
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