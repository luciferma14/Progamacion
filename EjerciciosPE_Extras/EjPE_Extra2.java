import java.util.Scanner;
import java.util.Random;

public class EjPE_Extra2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int dado1;
        int dado2;


        //for (dado1 = 1; dado1 <= 6; dado1++){
        //    
        //}
        System.out.println("Primer dado: ");
        dado1 = rand.nextInt(6)+1;
        System.out.println(dado1);

        System.out.println("Segundo dado: ");
        dado2 = rand.nextInt(6)+1;
        System.out.println(dado2);

        
    }
}