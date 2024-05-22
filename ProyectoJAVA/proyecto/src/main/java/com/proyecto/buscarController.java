package com.proyecto;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class buscarController {

    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

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
    private TableColumn<Libro, Long> ISBN;
    @FXML
    private TableColumn<Libro, String> Genero;
    @FXML
    private TableColumn<Libro, Boolean> Disponible;
    @FXML
    private TableColumn<Libro, Integer> Id;


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

        String isb = FISBN.getText();

        String gen = FGenero.getText();


        if (tit != null || aut != null || isb != null || gen != null) {

            try (
                Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                Statement st = con.createStatement();

                // Para hacer la query de buscar con todos los campos
                String query = "SELECT * FROM libros WHERE ";


                    if ( !tit.equals("") ) {
                        query = query+"titulo LIKE  '%" + tit + "%' AND ";
                    }
                    if ( !isb.equals("") ) {
                        query += "isbn LIKE '%" + isb + "%' AND ";
                    }
                    if ( !gen.equals("") ) {
                        query += "genero LIKE '%" + gen + "%' AND ";
                    }
                    if ( !aut.equals("") ) {
                        query = query+"autor LIKE '%" + aut + "%' ;";
                    }

                    query = query.replaceAll(" AND $", ";");

                    System.out.println(query);
                    // Eliminar el último "AND" si hay al final para que no de error en la query
            
                try (
                    ResultSet rs = st.executeQuery(query)) {

                    ObservableList<Libro> lib = FXCollections.observableArrayList();

                    while (rs.next()) {

                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");
                        String disponible = rs.getString("disponible");
                        int id = rs.getInt("idLibro");


                        Libro libro = new Libro(titulo, autor, isbn, genero, disponible, id);

                        lib.add(libro);
                    }

                    Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<Libro, Long>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));
                    Disponible.setCellValueFactory(new PropertyValueFactory<Libro, Boolean>("disponible"));

                    tabla.setItems(lib);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No se encontraron libros");
            alert.setHeaderText(null);
            alert.setContentText("No se encontraron libros con esas características.");
            alert.showAndWait();
        }
    }
}