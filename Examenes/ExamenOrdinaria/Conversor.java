package ExamenOrdinaria;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Conversor {
    
    public static void main(String[] args) {
        
        File archivo = new File("docs_in.txt");
        
        try {
            FileReader lector = new FileReader(archivo);
            Scanner sc = new Scanner(lector);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] campos = linea.split(",");

                Doc doc = new Doc("docs_in.txt", campos[1], campos[2]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
