import java.util.Scanner;

public class EjArray3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean simetrica;
        

        int[][] matriz = new int[4][4];

            System.out.println("Introduce los números de la matriz 4x4: ");

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print("m[" + i + "][" + j + "]: ");
                    matriz[i][j] = sc.nextInt();
                }
            }

            simetrica = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                     if (matriz[i][j] != matriz[j][i]) {
                        simetrica = false;
                     }break;
                }
            }
            
            System.out.println("La matriz es:");
            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println(matriz[i][j] + " ");
                }
            }

            if (simetrica) {
                System.out.println("Es simétrica");
            }else 
                System.out.println("No es simétrica");
    }
}