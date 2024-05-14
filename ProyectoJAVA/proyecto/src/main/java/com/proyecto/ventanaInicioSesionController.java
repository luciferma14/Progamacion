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

        App.setRoot("busResPresDev");

        try {
            Connection con = DriverManager.getConnection(bibl,usr,pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        login log= new login();
        
        int result= log.ingresarUs();
    
        if(result ==1){
            JOptionPane.showMessageDialog(null, "Ingreso exitoso");
        }else{
            JOptionPane.showMessageDialog(null, "Ingreso Fallido");
        }
    }
}
