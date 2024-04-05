import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            case 3: reservaVuelos();
            break;
            case 4: modificarReserva();
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
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");

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
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");            
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

    private static void reservaVuelos() {

        Scanner sc  = new Scanner(System.in);

        String numVuelo;
        String numPasaport;
        int plazasDisp;
        int numAsiento;
        int filasAñadidas;


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reservavuelos","lucia","lucia");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");
            //Seleccionar vuelo
            System.out.print("Número de vuelo: ");
            numVuelo  = sc.nextLine();
            Vuelo vuelo = dameNumVuelo(con, numVuelo);
            if (vuelo == null){
                System.out.println("No se ha encontrado el vuelo");
                return;
            }
            //Seleccionar pasajero
            System.out.print("Número de pasaporte del pasajero: ");
            numPasaport = sc.nextLine();
            Pasajero pasajero  = damePasajero(con, numPasaport);
            if (pasajero == null){
                System.out.println("El pasajero no existe");
                return;
            }
            //Comprobar que quedan  plazas libres
            plazasDisp = vuelo.getCapacidad() - dameNumReservasVuelos(con, vuelo.getIdVuelo());
            if (plazasDisp <= 0 ) {
                System.out.println("No hay plazas disponibles para este vuelo");
                return;
            }
            //Seleccioar asiento
            System.out.print("Número asiento: ");
            numAsiento =  sc.nextInt();
            if (numAsiento < 1 || numAsiento > vuelo.getCapacidad()) {
                System.out.println("Número de asiento no válido");
                return;
            }
            //Reserva vuelo
            String sql = "INSERT INTO Vuelos_Pasajeros (id_vuelo, id_pasajero, n_asiento) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, vuelo.getIdVuelo());
            st.setInt(2, pasajero.getId_pasajero());
            st.setInt(3, numAsiento);

            filasAñadidas = st.executeUpdate();

            if (filasAñadidas > 0){
                System.out.println("Reserva  realizada correctamente");
            }else {
                System.out.println("Error al reservar vuelo");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static int dameNumReservasVuelos(Connection con, int idVuelo) throws SQLException {
        String sql = "SELECT COUNT(*) AS Número_reservas FROM Vuelos_Pasajeros WHERE id_vuelo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idVuelo);

        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("num_reservas");
        } else {
            return 0;
        }
    }

    private static Pasajero damePasajero(Connection con, String numPasaport) throws SQLException {
        String sql = "SELECT * FROM Pasajeros WHERE numero_pasaporte = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, numPasaport);

        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            int idPasajero = resultSet.getInt("id_pasajero");
            String nombre = resultSet.getString("nombre_pasajero");

            return new Pasajero(idPasajero, numPasaport, nombre);
        } else {
            return null;
        }
    }

    private static Vuelo dameNumVuelo(Connection con, String numVuelo) throws SQLException {
        String sql = "SELECT * FROM Vuelos WHERE numero_vuelo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, numVuelo);

        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            int idVuelo = resultSet.getInt("id_vuelo");
            String origen = resultSet.getString("origen");
            String destino = resultSet.getString("destino");
            Date fecha = resultSet.getDate("fecha");
            int capacidad = resultSet.getInt("capacidad");

            return new Vuelo(idVuelo, numVuelo, origen, destino, fecha, capacidad);
        } else {
            return null;
        }
        
    }

    public static void modificarReserva(Connection con, int idReserva, String nuevoAsiento) throws SQLException {

        // Verificar si la reserva existe
        String sql = "SELECT COUNT(*) AS Número_Reservas FROM Reservas WHERE id_reserva = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idReserva);

        ResultSet resultSet = st.executeQuery();

        if (!resultSet.next() || resultSet.getInt("num_reservas") == 0) {
            throw new IllegalArgumentException("No se encontró una reserva con el ID: " + idReserva);
        }

        // Actualizar el asiento de la reserva
        sql = "UPDATE Reservas SET asiento = ? WHERE id_reserva = ?";
        st = con.prepareStatement(sql);
        st.setString(1, nuevoAsiento);
        st.setInt(2, idReserva);

        int filasAfectadas = st.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Reserva modificada correctamente. Nuevo asiento: " + nuevoAsiento);
        } else {
            System.out.println("Error al modificar la reserva.");
        }
    }

}