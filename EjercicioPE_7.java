import java.util.Scanner;

public class EjercicioPE_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int piedra = 1;
        int papel = 2;
        int tijera = 3;
        int opciones;
        int aleatorio;

        System.out.print("El ordenador a sacado: ");

        aleatorio = (int)Math.floor(Math.random()*3+1);
        System.out.println(aleatorio);

        System.out.print("Tu sacas: ");
        opciones = sc.nextInt();

        switch (opciones) {
            case 1: System.out.println("Piedra");break;
            case 2: System.out.println("Papel");break;
            case 3: System.out.println("Tijeras");break;
        }    
        
        if (piedra == 1) {
            System.out.println("Ha habido un empate");

        } else if (papel == 2) {
            System.out.println("Ha habido un empate");

        }else if (tijera == 3) {
            System.out.println("Ha habido un empate");

        }
        





    }
}
