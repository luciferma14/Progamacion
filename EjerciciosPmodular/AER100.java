import libreria.FNumDAW;
import java.util.Arrays;
import java.util.Scanner;

public class AER100 {
    public static void main(String[] args){

        Scanner sc = new Scanner (System.in);

        int casos;
        int tope = 6174;
        int numeros = 0;
        int numAscendente;
        int numDescendente;


        System.out.print("Casos: ");
        casos = sc.nextInt();


        for (int i = 0; i < casos; i++) {
            System.out.print("Numero: ");
            numeros = sc.nextInt();
            int contador = 0;
    

            while (numeros != tope){
                char[] digitos = String.format("%04d",numeros).toCharArray();
                Arrays.sort(digitos); // ordena de manera ascendente los números del arrays.
                numAscendente = Integer.parseInt(new String(digitos));
                // combierte el array de dígitos en una cadena de caracteres y luego lo combierte en un numero entero.
                numDescendente = Integer.parseInt(new String(digitos));
                numeros = numDescendente - numAscendente;
                contador++;
            }   
           
            System.out.println(contador);
        }   
    }
}