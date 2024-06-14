import java.util.InputMismatchException;
import java.util.Scanner;

public class Division{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

            try{
                System.out.print("Numerador: ");
                int den = sc.nextInt();
                System.out.print("Denominador: ");
                int num = sc.nextInt();
                
                int resul = den / num;

                System.out.println("Resultado: " + den + "/" + num + "=" + resul);

            }catch(InputMismatchException e){
                System.out.println("No es un número");
            }catch(ArithmeticException e){
                System.out.println("No se puede dividir por 0");
            }catch(Exception e){
                System.out.println("Problemas con la división");
            }
    }
}