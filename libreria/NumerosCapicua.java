import libreria.FNumDAW;

public class NumerosCapicua {
    public static void main(String[] args) {
        
        int contadorCapicua = 0;

        System.out.println("Números capicúa entre 1000 y 9999:");

        for (int i = 1000; i <= 9999; i++) {
            
            if (FNumDAW.esCapicua(i)) {
                System.out.print(i + " ");
                contadorCapicua++;
            }
        }

        System.out.println("\nTotal de números capicúa: " + contadorCapicua);
    }
}    