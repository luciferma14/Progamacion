package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class login {
	
	@FXML
	private TextField idPass;
	@FXML
	private TextField idUser;

	public PreparedStatement ps;

	public ResultSet rs;
	

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";	

	// public String getUsuario() {
	// 	return idUser.getText();
	// }

	// public void setUsuario(String idUser) {
	// 	this.idUser = new TextField(idUser);
	// }

	// public String getContraseña() {
	// 	return idPass.getText();
	// }

	// public void setContraseña(String idPass) {
	// 	this.idPass = new TextField(idPass);
	// }

	public int ingresarUs() throws SQLException, IOException {  
		Connection con = DriverManager.getConnection(bibl,usr,pass);

		String query = "SELECT email, password FROM usuarios WHERE email = ? AND password = ?";

		try (PreparedStatement st = con.prepareStatement(query)) {

			st.setString(1, String.valueOf(idUser.getText()));
			st.setString(2, String.valueOf(idPass.getText()));

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}