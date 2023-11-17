package libreria;
import java.util.Scanner;

public class FNumDAW {
    public static double potencia(int base, int exponente) {

        double resultado;
        resultado = Math.pow ((double) base, (double) exponente);

        return resultado;
    } 

    public static int cuentaDigitos(int num) {
        int digitos;

        digitos = (int)(Math.log10(num)+1);

        while(num !=0) {

          num = num/10;
          digitos++;
        }
 
        return digitos;
    }

    public static int voltea(int num) {

        int numInvertido = 0;
        int digito;
        
        while (num != 0) {
            digito = num % 10;    // Coge el último dígito
            numInvertido = numInvertido * 10 + digito;
            num = num / 10;      // Elimina el último dígito  
        }

        return numInvertido;
    }

    public static boolean esCapicua(int num){


        int numOriginal = 0;
        int numInvertido = 0;
        int ultimoDig = 0;
        boolean esCapicua = numOriginal == numInvertido;

        while (numOriginal != 0) {
            ultimoDig = numOriginal % 10;   
            numInvertido = numInvertido * 10 + ultimoDig;
            numOriginal = numOriginal / 10; 
        }

        if (esCapicua) {
            System.out.println("Verdadero");
        } else {
            System.out.println("Falso");
        }

        return esCapicua;
    }

    public static boolean esPrimo(int num) {

        int i = 0;

        while (num <= 0);

        if (num == 1) { // en 1 no es primo 
        System.out.println("Falso");

        }else {
            i = 2;          // i es el divisor 
            while (num % i != 0) {
                i++;
            }
            if (i == num) {
                System.out.println("Verdadero");
            } else {
                System.out.println("Falso");
            }
        }    

        return (i == num);
    }
    
    public static int siguientePrimo(int num){

        int siguiente;

        if (num % 2 == 0){
            siguiente = num + 1;
        } else {
            siguiente = num + 2;
        }

        return siguiente;
    }

    public static int anteriorPrimo(int num){

        int anterior;

        if (num % 2 == 0){
            anterior = num - 1;
        } else {
            anterior = num - 2;
        }
        
        return anterior;
    }

    public static int digitoN(int num) {

        int posicion;


        return;
    }



    public static void main(String[] args){

        

    }
     
}