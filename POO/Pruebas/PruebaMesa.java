

import EjerExamenes.lib.Mesa;

public class PruebaMesa{

    public static void main (String[] args){

        Mesa miMesa = new Mesa();

        miMesa.setColor("Amarillo");
        System.out.println("Nuevo color: " + miMesa.getColor());
        System.out.println("Area: " + miMesa.area());

        System.out.println("------");
        
        Mesa otraMesa = new Mesa("Azul", 3 , 50, 60, "Acero");
        System.out.println("Otro color: " + otraMesa.getColor());
        System.out.println("Otra area: " + otraMesa.area());
        System.out.println("Otra area en metros: " + otraMesa.area("m"));
        System.out.println("Otra area en pulgadas: " + otraMesa.area("in"));
        System.out.println("Otra area en x: " + otraMesa.area("x"));

    }
}