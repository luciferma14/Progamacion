import java.util.Scanner;

public class Ejercicio_4 
{

    public static void main(String[] args)
    {  /**patas de los animales
        int patasIns = 6;
        int patasArc = 8;
        int patasCrus = 10;
        int patasCiem = 28;
        int patasMil = 400;
        */
        int totalPatas = 452;

        
        System.out.println("Cuantos animales de cada tipo hay:");

        Scanner animales = new Scanner (System.in);

        System.out.println(animales);

        int animal = animales.nextInt();

        {
              Scanner insectos = new Scanner (System.in);
        {
            System.out.println("Insectos");

                int totalAnimales = insectos.nextInt();
        }

        Scanner aracnicos = new Scanner (System.in);
        {
            System.out.println("Arácnicos");

                int totalAnimales = aracnicos.nextInt();
        }

        Scanner crustaceos = new Scanner (System.in);
        {
            System.out.println("Crustáceos");

                int totalAnimales = crustaceos.nextInt();
        }

        Scanner ciempies = new Scanner (System.in);
        {
            System.out.println("Ciempiés");

                int totalAnimales = ciempies.nextInt();
        }        

        Scanner milpies = new Scanner (System.in);
        {
            System.out.println("Milpiés");

                int totalAnimales = milpies.nextInt();
        }        

        System.out.printf("Patas que hay en total:" + totalPatas * animal);

        }

    }

}

      