public class Vehiculo {
    
    private static int vehiculosCreados;
    private static int kilometrosTotales;
    private  int kilometrosRecorridos;

   
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

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }
}   
