
import java.util.Scanner;                           

public class Ejercicio_5                    
{
    public static void main(String[] args)
    {   
        Scanner sc = new Scanner (System.in);

        System.out.println("Cuantos huevos caben en la olla: ");

        double olla;

        olla = sc.nextInt();
        
        sc.nextLine();

        System.out.println("Cuantos huevos quieres meter en la olla: ");
        
        double huevos;

        huevos = sc.nextInt();

        sc.nextLine();

        double redondeo = Math.ceil(huevos/olla);

        int tiempo = (int) (redondeo * 10);

        System.out.println("Tardará en hacerlos: " + tiempo + " minutos");

    


    }
}