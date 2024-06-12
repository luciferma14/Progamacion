package ExOrdPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.Soundbank;

public class GestorInventario {
    
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        
        try {
            File f = new File("productos_in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while((linea = br.readLine()) != null) {
                String [] partes = linea.split(",");

                String nom = partes[0];
                double precio = Double.parseDouble(partes[1]);
                String categ = partes[2];

                Producto prod = new Producto(nom, precio, categ);

                inventario.agregarProducto(prod);
            }

            System.out.println("Hecho");
            br.close();
            fr.close();
            } catch(IOException e) {
                e.printStackTrace();
        }
    }
}
