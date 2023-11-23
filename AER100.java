import libreria.FNumDAW;
import java.util.Scanner;

public class AER100 {
    public static void main(String[] args){

        Scanner sc = new Scanner (System.in);

        int casos;
        int tope = 6174;
        int suma;
        int numero = 0;

        System.out.print("Casos: ");
        casos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < casos; i++) {
            System.out.print("Número: ");
            numero = sc.nextInt();

            if (numero > FNumDAW.voltea(numero)){

            System.out.println(numero + " - " + FNumDAW.voltea(numero) + " = " + (numero - FNumDAW.voltea(numero)));
            }else {
            System.out.println(FNumDAW.voltea(numero) + " - " + numero + " = " + (FNumDAW.voltea(numero) - numero));
            }
        }



        
    }
}