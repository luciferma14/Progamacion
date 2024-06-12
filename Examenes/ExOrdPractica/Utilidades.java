package ExOrdPractica;

public class Utilidades {
    public static boolean validarProducto(Producto producto) {
        if (producto.getNombre().isEmpty()) {
            return false;
        }
        if (producto.getPrecio() > 1000) {
            return false;
        }
        if (producto.getCategoria().equalsIgnoreCase("Electrodomésticos")) {
            return false;
        }
        return true;
    }
}