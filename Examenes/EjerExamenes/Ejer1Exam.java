package EjerExamenes;
import java.util.Scanner;


public class Ejer1Exam {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;
        String codigo = "0";
        int contador = 0;

        System.out.print("Dimensión: ");
        num = sc.nextInt();
        System.out.println("Imagen:");

        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            codigo += sc.nextInt();   
        }

        if (codigo.contains("1")){  //"código" lo he tenido que pasar de un Int a un String
            System.out.print(contador++);
        }

        if (codigo.contains("0")){
            System.out.print(contador++);
        }

        System.out.println();

    }
}