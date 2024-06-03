
public class Pedidos {
    
    private String nombre;
    private String producto;
    private double precio;
    private String id;
    private int cont = 0;

    public Pedidos(String nombre, String id, String producto, double precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public String generarId(String string){
        return "PE" + cont++;
    }
    
    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }
    
}