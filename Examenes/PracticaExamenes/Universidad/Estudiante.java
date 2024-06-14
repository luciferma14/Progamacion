public class Estudiante extends Persona{
    
    private int idEstudiante;

    public Estudiante(int idEstudiante){
        super(null,null,null);
        this.idEstudiante = idEstudiante;
    }
    
    public Estudiante(String nombre, String apellidos, String nif, Direccion direccion, int idEstudiante) {
        super(nombre, apellidos, nif, direccion);
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(String nombre, String apellidos, String nif, int idEstudiante) {
        super(nombre, apellidos, nif);
        this.idEstudiante = idEstudiante;
    }

    public int getIdEstudiante(){
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String toString() {
        return super.toString() + " idEstudiante:" + idEstudiante;
    }
}