package EjerExamenes;
import java.util.Scanner;

public class cal_RPN {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        
        int num;
        String calculoar;

        System.out.println("Calculadora RPN (Q para salir)");

        System.out.print("Longitud array: ");
        num = sc.nextInt();
        double[] array = new double[num]; 
        sc.nextLine();
        
        while (true){
            System.out.print("Número: ");
            calculoar = sc.nextLine();
            //System.out.println("hola");
            

            if (calculoar.equalsIgnoreCase("q")){
                System.exit(0);
            }   
        }
    }
}