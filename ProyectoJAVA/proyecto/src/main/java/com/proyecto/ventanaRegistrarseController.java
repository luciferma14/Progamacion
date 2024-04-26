package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.Action;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ventanaRegistrarseController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
	private TextField idUser;
	@FXML
	private PasswordField idPass;
	@FXML
	private TextField idNombre;
	@FXML
	private TextField idApellido;

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	


	@FXML
	public int registrar(ActionEvent event) throws IOException, SQLException {

        App.setRoot("busResPresDev");        

        //Ferrandis
        //luciferma14@gmail.com
        //hola
        //Lucia

		try {
            Connection con = DriverManager.getConnection(bibl,usr,pass);
            try {
				Class.forName(driv);
			} catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
			}
			String query = "INSERT INTO usuarios(email, apellido, nombre, password) VALUES(?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);

            User user = new User();

            ResultSet rs = st.executeQuery();

			st.setString(1, user.getUser());
			st.setString(2, user.getApellido());
			st.setString(3, user.getNombre());
			st.setString(4, user.getPass());
			st.executeUpdate();
			con.commit();
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
            System.out.println(e.getMessage());

		}
        return 0;
    }
}