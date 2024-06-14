import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservaVuelos{
    public static void main(String[] args) {

        try{

            int vuelos;
            int pasajeros;
            int vuelosPasajeros;
            
            //Conexión con la BD
            //Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reservavuelos","lucia","lucia");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");
             // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();
             // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos");

            vuelos = st.executeUpdate("INSERT INTO Vuelos (id_vuelo, numero_vuelo, origen, destino, fecha, capacidad) VALUES (12345, 'AA123', 'Valencia', 'Madrid', 2023-03-28, 180)");
            pasajeros = st.executeUpdate("INSERT INTO Pasajeros (id_pasajeros, numero_pasaporte, nombre_pasajero) VALUES (67890, '111111', 'Alvaro')");
            vuelosPasajeros = st.executeUpdate("INSERT INTO Vuelos_pasajeros (id_vuelo, id_pasajero, n_asiento) VALUES (12345, 67890, '180')");

            con.close();
        }catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + "-" + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//compilar javac -cp :lib/mysql-connector-j-8.3.0.jar ReservaVuelos.java 
