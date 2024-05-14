import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejer1 {
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
                File f = new File("Empleados.csv");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine(); //fr.read(), para un caracter
                System.out.println();
                while(linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
                creaTabla();
                insertaDatos();
                br.close();
                fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    }

    private static void creaTabla(){

        int comprobacion;
        try {          

            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw","root", "dbrootpass");

            String crearTabla = "CREATE TABLE exdaw.Empleados (" +
                    "`CodigoEmpleado` int NOT NULL, " +
                    "`Nombre` varchar(50) NOT NULL, " +
                    "`Apellido1` varchar(50) NOT NULL, " +
                    "`Apellido2` varchar(50) DEFAULT NULL, " +
                    "`Extension` varchar(10) NOT NULL," +
                    "`Email` varchar(100) NOT NULL," +
                    "`Email` varchar(100) NOT NULL," +
                    "`CodigoJefe` int DEFAULT NULL," +
                    "`Puesto` varchar(50) DEFAULT NULL," +
                    "PRIMARY KEY (`CodigoEmpleado`)," +
                    "KEY `Empleados_EmpleadosFK` (`CodigoJefe`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\" ";
            PreparedStatement st = con.prepareStatement(crearTabla);
            st.executeUpdate();

            comprobacion = st.executeUpdate();
            if (comprobacion > 0) {
                System.out.println("Alta correcta");
            }else {
                System.out.println("Error en la alta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertaDatos(){

        int comprobacion;
        try {

            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw","root", "dbrootpass");

            String insertar = "INSERT INTO exdaw.Empleados (`CodigoEmpleado`,`Nombre`,`Apellido1`,`Apellido2`,`Extension`,`Email`,`CodigoJefe`,`Puesto`) VALUES ('4','Maria','Solis','Jerez','2847','msolis@jardineria.es',2,'Secretaria');";
            PreparedStatement st = con.prepareStatement(insertar);

            comprobacion = st.executeUpdate();
            if (comprobacion > 0) {
                System.out.println("Alta correcta");
            }else {
                System.out.println("Error en la alta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}