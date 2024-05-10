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
    private TableColumn<Libro, Long> ISBN;
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

        String isb = FISBN.getText();

        String gen = FGenero.getText();


        if (tit != null || !aut.isEmpty()) {

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                String query = "Select * From libros";
                // String query1 = "SELECT * FROM libros WHERE titulo LIKE ? ";
                 PreparedStatement st = null;
                // st.setString(1, "%" + tit + "%");

                // String query2 = "SELECT * FROM libros WHERE autor LIKE ?";
                // st = con.prepareStatement(query2);
                // st.setString(1, "%" + aut + "%");

                // String query3 = "SELECT * FROM libros WHERE ISBN LIKE ?";
                // st = con.prepareStatement(query3);
                // st.setString(1, "%" + isb + "%");

                // String query4 = "SELECT * FROM libros WHERE genero LIKE ?";
                // st= con.prepareStatement(query4);
                // st.setString(1, "%" + gen + "%");
                
            
                if (!tit.equals("")) {
                    query = "SELECT * FROM libros WHERE titulo LIKE ?";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + tit + "%");
                    System.out.println("Hago la query de titulos");

                } else if (!aut.equals("")) {

                    query = "SELECT * FROM libros WHERE autor LIKE ? ";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + aut + "%");
                    System.out.println("Hago la query de autores");

                } else if (!isb.equals("")) {

                    query = "SELECT * FROM libros WHERE ISBN LIKE ? ";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + isb + "%");
                    System.out.println("Hago la query de ISBN");

                } else if (!gen.equals("")) {

                    query = "SELECT * FROM libros WHERE genero LIKE ?";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + gen + "%");
                    System.out.println("Hago la query de genero");

                }else{
                    System.out.println("Ninguno estrito");
                    st= con.prepareStatement(query);
                }

                try (ResultSet rs = st.executeQuery()) {

                    ObservableList<Libro> lib = FXCollections.observableArrayList();

                    while (rs.next()) {

                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");

                        Libro libro = new Libro(titulo, autor, isbn, genero);

                        lib.add(libro);
                    }

                    Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<Libro, Long>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));

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