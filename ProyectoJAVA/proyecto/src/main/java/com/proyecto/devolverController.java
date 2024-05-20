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

    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr = "root";
    private static String pass = "dbrootpass";

        @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }

    Usuario usuarioActual = App.getUsuario();


    @FXML
    private void initialize() {
        cargarPrestamos();
    }

    // CAMBIAR NOMBRE DE LOS USUARIOS DE LA TABLA PRESTAMOS (idUsuarioPrestador y idUsuarioReceptor) Y RELACIONAR LAS CLAVES FORÁNEAS
    // BORRAR COLUMNA DE LA FECHA DE LA DEVOLUCIÓN


    public void cargarPrestamos(){
        if (usuarioActual != null) {

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                String query = "SELECT L.titulo, U.email, P.fecha_prestamo " +
                                "FROM prestamos P " + 
                                "INNER JOIN libros L USING(idLibro) " +
                                "INNER JOIN usuarios U ON P.idUsuarioPrestador = U.idUsuario " +
                                "WHERE P.idUsuarioReceptor = ?";
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, usuarioActual.getIdUsuario());
                ResultSet rs = st.executeQuery();

                ObservableList<Prestamo> prestamos = FXCollections.observableArrayList();
                while (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String usuarioPrestador = rs.getString("email");
                    String fechaPrestamo = rs.getString("fecha_prestamo");

                    prestamos.add(new Prestamo(titulo, usuarioPrestador, fechaPrestamo));
                }

                tituloColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("titulo"));
                usuarioPrestadorColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("usuarioPrestador"));
                fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("fechaPrestamo"));

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
                String query = "DELETE FROM prestamos WHERE idLibro = ? AND idUsuarioReceptor = ?";
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, obtenerIdLibro(prestamoSeleccionado.getTitulo()));
                st.setInt(2, usuarioActual.getIdUsuario());
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
                    cargarPrestamos();
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

    private int obtenerIdLibro(String titulo) {
        int idLibro = -1;
        try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
            String query = "SELECT idLibro FROM libros WHERE titulo = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, titulo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idLibro = rs.getInt("idLibro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idLibro;
    }
}

