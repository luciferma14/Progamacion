import java.util.Scanner;

public class HorasYDias {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dia1;
        int dia2;
        int hora1;
        int hora2;
        int total;
        int diaHora;
        int horas;

        do{
            System.out.print("Primer dia: ");
            dia1 = sc.nextInt(); 
        }while(dia1 < 0 || dia1 > 7);


        do{
            System.out.print("Primera hora: ");
            hora1 = sc.nextInt(); 
        }while(hora1 < 0 || hora1 > 23);


        do{
            System.out.print("Segundo dia: ");
            dia2 = sc.nextInt(); 
        }while(dia1 < 0 || dia1 > 7);

        do{
            System.out.print("Segunda hora: ");
            hora2 = sc.nextInt(); 
        }while(hora1 < 0 || hora1 > 23);


        diaHora = (dia2 - dia1) * 24;
        horas = hora2 - hora1;

        total = diaHora + horas;

        System.out.println("Entre las " + hora1 + " del dia " + dia1 + " y las " + hora2 + " del dia " + dia2 + " hay " + total + " horas");





    }
}
