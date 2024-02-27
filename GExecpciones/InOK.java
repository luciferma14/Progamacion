
import java.util.Scanner;

public class InOK {

    static Scanner sc = new Scanner(System.in);

    public static void LeeInt(){

        try{
            System.out.print("Número: ");
            int num = sc.nextInt();
        }catch(Exception e){
            System.out.println("Error: no es número entero");
            sc.nextLine();
        }
    }

    public static void LeeIntPos(){

        try{
            System.out.print("Número positivo: ");
            int num = sc.nextInt();
            if(num < 0){
                throw new Exception("positivo :(");
            }
        }catch(Exception e){          //Si exepción es == null, pinta nada; sino pinta "positivo :("  
            System.out.println("Error: no es entero " + (e.getMessage() == null ? "" : e.getMessage()));
            sc.nextLine();
        }
    }

    public static void LeeIntRango(){

        try {
            System.out.print("Número dentro del rango (0,100): ");
            int num = sc.nextInt();
            if ((num > 100) || (num < 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: número fuera de rango (0,100)");
            sc.nextLine();
        }
    }

    public static void LeeDou(){

        try{
            System.out.print("Número real: ");
            double num = sc.nextInt();
        }catch(Exception e){
            System.out.println("Error: no es número real");
            sc.nextLine();
        }
    }        

    public static void LeeDouRango(){

        try {
            System.out.print("Número real dentro del rango (0,100): ");
            double num = sc.nextInt();
            if ((num > 100) || (num < 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: número fuera de rango (0,100)");
            sc.nextLine();
        }
    }

    

    public static final String[] COMPOSITORES = {"Bach", "Haydn", "Mozart", "Beethoven","Brahms", "Mahler", "Bartok"};

    public static int LeeString(){

        boolean esta = false;

        try{
            System.out.print("Nombre de un compositor: ");
            String palabra = sc.next();
            
            for (int i = 0; i < COMPOSITORES.length || esta == true; i++) {
                if (COMPOSITORES[i].equals(palabra)) {
                    System.out.print("Está en la posición: " + i);
                    esta = true;
                }else {
                    throw new ElementoNoExsistente("El compositor no está en la lista");
                }
            }       
        }catch (ElementoNoExsistente e) {
            System.out.println(" Error: " + (e.getMessage() == null ? "" : e.getMessage()));
            sc.nextLine();
        }
        return -1;
    }

    public static void main(String[] args) throws ElementoNoExsistente {

        LeeInt();
        LeeIntPos();
        LeeIntRango();
        LeeDou();
        LeeDouRango();
        LeeString();
    }
}
