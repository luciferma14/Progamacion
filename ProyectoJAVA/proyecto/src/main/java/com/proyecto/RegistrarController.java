package com.proyecto;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.engine.Database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class RegistrarController implements Initializable {
    Connection con;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            crearConexion();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    void crearConexion() throws SQLException {
        try{
             Class.forName("com.proyecto");
             con = DriverManager.getConnection("jdbc:mysql://localhost:33006/Biblioteca","root","dbrootpass");
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void idRegistrar(ActionEvent event) throws IOException {
        try{
            Statement stmt = con.createStatement();
            String dbop = "INSERT INTO usuarios VALUES(idnombre, idApellido, idUser, idPass)";
            stmt.execute(dbop);
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void GoBackToLogin(MouseEvent event) throws IOException {
        System.out.println("x");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }   
}