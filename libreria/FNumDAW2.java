package libreria;

public class FNumDAW2 {
    
    //Dada una base y un exponente devuelve la potencia.
    public static double potencia(int base, int exponente) {

        double resultado;
        resultado = Math.pow ((double) base, (double) exponente);

        return resultado;
    } 

    //Cuenta el número de dígitos de un número entero.
    public static int cuentaDigitos(int num) {
        int digitos;

        digitos = (int)(Math.log10(num)+1);

        while(num !=0) {

          num = num/10;
          digitos++;
        }
 
        return digitos;
    }

    //Le da la vuelta a un número.
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

    //Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en caso contrario.
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

    //Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.
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
    
    //Devuelve el primo que es mayor al número que se pasa como parámetro.
    public static int siguientePrimo(int num){

        int siguiente;

        if (num % 2 == 0){
            siguiente = num + 1;
        } else {
            siguiente = num + 2;
        }

        return siguiente;
    }

    //Devuelve el primo inmediatamente anterior al número que se pasa como parámetro.
    public static int anteriorPrimo(int num){

        int anterior;

        if (num % 2 == 0){
            anterior = num - 1;
        } else {
            anterior = num - 2;
        }
        
        return anterior;
    }

    //Devuelve el dígito que está en la posición n de un número entero.
    public static int digitoN(int num, int x) {
        x = voltea(x);

        while (num-- > 0) {
          x = x / 10;
        }
    
        return (int)(x % 10);
    }

    //Da la posición de la primera ocurrencia de un dígito dentro de un número entero. 
    public static int posicionDeDigito(int x, int y) {
        int i;

        for (i = 0; (i < cuentaDigitos(x)) && (digitoN(x, i) != y); i++) {};
    
        if (i == cuentaDigitos(x)) {
          return -1;
        } else {
          return i;
        }
    }

    //Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el ‘trozo’ correspondiente.
    public static int parteNumero(int x, int inicio, int fin) {

        int num = ' ';
        int digito;

        int longitud = cuentaDigitos(x);

        digito = num % 10;

        num = num / 10;

        return x;
    }

    //Pega dos números para formar uno.
    public static int pegaNumeros(int x, int y) {

        return (pegaNumeros(x, y));
    }
    
    //Dice si un número es de kaprekar
    public static boolean kaprekar(int num) {
        
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
        //Para poder compilar :)
    }
     
}