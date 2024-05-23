package com.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controlador para gestionar los préstamos de libros.
 */
public class prestarController {

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

    private static final String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static final String usr = "root";
    private static final String pass = "dbrootpass";

    private static Libro li = null;
    private static Usuario us = null;

    /**
     * Obtiene el libro seleccionado.
     * 
     * @return el libro seleccionado
     */
    public static Libro getLibro() {
        return li;
    }

    /**
     * Obtiene el usuario seleccionado.
     * 
     * @return el usuario seleccionado
     */
    public static Usuario getUsuario() {
        return us;
    }

    /**
     * Cierra la sesión actual y vuelve a la primera ventana.
     * 
     * @throws IOException si ocurre un error al cambiar de ventana
     */
    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

    /**
     * Cambia a la ventana de opciones.
     * 
     * @throws IOException si ocurre un error al cambiar de ventana
     */
    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }

    /**
     * Busca libros en la base de datos según los datos intruducidos en la búsqueda.
     * 
     * @throws SQLException si ocurre un error en la consulta de la base de datos
     * @throws IOException si ocurre un error
     */
    @FXML
    private void FindLibros() throws SQLException, IOException {
        String tit = FTitulo.getText();
        String aut = FAutor.getText();
        String isb = FISBN.getText();
        String gen = FGenero.getText();

        if (tit != null || aut != null || isb != null || gen != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                PreparedStatement st = null;
                String query = "SELECT * FROM libros WHERE 1=1"; // Adición dinámica de las condiciones.

                // Añade las condiciones basadas en la entrada del usuario.
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

                    // Procesa los resultados
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

                    Titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
                    Disponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
                    IdLibro.setCellValueFactory(new PropertyValueFactory<>("idLibro"));

                    tablaLibros.setItems(lib);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No tenemos ningún libro con esas características.");
            alert.showAndWait();
        }
    }

    /**
     * Busca usuarios en la base de datos según los datos intruducidos en la búsqueda.
     * 
     * @throws SQLException si ocurre un error en la consulta de la base de datos
     * @throws IOException si ocurre un error
     */
    @FXML
    private void FindUsers() throws SQLException, IOException {
        String nom = FNombre.getText();
        String ape = FApellido.getText();
        String use = FUser.getText();

        if (nom != null || ape != null || use != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                PreparedStatement st = null;
                String query = "SELECT * FROM usuarios WHERE 1=1"; // Adición dinámica de las condiciones.

                // Añade las condiciones basadas en la entrada del usuario.
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
                    // Procesa los resultados
                    while (rs.next()) {
                        int idUsuario = rs.getInt("idUsuario");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String email = rs.getString("email");

                        Usuario usuario = new Usuario(idUsuario, nombre, apellido, email);
                        user.add(usuario);
                    }

                    Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    Apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
                    User.setCellValueFactory(new PropertyValueFactory<>("email"));

                    tablaUsers.setItems(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No tenemos ningún usuario con esas características.");
            alert.showAndWait(); 
        }
    }

    /**
     * Registra un préstamo de el libro en la base de datos.
     * 
     * @throws SQLException si ocurre un error en la consulta de la base de datos
     */
    @FXML
    public void registrarPrestamo() throws SQLException {
        Libro libroSeleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        Usuario usuarioReceptorSeleccionado = tablaUsers.getSelectionModel().getSelectedItem();

        if (libroSeleccionado == null || usuarioReceptorSeleccionado == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un libro y un usuario para realizar el préstamo.");
            alert.showAndWait();
            return;
        }

        if ("No".equals(libroSeleccionado.getDisponible())) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Libro no disponible");
            alert.setHeaderText(null);
            alert.setContentText("El libro seleccionado no está disponible para prestar.");
            alert.showAndWait();
            return;
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
                
                // Actualiza el estado del libro en la tabla local
                libroSeleccionado.setDisponible("No");
                tablaLibros.refresh(); // Actualiza la vista de la tabla
            }

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Préstamo realizado");
            alert.setHeaderText(null);
            alert.setContentText("Préstamo registrado correctamente");
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error en el préstamo");
            alert.setHeaderText(null);
            alert.setContentText("Ocurrió un error al registrar el préstamo.");
            alert.showAndWait();
        }
    }
}
