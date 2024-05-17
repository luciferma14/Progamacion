package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    @FXML
    private TableColumn<Libro, Integer> Id;


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
                    Id.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idLibro"));
                    

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
    private void initialize() {
        // Configuración de las columnas de la tabla
        Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));

        // Añadir algunos libros de ejemplo (reemplazar con tus datos reales)
        ObservableList<Libro> lib = FXCollections.observableArrayList();
        tablaLibros.setItems(lib);

        // Configurar el manejador de eventos para la selección de la tabla
        tablaLibros.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Seleccionar el libro
                System.out.println("Libro seleccionado: " + newSelection.getTitulo());
                // Aquí puedes hacer lo que necesites con el libro seleccionado
            }
        });
    }
                        // AÑADIR ID EN LA TABLA Y COGERLO CON GETIDLIBRO Y AÑADIRLO ABAJO


    @FXML
    private void reservarLibros() throws SQLException {

        Connection con = DriverManager.getConnection(bibl, usr, pass);

        Libro libroSeleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            // Procesar la reserva del libro seleccionado
            System.out.println("Reservando el libro: " + libroSeleccionado.getTitulo());
        } else {
            System.out.println("No se ha seleccionado ningún libro.");
        }

        if (libroSeleccionado != null) {
            System.out.println("Libro seleccionado: " + libroSeleccionado.getIdLibro());
            
            Usuario currentUser = App.getUsuario();

            try {
                if (currentUser != null) {
                    System.out.println("Usuario autenticado: " + currentUser.getIdUsuario());

                    String query2 = "INSERT INTO reservas (idLibro, idUsuario, fecha_reserva) VALUES (?, ?, CURRENT_DATE())";

                    try (con ;
                        PreparedStatement st = con.prepareStatement(query2)) {
                        st.setLong(1, libroSeleccionado.getIdLibro());
                        st.setLong(2, currentUser.getIdUsuario());

                        st.executeUpdate();
                        System.out.println("Reserva realizada con éxito.");
                    }
                } else {
                    System.out.println("No hay un usuario autenticado.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se ha seleccionado ningún libro.");
        }
    }
}   
