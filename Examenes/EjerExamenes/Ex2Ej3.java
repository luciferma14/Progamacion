package EjerExamenes;
import java.util.Scanner;

public class Ex2Ej3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int casos;
        int total = 0;
        char turno;
        String hhmm; // hora y  minutos
        int hh;
        int mm;
        int limite = 0;


        casos = sc.nextInt();

        for (int i = 1; i <= casos; i++){

            sc.next(); //nombre
            turno = sc.next().charAt(0);
            hhmm = sc.next(); 

            hh = Integer.valueOf(hhmm.substring(0,2));
            mm = Integer.valueOf(hhmm.substring(3));

            if (turno == 'M') 
                limite = 6;
            if (turno == 'T') 
                limite = 14;
            if (turno == 'N') 
                limite = 22;

            //comprobar si llega tarde
            if (hh > limite || (hh == limite && mm > 0)) 
                total++;
       }

        System.out.println(total);

        sc.close();        

    }
}         