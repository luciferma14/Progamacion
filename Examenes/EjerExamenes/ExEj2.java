package EjerExamenes;
import java.util.Random;
import java.util.Scanner;

public class ExEj2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

    
        int numApuestas;
        int num1;
        int num2;
        int num3;
        int num4;
        int num5;
        int num6;
        int num7;

        System.out.print("Numero que apuestas: ");
		numApuestas = sc.nextInt();		

        num1 = rand.nextInt(50)+1;
        num2 = rand.nextInt(50)+1;
        num3 = rand.nextInt(50)+1;
        num4 = rand.nextInt(50)+1;
        num5 = rand.nextInt(50)+1;
        num6 = rand.nextInt(10)+1;
        num7 = rand.nextInt(10)+1;
        
			
        System.out.printf("%d  %d  %d  %d  %d + %d %d \n",num1,num2,num3,num4,num5,num6,num7);

        
            
    }        
}

    