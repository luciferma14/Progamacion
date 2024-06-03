import java.util.ArrayList;

public class Compras extends Formulario {

    private String producto;
    private float precio;

    public Compras(String cliente, String producto, float precio){
        super(cliente);
        this.producto = producto;
        this.precio = precio;
    }

    @Override
    public ArrayList<String> pinta() {

        ArrayList<String> lista = super.pinta();

        lista.add("Producto: " + this.producto);
        lista.add("Precio: " + this.precio);

        return lista;
    }
}
