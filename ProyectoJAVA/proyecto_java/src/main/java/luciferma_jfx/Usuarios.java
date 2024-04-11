package luciferma_jfx;

public class Usuarios {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private boolean admin;

    public static Usuarios login(String email, String password){
        //Consultar en la base de datos el usuario con el email y password
        return null; //de momento
    }

    public void registar(){
        //Insertar el nuevo usuario en la base de datos
    }

    public void modPerfil(){
        //Actualizar la información del usuario en la base de datos
    }
}