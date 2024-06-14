package EstructuraDinamica;

import java.util.Scanner;

public class AER_702_ED {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int saldoInicial;
        int acciones;
        int saldo;
        String movimiento;
        String fecha;
        int dinero;
        int dia;
        int mes;

        System.out.print("Saldo inicial: ");
        saldoInicial = sc.nextInt();

        System.out.print("Acciones: ");
        acciones = sc.nextInt();

        saldo = saldoInicial;

        System.out.println(saldo + " " + sc.nextLine().trim());

                for (int i = 0; i < acciones; i++) {
            
            movimiento = sc.nextLine();
            fecha = movimiento.substring(0, 5).trim();
            dinero = Integer.parseInt(movimiento.split(" ")[1]);

         
            dia = Integer.parseInt(fecha.split("-")[0]);
            mes = Integer.parseInt(fecha.split("-")[1]);

            if (dinero > 0) {
                saldo += dinero;
              } else {
                saldo = saldo - Math.abs(dinero);
              }

            System.out.println(saldo + " ");
        }
    }
}   