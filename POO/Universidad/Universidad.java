import java.util.ArrayList;

public class Universidad{
    public static void main(String[] args) {

        Direccion direccion1 = new Direccion("Calle 1", "Valencia", "12345", "España");
        Direccion direccion2 = new Direccion("Calle 2", "Madrid", "67890", "España");

        Estudiante estudiante1 = new Estudiante("987654321","Lucía", "Ferrandis", "12345678A", direccion1);
        Estudiante estudiante2 = new Estudiante("123456789", "Álvaro", "Ferrandis", "87654321B");

        Profesor profesor1 = new Profesor("123456789", "Ginés", "Garcia", "11111111X", direccion1);
        Profesor profesor2 = new Profesor("987654321","Vicent", "Tatay", "22222222Y", direccion2);

        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(estudiante1);
        personas.add(estudiante2);
        personas.add(profesor1);
        personas.add(profesor2);

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}