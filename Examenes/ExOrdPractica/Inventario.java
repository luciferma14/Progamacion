package ExOrdPractica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        if (producto.validar()) {
            productos.add(producto);
            registrarProductoValido(producto);
        } else {
            registrarProductoInvalido(producto);
        }
    }

    private void registrarProductoValido(Producto producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos_ok.txt", true))) {
            writer.write("Producto: " + producto.getNombre() + " - " + producto.getPrecio() + " - " + producto.getCategoria());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarProductoInvalido(Producto producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos_ko.txt", true))) {
            writer.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCategoria());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}