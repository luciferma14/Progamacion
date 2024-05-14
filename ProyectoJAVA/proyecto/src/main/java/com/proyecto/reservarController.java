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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class reservarController {

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
    private TableView<Libro> tablaLibros;
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

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                PreparedStatement st = null;

                // Para hacer la query de buscar con todos los campos
                String query = "SELECT * FROM libros WHERE ";

                if(tit == null && aut == null && isb == null && gen == null){

                    if ( !tit.equals("") ) {
                        query += "titulo = '" + tit + "' AND ";
                    }
                    if ( !isb.equals("") ) {
                        query += "isbn = '" + isb + "' AND ";
                    }
                    if ( !gen.equals("") ) {
                        query += "genero = '" + gen + "' AND ";
                    }
                    if ( !aut.equals("") ) {
                        query += "autor = '" + aut + "' ";
                    }
                    // Eliminar el último "AND" si hay al final para que no de error en la query
                    query = query.replaceAll(" AND $", "");
                }
            
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
                    JOptionPane.showMessageDialog(null, "Escribe alguno de los campos para buscar libros");
                }

                try (ResultSet rs = st.executeQuery()) {

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

                    tablaLibros.setItems(lib);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No tenemos ningún libro con esas características." +'\n' + "Inténtelo otra vez.");
        }
    }

    @FXML
    private void reservarLibro() throws SQLException {

        // Coge el libro selecionado de la tabla
        Libro libro = tablaLibros.getSelectionModel().getSelectedItem();

        if (libro != null) {

            if (libro != null) {

                try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                    PreparedStatement st = con.prepareStatement("UPDATE libros SET disponible = ?"); //AÑADIR PARA QUE LEA CADA COLUMNA
                    st.setString(1, "No");                   
                    st.executeUpdate();

                    //libro.setDisponible(false);

                    tablaLibros.refresh();
                    
                    JOptionPane.showMessageDialog(null, "Libro reservado con éxito!");

                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reservar el libro.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El libro no está disponible para reservar.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un libro para reservar.");
        }
    }
}
