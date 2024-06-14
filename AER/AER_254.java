import java.util.Scanner;
import java.util.TreeSet;

public class AER_254 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> numeros = new TreeSet<Integer>();

        int num;
        int num2;

        do{
            numeros = new TreeSet<>();
            num = sc.nextInt();
            if(num == 0){
                System.exit(0);
            }

            for(int i = 0; i <= 2; i++){
                num2 = sc.nextInt();
                numeros.add(num2);
            }

            System.out.println(numeros);
    
        }while(num != 0);
            
    }
}
