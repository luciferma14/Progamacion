package luciferma_jfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Usuarios {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private boolean admin;

    public static Usuarios login(String email, String password){
        //Consultar en la base de datos el usuario con el email y password
        try{
            Connection con = ConexionBD.getConnection();

            String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            
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