import java.util.Scanner;
public class EjercicioPE_6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int dia;
        int dia2;
        int hora;
        int hora2;
        int horasTotales;
        int horasTotales2;
        int horasTranscurridas;

        System.out.println("Introduce primer día y hora: ");

        System.out.print("Día: ");
        dia = sc.nextInt();
        
        System.out.print("Hora: ");
        hora = sc.nextInt();

       
        System.out.println("Introduce segundo día y hora: ");

        System.out.print("Día: ");
        dia2 = sc.nextInt();
        
        System.out.print("Hora: ");
        hora2 = sc.nextInt();


        switch (hora) {

            case 0: System.out.print("Entre las 00:00h del "); break;
            case 1: System.out.print("Entre las 01:00h del "); break;
            case 2: System.out.print("Entre las 02:00h del "); break;
            case 3: System.out.print("Entre las 03:00h del "); break;
            case 4: System.out.print("Entre las 04:00h del "); break;
            case 5: System.out.print("Entre las 05:00h del "); break;
            case 6: System.out.print("Entre las 06:00h del "); break;
            case 7: System.out.print("Entre las 07:00h del "); break;
            case 8: System.out.print("Entre las 08:00h del "); break;
            case 9: System.out.print("Entre las 09:00h del "); break;
            case 10: System.out.print("Entre las 10:00h del "); break;
            case 11: System.out.print("Entre las 11:00h del "); break;
            case 12: System.out.print("Entre las 12:00h del "); break;
            case 13: System.out.print("Entre las 13:00h del "); break;
            case 14: System.out.print("Entre las 14:00h del "); break;
            case 15: System.out.print("Entre las 15:00h del "); break;
            case 16: System.out.print("Entre las 16:00h del "); break;
            case 17: System.out.print("Entre las 17:00h del "); break;
            case 18: System.out.print("Entre las 18:00h del "); break;
            case 19: System.out.print("Entre las 19:00h del "); break;
            case 20: System.out.print("Entre las 20:00h del "); break;
            case 21: System.out.print("Entre las 21:00h del "); break;
            case 22: System.out.print("Entre las 22:00h del "); break;
            case 23: System.out.print("Entre las 23:00h del "); break;
            default: System.out.println("Intuduce el número de la hora");

        }
        
        switch (dia) {

            case 1: System.out.print("lunes"); break;           
            case 2: System.out.print("martes"); break;
            case 3: System.out.print("miércoles"); break;
            case 4: System.out.print("jueves"); break;
            case 5: System.out.print("viernes"); break;
            case 6: System.out.print("sábado"); break;
            case 7: System.out.print("domingo"); break;
            default: System.out.println("Intuduce el número del dia de la semana");            

        }

        switch (hora2) {

            case 0: System.out.print(" y las 00:00h del "); break;
            case 1: System.out.print(" y las 01:00h del "); break;
            case 2: System.out.print(" y las 02:00h del "); break;
            case 3: System.out.print(" y las 03:00h del "); break;
            case 4: System.out.print(" y las 04:00h del "); break;
            case 5: System.out.print(" y las 05:00h del "); break;
            case 6: System.out.print(" y las 06:00h del "); break;
            case 7: System.out.print(" y las 07:00h del "); break;
            case 8: System.out.print(" y las 08:00h del "); break;
            case 9: System.out.print(" y las 09:00h del "); break;
            case 10: System.out.print(" y las 10:00h del "); break;
            case 11: System.out.print(" y las 11:00h del "); break;
            case 12: System.out.print(" y las 12:00h del "); break;
            case 13: System.out.print(" y las 13:00h del "); break;
            case 14: System.out.print(" y las 14:00h del "); break;
            case 15: System.out.print(" y las 15:00h del "); break;
            case 16: System.out.print(" y las 16:00h del "); break;
            case 17: System.out.print(" y las 17:00h del "); break;
            case 18: System.out.print(" y las 18:00h del "); break;
            case 19: System.out.print(" y las 19:00h del "); break;
            case 20: System.out.print(" y las 20:00h del "); break;
            case 21: System.out.print(" y las 21:00h del "); break;
            case 22: System.out.print(" y las 22:00h del "); break;
            case 23: System.out.print(" y las 23:00h del "); break;
            default: System.out.println("Intuduce el número de la hora");            

        }
        
        switch (dia2) {

            case 1: System.out.print("lunes"); break;           
            case 2: System.out.print("martes"); break;
            case 3: System.out.print("miércloes"); break;
            case 4: System.out.print("jueves"); break;
            case 5: System.out.print("viernes"); break;
            case 6: System.out.print("sábado"); break;
            case 7: System.out.print("domingo"); break;
            default: System.out.println("Intuduce el número del dia de la semana");            

        }

        horasTotales = (dia - 1) * 24 + hora;
        horasTotales2 = (dia2 -1) * 24 + hora2;

        horasTranscurridas = Math.abs(horasTotales2 - horasTotales);

        System.out.println(" hay " + horasTranscurridas + " horas");
        
    }
}