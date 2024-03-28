import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservaVuelos{
    public static void main(String[] args) {

        try{

            String vuelos;

            //Conexión con la BD
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservaVuelos","lucia", "lucia");

            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");
             // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();
             // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            //ResultSet rs = st.executeQuery("SELECT NOM, CLIENT_COD FROM CLIENT");

            // vuelos =  "CREATE TABLE(" + "id_vuelo INT PRIMARY KEY," + "numero_vuelo INT NOT NULL," + "origen VARCHAR(50) NOT NULL," + "destino VARCHAR(50) NOT NULL," + "fecha DATE NOT NULL," + "capacidad INT NOT NULL)";
            // st.executeUpdate(vuelos);




        }catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + "-" + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//compilar javac -cp :lib/mysql-connector-j-8.3.0.jar ReservaVuelos.java 