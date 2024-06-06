public class Coche {
    
    private String marca;
    private String modelo;
    private int año;

    public Coche(String marca, String modelo, int año){
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public String mostrarInformacion(){
        return "El coche es un " + marca + ", " + modelo + " del año " + año;
    }
}
