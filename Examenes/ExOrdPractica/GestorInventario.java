package ExOrdPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestorInventario {
    
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        
        try {
            File f = new File("productos_in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine(); //fr.read(), para un caracter
            System.out.println();
            String [] partes = linea.split(",");

            while(partes != null) {
                System.out.println(linea);
                linea = br.readLine();
                String nom = partes[0];
                double precio = Double.parseDouble(partes[1]);
                String categ = partes[2];

                Producto prod = new Producto(nom, precio, categ);

                inventario.agregarProducto(prod);
                
            }
            br.close();
            fr.close();
            } catch(IOException e) {
                e.printStackTrace();
        }
    }
}
