package com.proyecto;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class encontrarLibrosController {

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";

    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }

    @FXML
    private TableView<Tab> tabla;

    @FXML
    private TableColumn titulo;
    @FXML
    private TableColumn autor;
    @FXML
    private TableColumn isbn;
    @FXML
    private TableColumn genero;


    try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
        String query = "SELECT titulo, autor, isbn, genero FROM libros";
        ObservableList<Tab> data = FXCollections.observableArrayList();  

        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            String isbn = rs.getString("isbn");
            String genero = rs.getString("genero");
        }

    }catch(SQLException e){
        e.printStackTrace();
    }
}