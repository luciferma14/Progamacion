package POO;

import POO.lib.Cafetera;

public class pruebaCafetera {
    public static void main(String[] args) {
        // Crear una cafetera con la capacidad máxima predeterminada (1000)
        Cafetera cafetera1 = new Cafetera();
        System.out.println("Capacidad máxima de cafetera1: " + cafetera1.getCapacidadMaxima());
        System.out.println("Cantidad actual de cafetera1: " + cafetera1.getCantidadActual());

        // Crear una cafetera con capacidad máxima personalizada (500)
        Cafetera cafetera2 = new Cafetera(500);
        System.out.println("Capacidad máxima de cafetera2: " + cafetera2.getCapacidadMaxima());
        System.out.println("Cantidad actual de cafetera2: " + cafetera2.getCantidadActual());

        // Crear una cafetera con capacidad máxima y cantidad actual personalizadas
        Cafetera cafetera3 = new Cafetera(700, 300);
        System.out.println("Capacidad máxima de cafetera3: " + cafetera3.getCapacidadMaxima());
        System.out.println("Cantidad actual de cafetera3: " + cafetera3.getCantidadActual());

        // Llenar la cafetera1 y mostrar la cantidad actual
        cafetera1.llenarCafetera();
        System.out.println("Después de llenar cafetera1, cantidad actual: " + cafetera1.getCantidadActual());

        // Servir una taza de 200 ml de cafetera2 y mostrar la cantidad actual
        cafetera2.servirTaza(200);
        System.out.println("Después de servir una taza de cafetera2, cantidad actual: " + cafetera2.getCantidadActual());

        // Vaciar la cafetera3 y mostrar la cantidad actual
        cafetera3.vaciarCafetera();
        System.out.println("Después de vaciar cafetera3, cantidad actual: " + cafetera3.getCantidadActual());

        // Agregar 150 ml de café a cafetera1 y mostrar la cantidad actual
        cafetera1.agregarCafe(150);
        System.out.println("Cantidad maxima cafetera 1 "+cafetera1.getCapacidadMaxima());
        System.out.println("Después de agregar café a cafetera1, cantidad actual: " + cafetera1.getCantidadActual());
    }
}
