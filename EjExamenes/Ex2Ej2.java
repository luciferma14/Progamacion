import java.util.Scanner;

public class Ex2Ej2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int plantas;
        int habitaciones;
        int[][] estado;
        int casos;
        int hab;
        int planta;
        int numHab;
        String resultado = "";


        plantas = sc.nextInt();
        habitaciones = sc.nextInt();

        estado = new int[plantas][habitaciones];
        // cargo la matriz de estado de  habitaciones
        for(int p = 0; p < plantas; p++){
            for(int h = 0; h < plantas; h++){
                estado[p][h] = sc.nextInt();
            }
        }

        casos = sc.nextInt();

        for (int i = 1; i <= casos; i++){

            hab = sc.nextInt();

            planta = (int)(hab/100);
            numHab = (hab%100);

            switch (estado[planta-1][numHab-1]) {
                case 0:
                    resultado = " LIBRE";
                    break;
                case 1: 
                    resultado  =" RESERVADA";
                    break;
                case 2: 
                    resultado = " OCUPADA";
                    break;
                default:
                    break;
            }

            System.out.println(hab + resultado);

        }   

        sc.close();
    }
}        