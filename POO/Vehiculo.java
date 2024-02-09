public class Vehiculo {
    
    public static int vehiculosCreados = 0;
    public static int kilometrosTotales = 0;
    public static int kilometrosRecorridos = 0;

   
    public int anda(int km) {
        vehiculosCreados++;
        kilometrosRecorridos += km;
        kilometrosTotales += km;
        return kilometrosRecorridos;
    }

    public static int getVehiculosCreados() {
        return vehiculosCreados;
    }

    public static int getKilometrosTotales() {
        return kilometrosTotales;
    }

    public static int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }
    
}   
