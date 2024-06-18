package ExamenExtraOrd;

import java.io.*;
import java.util.*;

public class inf_rutas {

    static class Avion {
        String codigoIATA;
        String nombreModelo;
        double alcance;

        Avion(String codigoIATA, String nombreModelo, double alcance) {
            this.codigoIATA = codigoIATA;
            this.nombreModelo = nombreModelo;
            this.alcance = alcance;
        }
    }

    static class Aeropuerto {
        String codigo;
        String nombre;
        double latitud;
        double longitud;

        Aeropuerto(String codigo, String nombre, double latitud, double longitud) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.latitud = latitud;
            this.longitud = longitud;
        }
    }

    public static void main(String[] args) {
        Map<String, Avion> aviones = leerAviones("aviones.csv");
        Map<String, Aeropuerto> aeropuertos = leerAeropuertos("aeropuertos.csv");
        List<String[]> avionesAeropuertos = leerAvionesAeropuertos("aviones_aeropuerto.csv");

        try (PrintWriter rutasWriter = new PrintWriter(new FileWriter("rutas.csv"));
             PrintWriter aisladosWriter = new PrintWriter(new FileWriter("aislados.csv"))) {

            for (String[] avionAero : avionesAeropuertos) {
                String codigoAeropuerto = avionAero[0];
                String codigoAvion = avionAero[1];
                Avion avion = aviones.get(codigoAvion);
                Aeropuerto aeropuertoOrigen = aeropuertos.get(codigoAeropuerto);

                boolean aislado = true;

                for (Aeropuerto aeropuertoDestino : aeropuertos.values()) {
                    if (!aeropuertoOrigen.codigo.equals(aeropuertoDestino.codigo)) {
                        double distancia = DistanceCalculator.calculateDistance(
                                aeropuertoOrigen.latitud, aeropuertoOrigen.longitud,
                                aeropuertoDestino.latitud, aeropuertoDestino.longitud);
                        if (distancia <= avion.alcance) {
                            rutasWriter.println(avion.codigoIATA + " - " + avion.nombreModelo + "," + aeropuertoOrigen.codigo + " - " + aeropuertoOrigen.nombre + "," + aeropuertoDestino.codigo + " - " + aeropuertoDestino.nombre);
                            aislado = false;
                        }
                    }
                }

                if (aislado) {
                    aisladosWriter.println(codigoAeropuerto + "," + codigoAvion);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Avion> leerAviones(String filename) {
        Map<String, Avion> aviones = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Omitir la cabecera
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String codigoIATA = data[0];
                    String nombreModelo = data[1];
                    try {
                        double alcance = Double.parseDouble(data[2]);
                        aviones.put(codigoIATA, new Avion(codigoIATA, nombreModelo, alcance));
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en el alcance del avión: " + Arrays.toString(data));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aviones;
    }

    static Map<String, Aeropuerto> leerAeropuertos(String filename) {
        Map<String, Aeropuerto> aeropuertos = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Omitir la cabecera
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String codigo = data[0];
                    String nombre = data[1];
                    try {
                        double latitud = Double.parseDouble(data[5]);
                        double longitud = Double.parseDouble(data[4]);
                        aeropuertos.put(codigo, new Aeropuerto(codigo, nombre, latitud, longitud));
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en la latitud o longitud del aeropuerto: " + Arrays.toString(data));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }

    static List<String[]> leerAvionesAeropuertos(String filename) {
        List<String[]> avionesAeropuertos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Omitir la cabecera
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    avionesAeropuertos.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avionesAeropuertos;
    }
}
