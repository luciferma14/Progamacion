public class Persona{
    
    private String nombre;
    private String apellidos;
    private String nif;
    private Direccion direccion;

    public Persona(String nombre, String apellidos, String nif, Direccion direccion){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
    }

    public Persona(String nombre, String apellidos, String nif){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "nombre " + nombre + ", apellidos " + apellidos + ", NIF " + nif + ", direccion " + direccion.toString();
    }
}