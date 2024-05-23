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
 * Controlador de las reservas que se realizan en la biblioteca.
 */
public class reservarController {

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
    private TableColumn<Libro, String> Disponible;
    @FXML
    private TableColumn<Libro, Integer> IdLibro;


    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr = "root";
    private static String pass = "dbrootpass";

    private static Libro li = null;

    /**
     * Obtiene el libro seleccionado.
     * 
     * @return el libro seleccionado
     */
    public static Libro getLibro() {
        return li;
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

                String query = "SELECT * FROM libros WHERE ";
                if (tit == null && aut == null && isb == null && gen == null) {
                    if (!tit.equals("")) {
                        query += "titulo = '" + tit + "' AND ";
                    }
                    if (!isb.equals("")) {
                        query += "isbn = '" + isb + "' AND ";
                    }
                    if (!gen.equals("")) {
                        query += "genero = '" + gen + "' AND ";
                    }
                    if (!aut.equals("")) {
                        query += "autor = '" + aut + "' ";
                    }
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

                } else {
                    System.out.println("Ninguno estrito");
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("No se encontraron libros");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, escribe alguno de los campos para buscar libros");
                    alert.showAndWait();
                }

                try (ResultSet rs = st.executeQuery()) {
                    ObservableList<Libro> lib = FXCollections.observableArrayList();

                    // Procesa los resultados
                    while (rs.next()) {
                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");
                        // Consulta a la tabla reservas y si esta es no y si no esta es si
                        String disponible = rs.getString("disponible");

                        int idLibro = rs.getInt("idLibro");

                        Libro libro = new Libro(titulo, autor, isbn, genero, disponible, idLibro);
                        lib.add(libro);
                    }

                    // Configura las columnas de la tabla con los valores de los libros.
                    Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<Libro, Long>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));
                    Disponible.setCellValueFactory(new PropertyValueFactory<Libro, String>("disponible"));
                    IdLibro.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idLibro"));

                    tablaLibros.setItems(lib);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // Muestra una alerta para los libros que no se han encontrado
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No tenemos ningún libro con esas características.\" + '\\n" + "' + \"Inténtelo otra vez.");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        IdLibro.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idLibro"));

        ObservableList<Libro> lib = FXCollections.observableArrayList();
        tablaLibros.setItems(lib);
    }

    /**
     * Reserva libros en la base de datos según lo que haya introducido en los campos de texto.
     */
    @FXML
    private void reservarLibros() {
        Libro libroSelecc = tablaLibros.getSelectionModel().getSelectedItem();
        if (libroSelecc != null) {
            if ("No".equals(libroSelecc.getDisponible())) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Libro no disponible");
                alert.setHeaderText(null);
                alert.setContentText(libroSelecc.getTitulo() + " no está disponible para reservar.");
                alert.showAndWait();
                return;
            }
            System.out.println("Reservando el libro: " + libroSelecc.getTitulo());
            realizarReserva(libroSelecc);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se ha seleccionado ningún libro.\nInténtelo otra vez.");
            alert.showAndWait();
        }
    }

    /**
     * Realiza la reserva según los datos introducidos por los campos de texto.
     * @param libroSelecc libro que se ha seleccionado
     */
    private void realizarReserva(Libro libroSelecc) {
        Usuario usuarioInicio = App.getUsuario();
        if (usuarioInicio != null) {
            System.out.println("Usuario autenticado: " + usuarioInicio.getIdUsuario());
            System.out.println("");
            Connection con = null;
            try {
                con = DriverManager.getConnection(bibl, usr, pass);

                String query2 = "INSERT INTO reservas (idLibro, idUsuario, fecha_reserva) VALUES (?, ?, CURRENT_DATE())";
                String queryUpdate = "UPDATE libros SET disponible = ? WHERE idLibro = ?";

                try (PreparedStatement st = con.prepareStatement(query2);
                     PreparedStatement stUpdate = con.prepareStatement(queryUpdate)) {

                    st.setLong(1, libroSelecc.getIdLibro());
                    st.setLong(2, usuarioInicio.getIdUsuario());
                    st.executeUpdate();

                    // Actualiza la disponibilidad del libro.
                    stUpdate.setString(1, "No");
                    stUpdate.setLong(2, libroSelecc.getIdLibro());
                    stUpdate.executeUpdate();

                    // Actualiza el estado del libro en la interfaz.
                    libroSelecc.setDisponible("No");
                    tablaLibros.refresh();

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Reserva realizada");
                    alert.setHeaderText(null);
                    alert.setContentText("Reserva realizada con éxito :)");
                    alert.showAndWait();
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Muestra una alerta si algún libro no está disponible.
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(libroSelecc.getTitulo() + " no está disponible :(");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay un usuario autenticado.");
        }
    }
}