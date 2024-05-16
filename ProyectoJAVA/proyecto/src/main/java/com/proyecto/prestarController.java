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

public class prestarController {

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
    private TextField FNombre;
    @FXML
    private TextField FApellido;
    @FXML
    private TextField FUser;


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
    private TableView<Usuario> tablaUsers; 
    @FXML
    private TableColumn<Usuario, String> Nombre; 
    @FXML
    private TableColumn<Usuario, String> Apellido;
    @FXML
    private TableColumn<Usuario, String> User;
    

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

    private static Usuario us = null;

    public static Usuario getUsuario() {
        return us;
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
    private void FindUsers() throws SQLException, IOException {

        String nom = FNombre.getText();

        String ape = FApellido.getText();

        String use = FUser.getText();


        if (nom != null || ape != null || use != null ) {

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                PreparedStatement st = null;

                // Para hacer la query de buscar con todos los campos
                String query = "SELECT nombre, apellido, email FROM usuarios WHERE ";

                if(nom == null && ape == null && use == null ){

                    if ( !nom.equals("") ) {
                        query += "nombre = '" + nom + "' AND ";
                    }
                    if ( !ape.equals("") ) {
                        query += "apellido = '" + ape + "' AND ";
                    }
                    if ( !use.equals("") ) {
                        query += "email = '" + use + "' AND ";
                    }
                    // Eliminar el último "AND" si hay al final para que no de error en la query
                    query = query.replaceAll(" AND $", "");
                }
            
                if (!nom.equals("")) {
                    query = "SELECT * FROM usuarios WHERE nombre LIKE ?";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + nom + "%");
                    System.out.println("Hago la query de nombres");

                } else if (!ape.equals("")) {

                    query = "SELECT * FROM usuarios WHERE apellido LIKE ? ";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + ape + "%");
                    System.out.println("Hago la query de apellido");

                } else if (!use.equals("")) {

                    query = "SELECT * FROM usuarios WHERE email LIKE ? ";
                    st = con.prepareStatement(query);
                    st.setString(1, "%" + use + "%");
                    System.out.println("Hago la query de email");

                }else{
                    System.out.println("Ninguno estrito");
                    JOptionPane.showMessageDialog(null, "Escribe alguno de los campos para buscar usuarios");
                }

                try (ResultSet rs = st.executeQuery()) {

                    ObservableList<Usuario> user = FXCollections.observableArrayList();

                    while (rs.next()) {

                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String email = rs.getString("email");

                        Usuario usuario = new Usuario(nombre, apellido, email);

                        user.add(usuario);
                    }

                    Nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
                    Apellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellido"));
                    User.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));

                    tablaUsers.setItems(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No tenemos ningún usuario con esas características." +'\n' + "Inténtelo otra vez.");
        }
    }

    @FXML
    public void registrarPrestamo() throws SQLException {

        String nom = FNombre.getText().trim(); 
        String ape = FApellido.getText().trim();
        String use = FUser.getText().trim();

        String tit = Titulo.getText().trim(); 
        String aut = Autor.getText().trim();
        String isb = ISBN.getText().trim();
        String gen = Genero.getText().trim();

        if (nom.isEmpty() && ape.isEmpty() && use.isEmpty()) {
            return;
        }

        if (tit.isEmpty() && aut.isEmpty() && isb.isEmpty() && gen.isEmpty()) {
            return;
        }

        if (nom != null || ape != null || use != null) {

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {

                // Para hacer la query de buscar con todos los campos
                String querySacarIdUsu = "SELECT idUsuario FROM usuarios WHERE ";

                if(nom != null || ape != null || use != null){

                    if ( !nom.equals("") ) {
                        querySacarIdUsu += "nombre = '" + nom + "' AND ";
                    }
                    if ( !ape.equals("") ) {
                        querySacarIdUsu += "apellido = '" + ape + "' AND ";
                    }
                    if ( !use.equals("") ) {
                        querySacarIdUsu += "email = '" + use + "' AND ";
                    }
        
                    // Eliminar el último "AND" si hay al final para que no de error en la querySacarId
                    querySacarIdUsu = querySacarIdUsu.replaceAll(" AND $", "");
                }

                String query = querySacarIdUsu.toString();
                PreparedStatement st = con.prepareStatement(query);

                if (tit != null || aut != null || isb != null || gen != null) {
        
                    // Para hacer la query de buscar con todos los campos
                    String querySacarIdLib = "SELECT idLibro FROM libros WHERE ";
    
                    if(tit != null || aut != null || isb != null || gen != null){
    
                        if ( !tit.equals("") ) {
                            querySacarIdLib += "titulo = '" + tit + "' AND ";
                        }
                        if ( !aut.equals("") ) {
                            querySacarIdLib += "autor = '" + aut + "' AND ";
                        }
                        if ( !isb.equals("") ) {
                            querySacarIdLib += "ISBN = '" + isb + "' AND ";
                        }
                        if ( !gen.equals("") ) {
                            querySacarIdLib += "genero = '" + gen + "' AND ";
                        }
            
                        // Eliminar el último "AND" si hay al final para que no de error en la querySacarId
                        querySacarIdUsu = querySacarIdUsu.replaceAll(" AND $", "");
                    }
    
                    String query2 = querySacarIdLib.toString();
                    PreparedStatement st2 = con.prepareStatement(query2);
    
                    ResultSet rs = st.executeQuery();
                    ResultSet rs2 = st2.executeQuery();

                    if (rs.next() && rs2.next()) { 
                        int idUser = rs.getInt("idUsuario");
                        int idLib = rs.getInt("idLibro");

                        // Prepare and execute the loan insert query (assuming 'libro' provides the book ID)
                        String insertQuery = "INSERT INTO prestamos (idUsuario, idLibro, fecha_prestamo) VALUES (?, ?, CURRENT_DATE())";
                        PreparedStatement insertSt = con.prepareStatement(insertQuery);
                        insertSt.setInt(1, idUser);
                        insertSt.setInt(2, idLib);
                        insertSt.executeUpdate();
                        insertSt.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "No tenemos ningún usuario con esas características." +'\n' + "Inténtelo otra vez.");
                    }

                    rs.close();
                }
            } 
        }
    }
}



                    // String updateQuery = "UPDATE libros SET Disponible = false WHERE ISBN = ?";
                        // st = con.prepareStatement(updateQuery);
                        // st.setLong(1, libro.getIsbn());
                        // st.executeUpdate();
                        // st.close();

                    // public void registrarPrest() throws IOException, SQLException {
                    //     if (tablaPrestamos.getSelectionModel().getSelectedItem() != null) {
                    //         registrarPrestamo();
                    //     }
                    // }