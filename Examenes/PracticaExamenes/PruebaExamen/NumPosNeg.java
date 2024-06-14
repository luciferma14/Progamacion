import java.util.Scanner;

public class NumPosNeg {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        if(num == 0){
            System.out.println("Número igual que 0");
        }else if (num < 0){
            System.out.println("Número negativo");
        }else {
            System.out.println("Número positivo");
        }
    }
}
