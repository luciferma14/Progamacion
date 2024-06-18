package ExamenExtraOrd;

import java.lang.Math;

public class DistanceCalculator {

    // Radio de la Tierra en kilómetros
    private static final double EARTH_RADIUS_KM = 6371.0;

    // Calcula la distancia en kilómetros entre dos puntos en grados decimales
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convierte grados a radianes
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calcula las diferencias en latitud y longitud
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Aplica la fórmula de la distancia en la superficie esférica
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS_KM * c;

        return distance;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        double distance = calculateDistance(40.504000, -3.567000, 41.296943, 2.078464);
        System.out.println("Distancia entre los puntos: " + distance + " km");
    }
}
