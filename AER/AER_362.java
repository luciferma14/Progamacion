

import java.util.Scanner;

public class AER_362{
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);

        int casos;
        int dia;
        int mes;

        System.out.print("Casos: ");
        casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {

            System.out.print("Dia: ");
            dia = sc.nextInt();

            System.out.print("Mes: ");
            mes = sc.nextInt();

            if (dia == 25 && mes == 12) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            if (dia > 31){
                System.out.println("Dia no valido");
            }
            if (mes > 12) {
                System.out.println("Mes no valido");
            }
        }


    }
}
