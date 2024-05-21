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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

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

    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }

    private Usuario usuarioActual = App.getUsuario();

    @FXML
    private void initialize() {
        cargarPrestamosYReservas();
    }

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

                while (rsPrestamos.next()) {
                    String titulo = rsPrestamos.getString("titulo");
                    String usuarioPrestador = rsPrestamos.getString("email");
                    String fechaPrestamo = rsPrestamos.getString("fecha_prestamo");

                    prestamos.add(new Prestamo(titulo, usuarioPrestador, fechaPrestamo));
                }

                while (rsReservas.next()) {
                    String titulo = rsReservas.getString("titulo");
                    String usuarioPrestador = rsReservas.getString("email");
                    String fechaReserva = rsReservas.getString("fecha_reserva");

                    prestamos.add(new Prestamo(titulo, usuarioPrestador, fechaReserva));
                }
                
                tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
                usuarioPrestadorColumn.setCellValueFactory(new PropertyValueFactory<>("usuarioPrestador"));
                fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));

                tablaPrestamos.setItems(prestamos);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void devolverLibro() {
        Prestamo prestamoSeleccionado = tablaPrestamos.getSelectionModel().getSelectedItem();
        if (prestamoSeleccionado != null) {
            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                String queryPrestamo = "DELETE FROM prestamos WHERE idLibro = (SELECT idLibro FROM libros WHERE titulo = ?) AND idUsuarioReceptor = ?";
                String queryReserva = "DELETE FROM reservas WHERE idLibro = (SELECT idLibro FROM libros WHERE titulo = ?) AND idUsuario = ?";

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
                    JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
                    cargarPrestamosYReservas();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al devolver el libro.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un libro para devolver.");
        }
    }
}
