package AER;

import java.util.Scanner;

public class AER_369 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num;
        
        while (true){
            System.out.print("Numero: ");
            num = sc.nextInt();
            
            for (int i = 0; i < num; i++){
                System.out.print("1");
            }

            if (num == 0){
                System.exit(0);
            }
            System.out.println();
        }
    }
}
