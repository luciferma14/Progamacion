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
	private ComboBox idRol;
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


    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    private void cambiaABusResPresDev() throws IOException {
        
    }


    @FXML
	public void initialize() {
		idRol.getItems().addAll("Usuario", "Administrador");
	}

	public void IngresoApp(String idUser, String idPass) {
		this.idUser = new TextField(idUser);
		this.idPass = new TextField(idPass);
	}

	public void IngresoApp() {
		throw new UnsupportedOperationException("Error");
	}

	public String getUsuario() {
		return idUser.getText();
	}

	public void setUsuario(String idUser) {
		this.idUser = new TextField(idUser);
	}

	public String getContraseña() {
		return idPass.getText();
	}

	public void setContraseña(String idPass) {
		this.idPass = new TextField(idPass);
	}

	public int ingresarUs() throws SQLException, IOException{  
		Connection con = DriverManager.getConnection(bibl,usr,pass);

		try{
			String query = "SELECT email, password, idRol FROM usuarios WHERE email = ? AND password = ?";

			ps = con.prepareStatement(query);

			ps.setString(1, idUser.getText());
			ps.setString(2, idPass.getText());

			rs = ps.executeQuery();

		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
 	}
}