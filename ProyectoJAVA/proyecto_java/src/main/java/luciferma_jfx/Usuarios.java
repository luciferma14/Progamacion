package luciferma_jfx;
public class Usuarios {
    private int id;
    private String nombre;
    private String password;
    private boolean admin;

    public Usuarios (int id, String nombre, String password, boolean admin){
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.admin = admin;
    }
}
