import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBBDD {
    public static void main(String[] args) {
        
        try{
            //Conexión con la BD
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/empresa","root", "dbrootpass");
             // Creamos un objeto para enviar sentencias SQL a la BD
             Statement st = con.createStatement();
             // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
             ResultSet rs = st.executeQuery("SELECT NOM, CLIENT_COD FROM CLIENT");
             // Recorremos los resultados obtenidos y mostramos sus campos
             while (rs.next()) {
                 String nombre = rs.getString("NOM");
                 int cod = rs.getInt("CLIENT_COD");
                 System.out.println(nombre + ": " + cod);
             }
        st.executeUpdate("INSERT INTO PRODUCTE (PROD_NUM, DESCRIPCIO) VALUES (014, 'Lucia')");
        // Cerramos la conexión
        con.close();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + "-" + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// para compilar = javac -cp :lib/mysql-connector-j-8.3.0.jar TestBBDD.java 
