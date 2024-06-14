

import EjerExamenes.lib.Fraccion;

public class PruebaFraccion {
    public static void main(String[] args) {
        // Crear dos instancias de la clase Fraccion
        Fraccion fraccion1 = new Fraccion(6, 8);
        Fraccion fraccion2 = new Fraccion(4, 10);

        // Mostrar las fracciones originales
        System.out.println("Fracción 1: " + fraccion1.getNumerador() + "/" + fraccion1.getDenominador());
        System.out.println("Fracción 2: " + fraccion2.getNumerador() + "/" + fraccion2.getDenominador());


        // Realizar la multiplicación de las fracciones
        Fraccion resultadoMultiplicacion = fraccion1.Multiplicar(fraccion1, fraccion2);
        System.out.println("Resultado de la multiplicación: " +
                resultadoMultiplicacion.getNumerador() + "/" + resultadoMultiplicacion.getDenominador());

        // Realizar la división de las fracciones
        Fraccion resultadoDivision = fraccion1.Dividir(fraccion1, fraccion2);
        System.out.println("Resultado de la división: " +
                resultadoDivision.getNumerador() + "/" + resultadoDivision.getDenominador());


        // Simplificar las fracciones originales
        Fraccion fraccionSimplificada1 = fraccion1.Simplificar();
        Fraccion fraccionSimplificada2 = fraccion2.Simplificar();

        // Mostrar las fracciones simplificadas
        System.out.println("Fracción 1 simplificada: " +
                fraccionSimplificada1.getNumerador() + "/" + fraccionSimplificada1.getDenominador());
        System.out.println("Fracción 2 simplificada: " +
                fraccionSimplificada2.getNumerador() + "/" + fraccionSimplificada2.getDenominador());
        
        // Invertir la Fracción 1 solo una vez
        fraccion1.Invertir();
        System.out.println("Fracción invertida: " + fraccion1.getNumerador() + "/" + fraccion1.getDenominador());
    }
}
