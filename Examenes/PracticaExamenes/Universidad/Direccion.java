public class Direccion {

    private String calle;
    private String ciudad;
    private int codPostal;
    private String pais;

    public Direccion() {
        this.calle = "Paseo de la Castellana";
        this.ciudad = "Madrid";
        this.codPostal = 28024;
        this.pais = "Espanya";
    }

    public Direccion(String calle, String ciudad, int codPostal, String pais){
        this.calle = calle;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "calle " + calle + ", ciudad " + ciudad + ", codigoPostal " + codPostal + ", pais " + pais ;
    }
    
}
