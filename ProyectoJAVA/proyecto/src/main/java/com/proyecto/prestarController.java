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
    private TableColumn<Libro, Integer> IdLibro;

    @FXML
    private TableView<Usuario> tablaUsers; 
    @FXML
    private TableColumn<Usuario, String> Nombre; 
    @FXML
    private TableColumn<Usuario, String> Apellido;
    @FXML
    private TableColumn<Usuario, String> User;


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
                String query = "SELECT * FROM libros WHERE 1=1";
                if (!tit.equals("")) {
                    query += " AND titulo LIKE ?";
                }
                if (!aut.equals("")) {
                    query += " AND autor LIKE ?";
                }
                if (!isb.equals("")) {
                    query += " AND ISBN LIKE ?";
                }
                if (!gen.equals("")) {
                    query += " AND genero LIKE ?";
                }
                st = con.prepareStatement(query);
                int paramIndex = 1;
                if (!tit.equals("")) {
                    st.setString(paramIndex++, "%" + tit + "%");
                }
                if (!aut.equals("")) {
                    st.setString(paramIndex++, "%" + aut + "%");
                }
                if (!isb.equals("")) {
                    st.setString(paramIndex++, "%" + isb + "%");
                }
                if (!gen.equals("")) {
                    st.setString(paramIndex++, "%" + gen + "%");
                }
                try (ResultSet rs = st.executeQuery()) {
                    ObservableList<Libro> lib = FXCollections.observableArrayList();
                    while (rs.next()) {
                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");
                        String disponible = rs.getString("disponible");
                        int idLibro = rs.getInt("idLibro");

                        Libro libro = new Libro(titulo, autor, isbn, genero, disponible, idLibro);
                        lib.add(libro);
                    }

                    Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<Libro, Long>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));
                    Disponible.setCellValueFactory(new PropertyValueFactory<Libro, Boolean>("disponible"));
                    IdLibro.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idLibro"));

                    tablaLibros.setItems(lib);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tenemos ningún libro con esas características.\nInténtelo otra vez.");
        }
    }

    @FXML
    private void FindUsers() throws SQLException, IOException {
        String nom = FNombre.getText();
        String ape = FApellido.getText();
        String use = FUser.getText();

        if (nom != null || ape != null || use != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                PreparedStatement st = null;
                String query = "SELECT * FROM usuarios WHERE 1=1";
                if (!nom.equals("")) {
                    query += " AND nombre LIKE ?";
                }
                if (!ape.equals("")) {
                    query += " AND apellido LIKE ?";
                }
                if (!use.equals("")) {
                    query += " AND email LIKE ?";
                }
                st = con.prepareStatement(query);
                int paramIndex = 1;
                if (!nom.equals("")) {
                    st.setString(paramIndex++, "%" + nom + "%");
                }
                if (!ape.equals("")) {
                    st.setString(paramIndex++, "%" + ape + "%");
                }
                if (!use.equals("")) {
                    st.setString(paramIndex++, "%" + use + "%");
                }
                try (ResultSet rs = st.executeQuery()) {
                    ObservableList<Usuario> user = FXCollections.observableArrayList();
                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String email = rs.getString("email");
                        int idUsuario = rs.getInt("idUsuario");

                        Usuario usuario = new Usuario(nombre, apellido, email, idUsuario);
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
            JOptionPane.showMessageDialog(null, "No tenemos ningún usuario con esas características.\nInténtelo otra vez.");
        }
    }

    @FXML
    public void registrarPrestamo() throws SQLException {
        Libro libroSeleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        Usuario usuarioReceptorSeleccionado = tablaUsers.getSelectionModel().getSelectedItem();

        if (libroSeleccionado == null || usuarioReceptorSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un libro y un usuario para realizar el préstamo.");
        }

        Usuario idUsuarioPrestador = App.getUsuario();

        try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
            String queryPrestamo = "INSERT INTO prestamos (idUsuarioPrestador, idUsuarioReceptor, idLibro, fecha_prestamo) VALUES (?, ?, ?, CURRENT_DATE())";
            String queryUpdateLibro = "UPDATE libros SET disponible = ? WHERE idLibro = ?";

            try (PreparedStatement stPrestamo = con.prepareStatement(queryPrestamo);
                 PreparedStatement stUpdateLibro = con.prepareStatement(queryUpdateLibro)) {

                stPrestamo.setInt(1, idUsuarioPrestador.getIdUsuario());
                stPrestamo.setInt(2, usuarioReceptorSeleccionado.getIdUsuario());
                stPrestamo.setInt(3, libroSeleccionado.getIdLibro());
                stPrestamo.executeUpdate();

                stUpdateLibro.setString(1, "No");
                stUpdateLibro.setInt(2, libroSeleccionado.getIdLibro());
                stUpdateLibro.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar el préstamo.");
        }
    }
}
