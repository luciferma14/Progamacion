
import java.util.Scanner;

public class AER_710{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int casos;
        int num;

        casos = sc.nextInt();

        
        for (int i = 0; i < casos; i++){
            num = sc.nextInt();
            int[] array = new int[6];

            for (int j = 0; j < array.length; j++){
                array[j] = sc.nextInt();
            }
            int total = num - (array[0] + array[1] + array[2] + array[3] + array[4] + array[5]);
            System.out.println(total);
        }

    }
}