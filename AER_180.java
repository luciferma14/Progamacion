package AER;
import java.util.Scanner;
public class AER_180 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int base;
        int ladoDer;
        int ladoIzq;

        System.out.print("Base: ");
        base = sc.nextInt();

        System.out.print("Lado derecho: ");
        ladoDer = sc.nextInt();

        System.out.print("Lado izquierdo: ");
        ladoIzq = sc.nextInt();

        if (base >= 1){
            if (ladoDer == ladoIzq){
                    System.out.print("ACUTANGULO");
            }
        }
        
        if (base >= 1){
            if (ladoDer == ladoIzq - 1){
                    System.out.print("RECTANGULO");  
            }
        }
        if (base >= 1){
            if (ladoDer == ladoIzq - 2){
                    System.out.print("OBTUSANGULO");
                
            }
        }
    }
}