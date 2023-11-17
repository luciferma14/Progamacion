import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EjPE_Extra4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String respuesta ;
        int puntuacion = 0;

       

        
        //List<String> puntuacion = new ArrayList<>(Arrays.asList(arr));

        //for(int i = 0; i<num.length ; i++) {
		//	System.out.print("Dame el "+i+": ");
		//	num[i] =  sc.nextInt();

        System.out.println("1ª Pregunta:¿Quién es el profesor de programación?: ");
        System.out.println("a) Vicent");
        System.out.println("b) Ginés");
        System.out.println("c) Genís");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
        if (respuesta.contains("b")) {
            puntuacion++;
        }else {

        }
        System.out.println();

        System.out.println("2ª Pregunta:¿Cuál es la mejor asignatura?: ");
        System.out.println("a) Programación");
        System.out.println("b) Bases de datos");
        System.out.println("c) Lenguaje de marcas");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("a")) {
            puntuacion++;
        }
        System.out.println("Puntuacion total: " + puntuacion);
    
    
    }
}
