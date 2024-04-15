import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControladorBusquedaLibro {

    @FXML
    private TextField campoTitulo;

    @FXML
    private TextField campoAutor;

    @FXML
    private TextField campoISBN;

    @FXML
    private ComboBox<Genero> campoGenero;

    @FXML
    private TableView<Libro> tablaLibros;

    public void buscarLibros() {
        String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        String isbn = campoISBN.getText();
        Genero genero = campoGenero.getValue();

        // Conectarse a la base de datos MySQL
        Connection conexion = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca","lucia","lucia");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");

            // Crear una consulta preparada
            String sql = "SELECT titulo, autor, ISBN, genero FROM libros WHERE titulo LIKE ? OR autor LIKE ? OR ISBN = ? OR genero = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + titulo + "%");
            ps.setString(2, "%" + autor + "%");
            ps.setString(3, isbn);
            ps.setString(4, genero != null ? genero.toString() : null); // Manejar género nulo

            // Ejecutar la consulta y obtener resultados
            ResultSet sr = ps.executeQuery();

            // Mostrar resultados en la tabla
            ObservableList<Libro> libros = ObservableList.of();
            while (sr.next()) {
                int id = sr.getInt("id");
                titulo = sr.getString("titulo");
                autor = sr.getString("autor");
                isbn = sr.getString("ISBN");
                genero = Genero.valueOf(sr.getString("genero"));

                libros.add(new Libro(id, titulo, autor, isbn, genero));
            }

            tablaLibros.setItems(libros);

        } catch (SQLException e) {
            // Manejar errores de base de datos
            e.printStackTrace(); // O mostrar un mensaje de error amigable al usuario
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
