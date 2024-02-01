import lib.Tiempo;

public class PruebaTiempo {
    
    Tiempo tmp = new Tiempo(1,20,30);

    Tiempo resulSuma = tmp.suma(new Tiempo(00,20,00)); // Suma 20 mins
    System.out.println(resulSuma.getHoras, resulSuma.getMins, resulSuma.getSegundos);

    Tiempo resulResta = tmp.resta(new Tiempo(00,20,00)); // Restar 20 mins
    System.out.println(resulResta.getHoras, resulResta.getMins, resulResta.getSegundos);
}