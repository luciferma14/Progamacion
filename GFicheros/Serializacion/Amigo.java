import java.io.Serializable;

public class Amigo implements Serializable {
    
    private String nombre;
    private String telefono;

    public Amigo (String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void datosAmigo(){
        System.out.println(nombre + " -> " + telefono);
    }
}
