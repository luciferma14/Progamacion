public class Profesor extends Persona{

    private int nDespacho;

    public Profesor(String nombre, String apellidos, String nif, Direccion direccion, int nDespacho) {
        super(nombre, apellidos, nif, direccion);
        this.nDespacho = nDespacho;
    }

    public Profesor(String nombre, String apellidos, String nif, int nDespacho) {
        super(nombre, apellidos, nif);
        this.nDespacho = nDespacho;
    }

    public int getnDespacho() {
        return nDespacho;
    }

    public void setnDespacho(int nDespacho) {
        this.nDespacho = nDespacho;
    }

    public String toString(){
        return super.toString() + " - Número de despacho: " + nDespacho;
    }

    
}