import java.util.Scanner;

public class TablaMult {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Número que multiplicar: ");
        num = sc.nextInt();

        for(int i = 1; i < 11; i++){
            System.out.println(num + " x " + i + " = " + i*num);
        }
    }
}
