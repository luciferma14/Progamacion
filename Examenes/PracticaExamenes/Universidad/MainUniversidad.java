import java.util.ArrayList;
import java.util.List;

public class MainUniversidad {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        Direccion direccion1 = new Direccion("Calle Principal", "Ciudad A", 1234, "País A");
        Estudiante estudiante1 = new Estudiante("Juan", "González", "12345678A", 1001);
        personas.add(estudiante1);
        Estudiante estudiante2 = new Estudiante("María", "López", "87654321B", direccion1, 1002);
        personas.add(estudiante2);
        Profesor profesor1 = new Profesor("Carlos", "Martínez", "98765432C", direccion1, 101);
        personas.add(profesor1);
        Profesor profesor2 = new Profesor("Ana", "Sánchez", "23456789D", direccion1, 101);
        personas.add(profesor2);

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}