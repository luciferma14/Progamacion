package com.proyecto;

import java.sql.Statement;
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
    private TableColumn<Libro, Long> ISBN;
    @FXML
    private TableColumn<Libro, String> Genero;
    @FXML
    private TableColumn<Libro, Boolean> Disponible;
    

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
            
                // if (!tit.equals("")) {
                //     query = "SELECT * FROM libros WHERE titulo LIKE ?";
                //     st = con.prepareStatement(query);
                //     st.setString(1, "%" + tit + "%");
                //     System.out.println("Hago la query de titulos");

                // } else if (!aut.equals("")) {

                //     query = "SELECT * FROM libros WHERE autor LIKE ? ";
                //     st = con.prepareStatement(query);
                //     st.setString(1, "%" + aut + "%");
                //     System.out.println("Hago la query de autores");

                // } else if (!isb.equals("")) {

                //     query = "SELECT * FROM libros WHERE ISBN LIKE ? ";
                //     st = con.prepareStatement(query);
                //     st.setString(1, "%" + isb + "%");
                //     System.out.println("Hago la query de ISBN");

                // } else if (!gen.equals("")) {

                //     query = "SELECT * FROM libros WHERE genero LIKE ?";
                //     st = con.prepareStatement(query);
                //     st.setString(1, "%" + gen + "%");
                //     System.out.println("Hago la query de genero");

                // }else{
                //     System.out.println("Ninguno estrito");
                //     JOptionPane.showMessageDialog(null, "Escribe alguno de los campos para buscar libros");
                // }

                try (
                    ResultSet rs = st.executeQuery(query)) {

                    ObservableList<Libro> lib = FXCollections.observableArrayList();

                    while (rs.next()) {

                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");
                        String disponible = rs.getString("disponible"); // Lo combierte a boolean


                        Libro libro = new Libro(titulo, autor, isbn, genero, disponible);

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
            JOptionPane.showMessageDialog(null, "No tenemos ningún libro con esas características." +'\n' + "Inténtelo otra vez.");
        }
    }
}