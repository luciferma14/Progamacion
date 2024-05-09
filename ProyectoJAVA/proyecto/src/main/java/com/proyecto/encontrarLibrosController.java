package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class encontrarLibrosController {

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr = "root";
    private static String pass = "dbrootpass";

    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }

    @FXML
    private TableView<Libro> tabla; 

    @FXML
    private TableColumn<Libro, String> titulo; 

    @FXML
    private TableColumn<Libro, String> autor;

    @FXML
    private TableColumn<Libro, Integer> isbn;

    @FXML
    private TableColumn<Libro, String> genero;

    @FXML
    private void initialize() { 
        try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
            String query = "SELECT titulo, autor, isbn, genero FROM libros";

            ObservableList<Libro> lib = FXCollections.observableArrayList();

            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            titulo.setCellValueFactory(new PropertyValueFactory<Libro,String>("titulo"));
            autor.setCellValueFactory(new PropertyValueFactory<Libro,String>("autor"));
            isbn.setCellValueFactory(new PropertyValueFactory<Libro,Integer>("isbn"));
            genero.setCellValueFactory(new PropertyValueFactory<Libro,String>("genero"));

            tabla.setItems(lib);

            // while (rs.next()) {
            //     String titulo = rs.getString("titulo");
            //     String autor = rs.getString("autor");
            //     String isbn = rs.getString("isbn");
            //     String genero = rs.getString("genero");

                Libro libro = new Libro(titulo, autor, isbn, genero);

                lib.add(libro);
            // }

            tabla.setItems(lib); 
        } catch (SQLException e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }
}
