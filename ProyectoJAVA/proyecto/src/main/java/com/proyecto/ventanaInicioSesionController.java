// package com.proyecto;

// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// import javafx.beans.property.SimpleStringProperty;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.TextField;

// public class ventanaInicioSesionController {

//     @FXML
// 	private ComboBox idRol;
// 	@FXML
// 	private TextField idUser;
// 	@FXML
// 	private TextField idPass;

//     private static String driv = "com.mysql.jdbc.Driver";
//     private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
//     private static String usr= "root";
//     private static String pass = "dbrootpass";	


//     @FXML
//     private void cambiaAPrimeraVentana() throws IOException {
//         App.setRoot("primeraVentana");
//     }

//     @FXML
//     private void cambiaABusResPresDev() throws IOException {
//         App.setRoot("busResPresDev");
//     }

//     @FXML
// 	public void initialize() {
// 		idRol.getItems().addAll("Usuario", "Administrador");
// 	}

//     @FXML
// 	public int login(ActionEvent event) throws IOException, SQLException {

// 		App.setRoot("busResPresDev");

// 		try {
// 			Connection con = DriverManager.getConnection(bibl,usr,pass);

//         }
//         public login(idUser, String contraseña) { 
//             this.usuario = new SimpleStringProperty(usuario);
//             this.contraseña = new SimpleStringProperty(contraseña);
//         }
        
    
//         public int ingresarUs(Connection connection) {  

//             try{
//                 String sql = "SELECT * FROM usuarios WHERE usuario = ? and contraseña = ?";

//                 instruccion = connection.prepareStatement(sql);
//                 instruccion.setString(1, usuario.get());
//                 instruccion.setString(2, contraseña.get());
//                 resultado = instruccion.executeQuery();

//             }catch(Exception e){
//                 e.printStackTrace();
//             }
//                     return 0;     
//         }
//     }
// }