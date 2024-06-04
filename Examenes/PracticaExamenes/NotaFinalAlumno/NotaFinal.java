import java.util.Scanner;

public class NotaFinal {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        double nota1;
        double nota2;
        double nota3;
        double porceNota1;
        double porceNota2;
        double porceNota3;
        double media;

        System.out.print("Nota primer examen: ");
        nota1 = sc.nextDouble();
        System.out.print("Nota segundo examen: ");
        nota2 = sc.nextDouble();
        System.out.print("Nota tercer examen: ");
        nota3 = sc.nextDouble();

        porceNota1 = nota1 * 0.25;
        porceNota2 = nota2 * 0.35;
        porceNota3 = nota3 * 0.40;

        media = porceNota1 +  porceNota2 + porceNota3;

        System.out.println("La nota final es un: " + media);
    }
}