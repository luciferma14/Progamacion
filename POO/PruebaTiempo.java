import lib.Tiempo;

public class PruebaTiempo {

    public static void main(String[] args) {
        Tiempo tiempo1 = new Tiempo(1, 30, 45);
        Tiempo tiempo2 = new Tiempo(0, 45, 20);

        Tiempo resultadoSuma = tiempo1.suma(new Tiempo(0, 15, 30), new Tiempo(0, 5, 15), new Tiempo(0, 10, 45));
        Tiempo resultadoResta = tiempo1.resta(new Tiempo(0, 45, 0), new Tiempo(0, 10, 15), new Tiempo(0, 5, 30));

        System.out.println("Tiempo 1: " + tiempo1.toString());
        System.out.println("Tiempo 2: " + tiempo2.toString());
        System.out.println("Resultado Suma: " + resultadoSuma.toString());
        System.out.println("Resultado Resta: " + resultadoResta.toString());

        //compara
        if (tiempo1.compareTo(tiempo2) < 0) {
            System.out.println("Tiempo 1 es menor que Tiempo 2");
        } else if (tiempo1.compareTo(tiempo2) > 0) {
            System.out.println("Tiempo 1 es mayor que Tiempo 2");
        } else {
            System.out.println("Tiempo 1 es igual a Tiempo 2");
        }
    }
}
