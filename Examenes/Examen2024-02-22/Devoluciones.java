
public class Devoluciones {

    private String producto;
    private double precio;
    private int cont = 0;

    public Devoluciones(String nombre, String id, String producto, double prc) {
        
        this.producto = producto;
        this.precio = prc;
    }

    public Devoluciones(String nombre, String id,String generarId, String nom, String prd, double prc) {
        
        this.producto = prd;
        this.precio = prc;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    public String generarId(String string){
        return "DE" + cont++;
    }

    
}