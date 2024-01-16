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
        System.out.println();

        System.out.println("3ª Pregunta:¿Qué lenguaje estamos viendo en programación?: ");
        System.out.println("a) Python");
        System.out.println("b) Javascript");
        System.out.println("c) Java");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("c")) {
            puntuacion++;
        }
        System.out.println();

        System.out.println("4ª Pregunta:¿Para qué sirve el for?: ");
        System.out.println("a) Para hacer bucles");
        System.out.println("b) Para sacar algo por pantalla");
        System.out.println("c) Para perdir cosas por teclado");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("a")) {
            puntuacion++;
        }    
        System.out.println();

        System.out.println("5ª Pregunta:¿Qué es un int?: ");
        System.out.println("a) Una variable buleana");
        System.out.println("b) Una variable decimal");
        System.out.println("c) Una variable entera");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("c")) {
            puntuacion++;
        }
        System.out.println();

        System.out.println("6ª Pregunta:¿Queé es Visual Studio Code?: ");
        System.out.println("a) Una tienda de cámaras");
        System.out.println("b) Un editor de código");
        System.out.println("c) Un editor de texto");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("b")) {
            puntuacion++;
        }
        System.out.println();

        System.out.println("7ª Pregunta:¿Qué más páginas puedes usar aparte de VS Code?: ");
        System.out.println("a) SciTe");
        System.out.println("b) Code Editor");
        System.out.println("c) Best Code Editor");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("a")) {
            puntuacion++;
        } 
        System.out.println();

        System.out.println("8ª Pregunta:¿A Ginés le gustan los breaks (mientras que no sean en un switch)?: ");
        System.out.println("a) Le encantan!!");
        System.out.println("b) Los puede llegar a soportar");
        System.out.println("c) Los odia >:(");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("c")) {
            puntuacion++;
        }
        System.out.println();

        System.out.println("9ª Pregunta:¿Desde cuándo lleva Ginés programando?: ");
        System.out.println("a) Desde hace 7 años");
        System.out.println("b) Desde que era pequeño");
        System.out.println("c) Desde hace 3 años");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("b")) {
            puntuacion++;
        }
        System.out.println();

        System.out.println("10ª Pregunta:¿Qué dos opciones tiene un boolean?: ");
        System.out.println("a) True/False");
        System.out.println("b) Real/Mentira");
        System.out.println("c) Si/No");
        System.out.print("Respuesta: ");
        respuesta = sc.next();
    
        if (respuesta.contains("a")) {
            puntuacion++;
        }         
        System.out.println("Puntuacion total: " + puntuacion);
    
    
    }
}
