import java.util.Scanner;   

public class EjemploJava3 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int hora;

        System.out.println("Que hora es: ");
        hora = sc.nextInt();

        if (hora >= 8 && hora < 12) {
            System.out.println("Buenos dias!");

        }else if (hora >= 13 && hora <= 21) {
            System.out.println("Buenas tardes!");

        }else if (hora >= 22 && hora <= 24) {
            System.out.println("Buenas noches!");
            
        }

    }
}