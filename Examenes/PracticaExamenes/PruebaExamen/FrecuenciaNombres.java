import java.util.*;

public class FrecuenciaNombres {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una lista de nombres separados por comas: ");
        String entrada = sc.nextLine();
        
        List<String> nombres = Arrays.asList(entrada.split(","));
        Map<String, Integer> frecuencia = new HashMap<>();
        
        for (String nombre : nombres) {
            nombre = nombre.trim();
            frecuencia.put(nombre, frecuencia.getOrDefault(nombre, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : frecuencia.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}