package AER;

import java.util.Scanner;

public class AER_380 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

		int num;
		int suma;

		do {

			suma = 0;
            System.out.print("Casos cantidades: ");
			num = sc.nextInt();

			if(num != 0){
				
				for(int i=1; i<=num; i++){
                    System.out.print("Cantidades: ");
					suma += sc.nextInt();
				}

                System.out.println();
				System.out.println( "Total: " + suma);
			}

		} while(num != 0);

    }
}
