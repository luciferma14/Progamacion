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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controlador para la gestión de la devolución de libros en la biblioteca.
 */
public class devolverController {

    @FXML
    private TableView<Prestamo> tablaPrestamos;
    @FXML
    private TableColumn<Prestamo, String> tituloColumn;
    @FXML
    private TableColumn<Prestamo, String> usuarioPrestadorColumn;
    @FXML
    private TableColumn<Prestamo, String> fechaPrestamoColumn;

    private static final String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static final String usr = "root";
    private static final String pass = "dbrootpass";

    private Usuario usuarioActual = App.getUsuario();

    /**
     * Cierra la sesión actual y vuelve a la primera ventana.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

    /**
     * Cambia a la ventana de opciones.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }

    /**
     * Inicializa el controlador cargando los préstamos y reservas del usuario actual.
     */
    @FXML
    private void initialize() {
        cargarPrestamosYReservas();
    }

    /**
     * Carga los préstamos y reservas del usuario actual desde la base de datos.
     */
    private void cargarPrestamosYReservas() {
        if (usuarioActual != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                String queryPrestamos = "SELECT L.titulo, U.email, P.fecha_prestamo " +
                                        "FROM prestamos P " + 
                                        "JOIN libros L USING(idLibro) " +
                                        "JOIN usuarios U ON P.idUsuarioPrestador = U.idUsuario " +
                                        "WHERE P.idUsuarioReceptor = ?";
                String queryReservas = "SELECT L.titulo, U.email, R.fecha_reserva " +
                                       "FROM reservas R " +
                                       "JOIN libros L USING(idLibro) " +
                                       "JOIN usuarios U USING(idUsuario) " +
                                       "WHERE R.idUsuario = ?";

                PreparedStatement stPrestamos = con.prepareStatement(queryPrestamos);
                PreparedStatement stReservas = con.prepareStatement(queryReservas);

                stPrestamos.setInt(1, usuarioActual.getIdUsuario());
                stReservas.setInt(1, usuarioActual.getIdUsuario());

                ResultSet rsPrestamos = stPrestamos.executeQuery();
                ResultSet rsReservas = stReservas.executeQuery();

                ObservableList<Prestamo> prestamos = FXCollections.observableArrayList();

                // Procesa los resultados de los préstamos.
                while (rsPrestamos.next()) {
                    String titulo = rsPrestamos.getString("titulo");
                    String usuarioPrestador = rsPrestamos.getString("email");
                    String fechaPrestamo = rsPrestamos.getString("fecha_prestamo");

                    prestamos.add(new Prestamo(titulo, usuarioPrestador, fechaPrestamo));
                }

                // Procesa los resultados de las reservas.
                while (rsReservas.next()) {
                    String titulo = rsReservas.getString("titulo");
                    String usuarioPrestador = rsReservas.getString("email");
                    String fechaReserva = rsReservas.getString("fecha_reserva");

                    prestamos.add(new Prestamo(titulo, usuarioPrestador, fechaReserva));
                }

                // Configura las columnas de la tabla.
                tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
                usuarioPrestadorColumn.setCellValueFactory(new PropertyValueFactory<>("usuarioPrestador"));
                fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));

                // Asigna los datos a la tabla.
                tablaPrestamos.setItems(prestamos);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Realiza la devolución del libro seleccionado.
     */
    @FXML
    private void devolverLibro() {
        Prestamo prestamoSeleccionado = tablaPrestamos.getSelectionModel().getSelectedItem();
        if (prestamoSeleccionado != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                // Consultas para eliminar el préstamo o la reserva y actualizar si está disponible el libro.
                String queryPrestamo = "DELETE FROM prestamos WHERE idLibro = (SELECT idLibro FROM libros WHERE titulo = ?) AND idUsuarioReceptor = ?";
                String queryReserva = "DELETE FROM reservas WHERE idLibro = (SELECT idLibro FROM libros WHERE titulo = ?) AND idUsuario = ?";
                String queryUpdateDisponibilidad = "UPDATE libros SET disponible = 'Si' WHERE titulo = ?";

                PreparedStatement st = con.prepareStatement(queryPrestamo);
                st.setString(1, prestamoSeleccionado.getTitulo());
                st.setInt(2, usuarioActual.getIdUsuario());
                int rowsAffected = st.executeUpdate();

                if (rowsAffected == 0) {
                    st = con.prepareStatement(queryReserva);
                    st.setString(1, prestamoSeleccionado.getTitulo());
                    st.setInt(2, usuarioActual.getIdUsuario());
                    rowsAffected = st.executeUpdate();
                }

                if (rowsAffected > 0) {
                    // Actualiza la disponibilidad del libro.
                    PreparedStatement stUpdate = con.prepareStatement(queryUpdateDisponibilidad);
                    stUpdate.setString(1, prestamoSeleccionado.getTitulo());
                    stUpdate.executeUpdate();

                    // Muestra alerta de éxito.
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Libro devuelto");
                    alert.setHeaderText(null);
                    alert.setContentText("Libro devuelto con éxito :)");
                    alert.showAndWait();

                    // Recarga la tabla de préstamos y reservas.
                    cargarPrestamosYReservas();
                } else {
                    // Muestra alerta de error si no se ha podido devolver el libro.
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error al devolver el libro");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Muestra alerta de error si no se ha seleccionado un libro.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un libro para devolver.");
            alert.showAndWait();
        }
    }
}
