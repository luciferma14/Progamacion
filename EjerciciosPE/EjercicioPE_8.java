import java.util.Scanner;

public class EjercicioPE_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion1 = "piedra";
        String opcion2 = "papel";
        String opcion3 = "tijera";
        String opcion4 = "lagarto";
        String opcion5 = "spock";
        int opcionOrdenador;
        int opcionUsuario;
        String opcionOrdenadorStg;
        String opcionUsuarioStg;


        opcionOrdenador = (int) (Math.random() * 5) + 1;

        System.out.println("Juego Piedra, Papel, Tijera, Lagarto o Spock");
        System.out.println("Elige una opción: ");
        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijera");
        System.out.println("4 - Lagarto");
        System.out.println("5 - Spock");
       

        do {
            System.out.print("Introduce tu opción: ");
             opcionUsuario = sc.nextInt();

        } while (opcionUsuario < 1 || opcionOrdenador > 5);

        switch (opcionOrdenador) {
            case 1: opcionOrdenadorStg = "Piedra"; break;
            case 2: opcionOrdenadorStg = "Papel"; break;
            case 3: opcionOrdenadorStg = "Tijera"; break;
            case 4: opcionOrdenadorStg = "Lagarto"; break;
            case 5: opcionOrdenadorStg = "Spock"; break;
        }

        switch (opcionUsuario) {
            case 1: opcionUsuarioStg = "Piedra"; break;
            case 2: opcionUsuarioStg = "Papel"; break;
            case 3: opcionUsuarioStg = "Tijera"; break;
            case 4: opcionUsuarioStg = "Lagarto"; break;
            case 5: opcionUsuarioStg = "Spock"; break;
        }

        
        System.out.println("El ordenador eligió: " + opcionOrdenador);


        if (opcionOrdenador == opcionUsuario) {
            System.out.println("Ha habido un empate!");

        } else if ((opcionUsuario == 1 && opcionOrdenador == 3) 
                    || (opcionUsuario == 2 && opcionOrdenador == 1) 
                        || (opcionUsuario == 3 && opcionOrdenador == 2)
                            || (opcionUsuario == 4 && opcionOrdenador == 5)
                                || (opcionUsuario == 5 && opcionOrdenador == 3)
                                    || (opcionUsuario == 3 && opcionOrdenador == 4)
                                        || (opcionUsuario == 2 && opcionOrdenador == 5)
                                            || (opcionUsuario == 1 && opcionOrdenador == 4)
                                                || (opcionUsuario == 4 && opcionOrdenador == 2)
                                                    || (opcionUsuario == 5 && opcionOrdenador == 1)) {

            System.out.println("HAS GANADO!! :)");

        } else {
            System.out.println("HAS PERDIDO!! :(");
        }


    }
}
