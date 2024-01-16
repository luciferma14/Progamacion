import java.util.Scanner;
import java.util.Random;

public class EjPE_Extra1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int dado1;
        int dado2;
        int dado3;
        int sumaDados;

        
        
        System.out.println("Primer dado: ");
        dado1 = rand.nextInt(6)+1;
        System.out.println(dado1);

        System.out.println("Segundo dado: ");
        dado2 = rand.nextInt(6)+1;
        System.out.println(dado2);

        System.out.println("Tercer dado: ");
        dado3 = rand.nextInt(6)+1;
        System.out.println(dado3);

        sumaDados = dado1 + dado2 + dado3;

        System.out.println("La suma de las tres tiras es: " + sumaDados);
        
    }
}