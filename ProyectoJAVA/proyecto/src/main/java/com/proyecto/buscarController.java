package com.proyecto;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controlador para la búsqueda de libros en la base de datos de la biblioteca.
 */
public class buscarController {

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
    @FXML
    private TableColumn<Libro, Boolean> Disponible;
    @FXML
    private TableColumn<Libro, Integer> Id;

    private static final String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static final String usr = "root";
    private static final String pass = "dbrootpass";

    private static Libro li = null;

    /**
     * Obtiene el libro actual.
     * 
     * @return el libro actual.
     */
    public static Libro getLibro() {
        return li;
    }

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
     * Busca libros en la base de datos según lo que haya introducido en los campos de texto.
     * 
     * @throws SQLException si ocurre un error en la consulta a la base de datos.
     * @throws IOException si ocurre un error durante el proceso.
     */
    @FXML
    private void FindLibros() throws SQLException, IOException {

        // Obtiene los valores introducidos en los campos de texto.
        String tit = FTitulo.getText();
        String aut = FAutor.getText();
        String isb = FISBN.getText();
        String gen = FGenero.getText();

        if ((tit != null && !tit.isEmpty()) || (aut != null && !aut.isEmpty()) || (isb != null && !isb.isEmpty()) || (gen != null && !gen.isEmpty())) {

            try (Connection con = DriverManager.getConnection(bibl, usr, pass)) {
                Statement st = con.createStatement();

                // Construye la consulta SQL para buscar libros según lo intruducido.
                String query = "SELECT * FROM libros WHERE ";

                if (!tit.equals("")) {
                    query += "titulo LIKE '%" + tit + "%' AND ";
                }
                if (!isb.equals("")) {
                    query += "isbn LIKE '%" + isb + "%' AND ";
                }
                if (!gen.equals("")) {
                    query += "genero LIKE '%" + gen + "%' AND ";
                }
                if (!aut.equals("")) {
                    query += "autor LIKE '%" + aut + "%' AND ";
                }

                // Elimina el último "AND" si hay al final para evitar error en la consulta.
                query = query.replaceAll(" AND $", ";");

                System.out.println(query);

                // Ejecuta la consulta SQL.
                try (ResultSet rs = st.executeQuery(query)) {
                    ObservableList<Libro> lib = FXCollections.observableArrayList();
                    boolean  bol = false;
                    // Procesa el resultado de la consulta.
                    while (rs.next()) {
                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        long isbn = rs.getLong("ISBN");
                        String genero = rs.getString("genero");
                        String disponible = rs.getString("disponible");
                        int id = rs.getInt("idLibro");

                        // Crea una instancia de Libro y agregarla a la lista.
                        Libro libro = new Libro(titulo, autor, isbn, genero, disponible, id);
                        lib.add(libro);
                        bol = true;
                    }

                    // Configura las columnas de la tabla con los valores de los libros.
                    Titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
                    Autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
                    ISBN.setCellValueFactory(new PropertyValueFactory<Libro, Long>("isbnString"));
                    Genero.setCellValueFactory(new PropertyValueFactory<Libro, String>("genero"));
                    Disponible.setCellValueFactory(new PropertyValueFactory<Libro, Boolean>("disponible"));
                    
                    // Asigna la lista de libros a la tabla.
                    tabla.setItems(lib);
                    
                    if (!bol) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("No se encontraron libros");
                        alert.setHeaderText(null);
                        alert.setContentText("No hay libros con esas características.");
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // Muestra una alerta si no se encontraron libros con los datos intruducidos.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No se encontraron libros");
            alert.setHeaderText(null);
            alert.setContentText("Necesitas rellenar los campos.");
            alert.showAndWait();
        }
    }
}
