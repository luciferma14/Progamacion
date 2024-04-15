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

    //iniciar sesión
    public static Usuarios login(String email, String password){ 
        //Consultar en la base de datos el usuario con el email y password
        try{
            String sql;
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca","lucia","lucia");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");

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

    public void registrar() {
        String nombre = nombreTextField.getText();
        String apellido = apellidoTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        Boolean admin = adminCheckBox.getValue();
    
        // Valida la entrada del usuario (opcional)
    
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca","lucia","lucia");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/ReservaVuelos","root", "dbrootpass");

            String sql = "INSERT INTO usuarios (nombre, apellido, email, password, admin) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, email);
            st.setString(4, password);
            st.setBoolean(5, false); // Suponiendo que los nuevos usuarios no son administradores por defecto
    
            int rowsAffected = st.executeUpdate();
    
            if (rowsAffected > 0) {
                // Muestra un mensaje de éxito o realiza otras acciones
                System.out.println("¡Usuario registrado exitosamente!");
            } else {
                // Muestra un mensaje de error
                System.out.println("Error al registrar el usuario. Inténtalo de nuevo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos.");
        }
    }
    
    public void modPerfil(){
        //Actualizar la información del usuario en la base de datos
    }
}