import java.util.Scanner;

public class EjemploJava1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1;
        int n2;
        

        System.out.println("Escribe un munero entero: ");
        n1 = sc.nextInt();
        System.out.println("Escribe otro munero entero: ");
        n2 = sc.nextInt();

        System.out.println("Los numeros son: " + n1 + "y" + n2);


    }

}
