public class Estudiante extends Persona{

    private String idEstudiante;
    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion;

    public Estudiante(String idEstudiante, String nombre, String apellidos, String NIF, Direccion direccion){
        super(nombre, apellidos, NIF, direccion);
        this.idEstudiante = idEstudiante;
    }
    public Estudiante(String idEstudiante, String nombre, String apellidos, String NIF){
        super(nombre, apellidos, NIF);
        this.idEstudiante = idEstudiante;
    }
    public Estudiante(String nombre, String apellidos, String NIF){
        super(nombre, apellidos, NIF);
    }
    public Estudiante(String nombre, String apellidos, String NIF, Direccion direccion){
        super(nombre, apellidos, NIF, direccion);
    }
//-------------------------------------------------------
    public String getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String toString(){
        return super.toString() + "," + " ID Estudiante: " + idEstudiante;
    }
}
    