package POO.Figuras;

import java.util.Vector;

public class CreaFiguras {
    public static void main(String[] args) {

        Vector<Figura> figuras = new Vector<Figura>();

        figuras.add(new Circulo(10)); // Radio=10
        figuras.add(new Cuadrado(10)); // Lado=10
        figuras.add(new Triangulo(10,5)); // Base=10, Altura=5;

        for (Figura f: figuras){
            System.out.println("Área: "+f.area());
            System.out.println("Perímetro: "+f.perimetro());
        }
    }
}