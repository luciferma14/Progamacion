import java.io.*;
import java.util.Scanner;

public class CuentaPalabrasArchivo {
    public static void main(String[] args) {
        String entrada = "entrada.txt";
        String salida = "salida.txt";
        
        try {
            File entr = new File(entrada);
            Scanner sc = new Scanner(entr);
            int cuenta = 0;
            
            while (sc.hasNext()) {
                sc.next();
                cuenta++;
            }
            sc.close();
            
            FileWriter sal = new FileWriter(salida);
            sal.write("Número de palabras en el archivo: " + cuenta);
            sal.close();
            
            System.out.println("El resultado se ha escrito en " + salida);
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo " + entrada + " no se encontró.");
        } catch (IOException e) {
            System.out.println("Error: No se pudo escribir en el archivo " + salida);
        }
    }
}