package POO;

import POO.lib.Tiempo;

public class PruebaTiempo {
    
    Tiempo t = new Tiempo(1,20,30);

    Tiempo resultadoSuma = t.suma(new Tiempo(1,20,30)); // Sumar 2 horas y 30 minutos
    System.out.println(resultadoSuma.getHoras, resultadoSuma.getMins, resultadoSuma.getSegundos);

    Tiempo resultadoResta = t.resta(new Tiempo(1,20,30)); // Restar 15 minutos
    System.out.println(resultadoResta.getHoras, resultadoResta.getMins, resultadoResta.getSegundos);
}