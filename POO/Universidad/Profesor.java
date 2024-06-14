public class Profesor extends Persona{

    private String numDespacho;
    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion;

    public Profesor(String numDespacho, String nombre, String apellidos, String NIF, Direccion direccion){
        super(nombre, apellidos, NIF, direccion);
        this.numDespacho = numDespacho;
    }
    public Profesor(String numDespacho, String nombre, String apellidos, String NIF){
        super(nombre, apellidos, NIF);
        this.numDespacho = numDespacho;
    }
    public Profesor(String nombre, String apellidos, String NIF, Direccion direccion){
        super(nombre, apellidos, NIF, direccion);
    }
    //-------------------------------------------------------
    public String getNumDespacho() {
        return numDespacho;
    }
    public void setNumDespacho(String numDespacho) {
        this.numDespacho = numDespacho;
    }
    public String toString(){
        return super.toString()+ "," + " Num Despacho: " + numDespacho;
    }
}