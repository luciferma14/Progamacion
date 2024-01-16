import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class ExEj1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        String nombre;
        String respuesta1;
        int años;
        boolean sigue;
        int cont = 0;

        System.out.print("Como te llamas? ");
        nombre = sc.next();
        System.out.println("Hola " + nombre);

        do{
            cont++;

            System.out.print("Sabes programar? ");
            respuesta1 = sc.next();

            if (respuesta1.equals("No") || respuesta1.equals("Si") || cont == 3) sigue = false;
            else sigue = true;

        }while (sigue);
                
        if (cont == 3) {//&& respuesta1.equals("No") || respuesta1.equals("Si")){
            System.out.println("Si no vas a contestar bien me voy");
        }else {

            if (respuesta1.equals("No"));{
            System.out.println("Loooser!");
            }else (respuesta1.equals("Si")){
                System.out.print("Cuantos años llevas programando?");
                años = sc.nextInt();
                if (años <= 1){
                    System.out.println("Novato!");
                } else if (años <= 5){
                    System.out.println("Experto!");
                }else  {
                    System.out.println("Oh maestro, te adoramos!");
                }
            }
        }        
    }        
}

  

