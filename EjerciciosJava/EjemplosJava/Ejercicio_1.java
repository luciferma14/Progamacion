import java.util.Scanner;

public class Ejercicio_1 {


    public static int i;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println(scanner);

        System.out.println("TABLA DE MULTIPLICAR");
        System.out.println("Numero que multiplicar: ");
        

        int numero = scanner.nextInt();
            
            System.out.println(numero + " * " +   1 + "  =  " + (numero *  1));
            System.out.println(numero + " * " +   2 + "  =  " + (numero *  2));
            System.out.println(numero + " * " +   3 + "  =  " + (numero *  3));
            System.out.println(numero + " * " +   4 + "  =  " + (numero *  4));
            System.out.println(numero + " * " +   5 + "  =  " + (numero *  5));
            System.out.println(numero + " * " +   6 + "  =  " + (numero *  6));
            System.out.println(numero + " * " +   7 + "  =  " + (numero *  7));
            System.out.println(numero + " * " +   8 + "  =  " + (numero *  8));
            System.out.println(numero + " * " +   9 + "  =  " + (numero *  9));
            System.out.println(numero + " * " + 10 + " =  " + (numero * 10));

    }
}