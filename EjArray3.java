import java.util.Scanner;

public class EjArray3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int fila1;
        int columna1;
        int i = 0;

        char[][] a ={{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '}};

            //Mostrar matriz
            System.out.println("   0   1   2   3  ");
            for (int ia = 0; ia < 4; ia++) {
                for (int j = 0; j < 4; j++) {
                    if (j <= 0) {
                        System.out.print(ia + "| ");
                    }
                    System.out.print(a[ia][j]);
                    if (j < 4) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (ia < 4) {
                    System.out.println("------------------");
                }
            }
    }
}