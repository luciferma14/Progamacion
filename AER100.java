import libreria.FNumDAW;
import java.util.Scanner;

public class AER100 {
    public static void main(String[] args){

        Scanner sc = new Scanner (System.in);

        int casos;
        int tope = 6174;
        int numeros = 0;


        System.out.print("Casos: ");
        casos = sc.nextInt();


        for (int i = 0; i < casos; i++) {
            System.out.print("Numero: ");
            numeros = sc.nextInt();
        }

       
        for (int i = 0; i < casos; i++) { 
            if (numeros > FNumDAW.voltea(numeros)){
                System.out.println(numeros + " - " + FNumDAW.voltea(numeros) + " = " + (numeros - FNumDAW.voltea(numeros)));
            }else {
                System.out.println(FNumDAW.voltea(numeros) + " - " + numeros + " = " + (FNumDAW.voltea(numeros) - numeros));
            }
        }
        
        
    }
}