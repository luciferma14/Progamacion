package lib;

public class Pizzas {
    private String tamaño;
    private String tipo;
    private String estado;

    private static int totalPedidas = 0;
    private static int totalServidas = 0;

    public Pizzas(String tipo, String tamaño){
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.estado = "pedida";
        totalPedidas++;
    }
// -------------------------------------------
    public void sirve(){
        if (estado.equals("pedida")){
            estado = "servida";
            totalServidas++;
        } else {
            System.out.println("Esa pizza ya se ha servido");
        }
    }
// -------------------------------------------
    public static int getTotalPedidas(){
        return totalPedidas;
    }
    public static int getTotalServidas(){
        return totalServidas;
    }
// -------------------------------------------
    public String toString(){
        return String.format("Pizza: %s, %s, %s", tipo, tamaño, estado);
    }
}