
public abstract class Vehiculos {
    
    private static int vehiculosCreados;
    private static int kilometrosTotales;
    private int kilometrosRecorridos;

    public static int vehiculosCreados(){
        return vehiculosCreados;
    }

    public static int kilometrosTotales(){
        return kilometrosTotales;
    }

    public int kilometrosRecorridos(){
        return kilometrosRecorridos;
    }

    public int anda(int km){
        kilometrosRecorridos += km;
        kilometrosTotales += km;
        vehiculosCreados++;
        return kilometrosRecorridos;
    }
}
