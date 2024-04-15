package luciferma_jfx;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuarios {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private boolean admin;

    public static Usuarios login(String email, String password){
        //Consultar en la base de datos el usuario con el email y password
        try{
            String sql;
            Connection con = ConexionBD.getConnection();
            
            sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //de momento
    }

    public void registar(){
        //Insertar el nuevo usuario en la base de datos
    }

    public void modPerfil(){
        //Actualizar la información del usuario en la base de datos
    }


    //conexión con la base de datos
    public static class ConexionBD {

        private static final String conex= "jdbc:mysql://localhost:3306/tu_base_de_datos";
        private static final String usu = "tu_usuario";
        private static final String contra = "tu_contraseña";
    
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(conex, usu, contra);
        }
    
        public static void closeConnection(Connection conn) throws SQLException {
            if (conn != null) {
                conn.close();
            }
        }
    }
}