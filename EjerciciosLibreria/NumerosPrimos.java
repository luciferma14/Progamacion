import libreria.FNumDAW;

public class NumerosPrimos {
    public static void main(String[] args) {
        
        int limiteSuperior = 1000;
        int contadorPrimos = 0;

        System.out.println("Números primos entre 1 y " + limiteSuperior + ":");

        for (int i = 2; i <= limiteSuperior; i++) {

            if (FNumDAW.esPrimo(i)) {

                System.out.print(i + " ");
                contadorPrimos++;
            }
        }
    }
}    