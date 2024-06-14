import java.util.Scanner;

public class EjemploJava5 {
    public static void main(String[] args) {
        
        int num;
        
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Pinta un número: ");

            num = sc.nextInt();
            
            System.out.println("Has pintado un: " + num);

        } while (num != 0);
            System.out.println("Ha terminado el programa.");
        

    }
}