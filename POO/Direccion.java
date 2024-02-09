public class Direccion {
    
    private String calle;
    private String ciudad;
    private String codPostal;
    private String pais;

    public Direccion(){
        this.calle = "Calle 3";
        this.ciudad = "Barcelona";
        this.codPostal = "78910";
        this.pais = "España";
    }

    public Direccion(String calle, String ciudad, String codPostal, String pais){
        this.calle = calle;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion: " + calle + ", " + ciudad + ", " + codPostal + ", " + pais;
    }

}
