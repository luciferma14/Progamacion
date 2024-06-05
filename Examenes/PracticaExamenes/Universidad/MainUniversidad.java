import java.util.ArrayList;
import java.util.List;

public class MainUniversidad{

    public static void main(String[] args) {
        
        List<Persona> personas = new ArrayList<>();

        Direccion direc = new Direccion("Pinedo", "Valencia",46910, "España");
        Estudiante estud1 = new Estudiante("Lucia", "Ferrandis", "789456123T", 14);
        Estudiante estud2 = new Estudiante("Alvaro", "Ferrandis", "123456789T", direc, 21);
        Profesor prof1 = new Profesor("Juan", "Garcia", "123456789G", 21);
        Profesor prof2 = new Profesor("Fede", "Garcia", "789456123P", direc, 14);

        personas.add(estud1);
        personas.add(estud2);
        personas.add(prof1);
        personas.add(prof2);

        System.out.println("Estudiante 1: " + estud1.toString());
        System.out.println("Estudiante 2: " + estud2.toString());
        System.out.println("Profesor 1: " + prof1.toString());
        System.out.println("Profesor 1: " + prof2.toString());
    }
}