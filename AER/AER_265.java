import java.util.Scanner;

public class AER_265 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num;

        do{
            num = sc.nextInt();

            if (num == 0) break;

            int total = num;

            String s_num= Integer.toString(num);

            while (s_num.length()>1) {
                s_num = s_num.substring(1, s_num.length());
                total += Integer.valueOf(s_num);
            }
                
            System.out.println(total);

        }while(num != 0);
    }
}
