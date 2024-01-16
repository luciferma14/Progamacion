import java.util.Arrays;

public class Intercambio {

    public static void interValor(double a, double b) {

        double aux;
        aux = a;
        a = b;
        b = aux;

        System.out.printf("interValor: a vale %f y b vale %f\n", a, b);
    }

    public static void interReferencia(double v[]) {

        double aux;

        for (int i = 0; i < (int) (v.length / 2); i++) {
            aux = v[i];
            v[i] = v[v.length - 1 - i];
            v[v.length - 1 - i] = aux;
        }
    
        System.out.printf("interReferencia: v vale %s\n", Arrays.toString(v));
    }
    public static void main(String[] args) {

        double x = 5.0, y = 7.0;
        double[] vector = { 5.0, 7.0 };

        System.out.printf("Antes del intercambio: x es %f y el de y es %f\n", x, y);
        interValor(x, y);

        System.out.printf("Despues del intercambio: x es %f y el de y es %f\n", x, y);

        System.out.println();

        System.out.printf("Antes de interReferencia vector vale %s\n", Arrays.toString(vector));

        interReferencia(vector);

        System.out.printf("Despues de interReferencia vector vale %s\n", Arrays.toString(vector));       
    }
}
