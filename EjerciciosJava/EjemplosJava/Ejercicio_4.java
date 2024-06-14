

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
        

       try (Scanner totalAnimales = new Scanner (System.in))
       {
        
        
        Scanner insectos = new Scanner (System.in);
        {
            System.out.println("Insectos");

                insectos.next();

        Scanner aracnicos = new Scanner (System.in);
        {
            System.out.println("Arácnicos");

                aracnicos.nextInt();
        }

        Scanner crustaceos = new Scanner (System.in);
        {
            System.out.println("Crustáceos");

                crustaceos.nextInt();
        }

        Scanner ciempies = new Scanner (System.in);
        {
            System.out.println("Ciempiés");

                ciempies.nextInt();
        }        

        Scanner milpies = new Scanner (System.in);
        {
            System.out.println("Milpiés");

                milpies.nextInt();
        }   
        int todasPatas = (totalPatas * insectos.nextInt(), aracnicos.nextInt(), crustaceos.nextInt(), 
        ciempies.nextInt(), milpies.nextInt());   // No se por que me da error :(

         System.out.println("Patas que hay en total:" + todasPatas);



        }
       }

    }

}     
