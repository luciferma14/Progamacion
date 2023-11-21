//package libreria;
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

    public static int digitoN(int num, int x) {
        x = voltea(x);

        while (num-- > 0) {
          x = x / 10;
        }
    
        return (int)(x % 10);
    }

    public static int posicionDeDigito(int x, int y) {
        int i;
        int digitos;

        for (i = 0; (i < digitos(x)) && (digitoN(x, i) != y); i++) {};
    
        if (i == digitos(x)) {
          return -1;
        } else {
          return i;
        }
    }

    public static int trozoDeNumero(int x, int inicio, int fin) {

        int digitos;
        int quitaPorDelante;
        int quitaPorDetras;
        int longitud = digitos(x);

        x = quitaPorDelante(x, inicio);

        x = quitaPorDetras(x, longitud - fin - 1);

        return x;
    }

    public static int juntaNumeros(int x, int y) {

        return (juntaNumeros(x, y));
    }
    
    public static boolean esNumeroKaprekar(int num) {
        
        long cuadrado = (long) num * num;
        String cuadradoStr = String.valueOf(cuadrado);

        for (int i = 1; i < cuadradoStr.length(); i++) {

            String parte1Str;
            String parte2Str;
            long parte1;
            long parte2;


            parte1Str = cuadradoStr.substring(0, i);
            parte2Str = cuadradoStr.substring(i);

            parte1 = parte1Str.isEmpty() ? 0 : Long.parseLong(parte1Str);
            parte2 = parte2Str.isEmpty() ? 0 : Long.parseLong(parte2Str);

            if (parte1 + parte2 == num) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args){

    }
     
}