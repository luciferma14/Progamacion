import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionVuelos{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opc;


        System.out.println("Menú de Gestión Vuelos");
        System.out.println("1. Alta vuelos");
        System.out.println("2. Alta pasajeros");
        System.out.println("3. Reserva vuelos");
        System.out.println("4. Modificar reserva");
        System.out.println("5. Baja reserva");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
        opc = sc.nextInt();

        switch(opc){

            case 1: altaVuelos();
            break;
            case 2: altaPasajeros();
            break;


            case 6: System.exit(0);
            break;
        }
    }

    private static void altaVuelos() {

        Scanner sc = new Scanner(System.in);

        int idVuelo;
        String numVuelos;
        String origen;
        String destino;
        String fecha;
        Date fech;
        int capacidad;
        String vueloSql;
        int comprobacion;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reservavuelos","lucia","lucia");
            System.out.print("ID vuelo: ");
            idVuelo = sc.nextInt();
            System.out.print("Número de vuelo:");
            numVuelos = sc.nextLine();
            System.out.print("Origen: ");
            origen = sc.nextLine();
            System.out.print("Destino: ");
            destino = sc.nextLine();
            System.out.print("Fecha (aaaa-mm-dd): ");
            fecha = sc.nextLine();
            fech = Date.valueOf(fecha);
            System.out.print("Capacidad: ");
            capacidad = sc.nextInt();

            vueloSql = "INSERT INTO vuelos (id_vuelo, numero_vuelo, origen, destino, fecha, capacidad) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(vueloSql);
            st.setInt(1, idVuelo);
            st.setString(2, numVuelos);
            st.setString(3, origen);
            st.setString(4, destino);
            st.setString(5, fecha);
            st.setInt(6, capacidad);

            comprobacion = st.executeUpdate();
            if (comprobacion > 0) {
                System.out.println("Alta correcta");
            }else {
                System.out.println("Error en la alta");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void altaPasajeros() {

        Scanner sc = new Scanner(System.in);

        int idPasajero;
        String numPasaporte;
        String nombrePasajero;
        String pasaSql;
        int comprobacion;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reservavuelos","lucia","lucia");
            System.out.print("ID pasajero: ");
            idPasajero = sc.nextInt();
            System.out.print("Número de pasaporte:");
            numPasaporte = sc.nextLine();
            System.out.print("Nombre del pasajero: ");
            nombrePasajero = sc.nextLine();


            pasaSql = "INSERT INTO pasajeros (id_pasajeros, numero_pasaporte, nombre_pasajero) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(pasaSql);
            st.setInt(1, idPasajero);
            st.setString(2, numPasaporte);
            st.setString(3, nombrePasajero);

            comprobacion = st.executeUpdate();
            if (comprobacion > 0) {
                System.out.println("Alta correcta");
            }else {
                System.out.println("Error en la alta");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}