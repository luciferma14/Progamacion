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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class buscarController {

    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }

    @FXML
    private TextField FTitulo;
    @FXML
    private TextField FAutor;
    @FXML
    private TextField FISBN;
    @FXML
    private TextField FGenero;

    @FXML
    private TableView<Libro> tabla; 
    @FXML
    private TableColumn<Libro, String> Titulo; 
    @FXML
    private TableColumn<Libro, String> Autor;
    @FXML
    private TableColumn<Libro, Integer> Isbn;
    @FXML
    private TableColumn<Libro, String> Genero;

    public PreparedStatement ps;

    public ResultSet rs;

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr = "root";
    private static String pass = "dbrootpass";

    private static Libro li = null;

    public static Libro getLibro() {
        return li;
    }

    @FXML
    private void FindLibros() throws SQLException, IOException {

        String tit = FTitulo.getText();
        String aut = FAutor.getText();

        try {
            Connection con = DriverManager.getConnection(bibl, usr, pass);

            String query1 = "SELECT titulo FROM libros WHERE titulo LIKE ?";
            String query2 = "SELECT autor FROM libros WHERE autor LIKE ?";

            PreparedStatement st = null;
            ResultSet rs = null;

            if (!tit.isEmpty() && !aut.isEmpty()) {
                if (!tit.isEmpty()) {
                    st = con.prepareStatement(query1);
                    st.setString(1, "%" + tit + "%");
                    rs = st.executeQuery();

                } else if (!aut.isEmpty()) {
                    st = con.prepareStatement(query2);
                    st.setString(1, "%" + aut + "%");
                    rs = st.executeQuery();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tenemos ningún libro con esas características." +'\n' + "Inténtelo otra vez.");
            }

            ObservableList<Libro> lib = FXCollections.observableArrayList();

            if (rs != null) {
                while (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    int isbn = rs.getInt("ISBN");
                    String genero = rs.getString("genero");

                    Libro libro = new Libro(titulo, autor, isbn, genero);
                    lib.add(libro);
                }
            }

            Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
            Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
            Isbn.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("ISBN"));
            Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));

            tabla.setItems(lib);
    
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }   
}