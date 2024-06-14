import java.util.Scanner;

public class BuscarNumero {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + i + ":");
            numeros[i] = sc.nextInt();
        }
        // buscar numero en array
        System.out.print("Ingrese el número a buscar:");
        int buscar = sc.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscar) {
                System.out.println("El número " + buscar + " se encuentra en la posición " + i);
                encontrado = true;
                break;
            }
        }
    }
}
