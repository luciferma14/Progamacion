import EjerExamenes.lib.Tiempo;

public class PruebaTiempo {

    public static void main(String[] args) {
        Tiempo tiempo1 = new Tiempo(1, 30, 45);
        Tiempo tiempo2 = new Tiempo(0, 45, 20);

        Tiempo resultadoSuma = tiempo1.suma(new Tiempo(1, 00, 00), new Tiempo(0, 5, 00), new Tiempo(0, 00, 45));
        Tiempo resultadoResta = tiempo2.resta(new Tiempo(1, 00, 00), new Tiempo(0, 5, 00), new Tiempo(0, 00, 45));

        System.out.println("Tiempo 1: " + tiempo1.toString());
        System.out.println("Tiempo 2: " + tiempo2.toString());
        System.out.println("Resultado Suma: " + resultadoSuma.toString());
        System.out.println("Resultado Resta: " + resultadoResta.toString());

        //compara
        System.out.print(tiempo1.compareTo(tiempo2) + " = "); 

        if (tiempo1.compareTo(tiempo2) == -1){
            System.out.println("El tiempo 1 es menor que el tiempo 2");
        }else if (tiempo1.compareTo(tiempo2) == 1){
            System.out.println("El tiempo 1 es mayor que el tiempo 2");
        }else if (tiempo1.compareTo(tiempo2) == 0) {
            System.out.println("El tiempo 1 es igual que el tiempo 2");
        }
    }  
}