import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        ResultSet comprobacion;
        try {          


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw","root", "dbrootpass");
            //Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exdaw","lucia","lucia");


            String crearTabla = " CREATE TABLE exdaw.Empleados (\n" + //
                                "  `CodigoEmpleado` int NOT NULL,\n" + //
                                "  `Nombre` varchar(50) NOT NULL,\n" + //
                                "  `Apellido1` varchar(50) NOT NULL,\n" + //
                                "  `Apellido2` varchar(50) DEFAULT NULL,\n" + //
                                "  `Extension` varchar(10) NOT NULL,\n" + //
                                "  `Email` varchar(100) NOT NULL,\n" + //
                                "  `CodigoJefe` int DEFAULT NULL,\n" + //
                                "  `Puesto` varchar(50) DEFAULT NULL,\n" + //
                                "  PRIMARY KEY (`CodigoEmpleado`),\n" + //
                                "  KEY `Empleados_EmpleadosFK` (`CodigoJefe`)\n" + //
                                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            PreparedStatement st = con.prepareStatement(crearTabla);

            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertaDatos(){

        int comprobacion;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw","root", "dbrootpass");
            //Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exdaw","lucia","lucia");

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