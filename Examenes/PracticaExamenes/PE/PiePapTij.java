import java.util.Random;
import java.util.Scanner;

public class PiePapTij{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcOrd;
        int opcPer;

        do{
            opcOrd = (int) (Math.random()*3+1); // genera un número aleatorio del 1 al 3

            System.out.println("");
            System.out.println("Juego Piedra, Papel o Tijera");
            System.out.println("-----------------------------");
            System.out.println("1) PIEDRA");
            System.out.println("2) PAPEL");
            System.out.println("3) TIJERA");
            System.out.println("4) Salir");
            System.out.print("Elige una opción: ");
            opcPer = sc.nextInt();

            switch (opcPer) {
                case 1:
                    if(opcOrd == 1){
                        System.out.println("Los dos habeis sacado piedra. EMPATE!!");
                    }else if (opcOrd == 2){
                        System.out.println("El ordenador ha sacado papel. HAS PERDIDO!!");
                    }else {
                        System.out.println("El ordenador ha sacado tijera. HAS GANADO!!");
                    }
                break;
                case 2:
                    if(opcOrd == 2){
                        System.out.println("Los dos habeis sacado papel. EMPATE!!");
                    }else if (opcOrd == 1){
                        System.out.println("El ordenador ha sacado piedra. HAS GANADO!!");
                    }else {
                        System.out.println("El ordenador ha sacado tijera. HAS PERDIDO!!");
                    }
                break;
                case 3:
                    if(opcOrd == 3){
                        System.out.println("Los dos habeis sacado tijera. EMPATE!!");
                    }else if (opcOrd == 1){
                        System.out.println("El ordenador ha sacado piedra. HAS PERDIDO!!");
                    }else {
                        System.out.println("El ordenador ha sacado papel. HAS GANADO!!");
                    }
                break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
                break;
            }

        }while(true);
    }
}