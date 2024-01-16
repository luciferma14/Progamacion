import java.util.Scanner;

public class ExEj1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = 0;
        String nombre;
        String respuesta1 = "";
        String Si = "Si";
        String No = "No";
        boolean sabes;
        boolean continua;

        System.out.print("Como te llamas? ");
        nombre = sc.next();
        System.out.println("Hola " + nombre);

        
            System.out.print("Sabes programar? ");
            respuesta1 = sc.next();
            
            if (respuesta1 == No);{
            System.out.println("Loooser!");
            }
            if (respuesta1 == Si);{
            System.out.println("Cuantos años llevas programando?");
            }
        
        
    }
        
}

  

