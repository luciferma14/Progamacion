package PracticaExamenes.InternetRandom;

import java.util.Scanner;

public class CantDigitos {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num;
        String numero;

        do {
            num = sc.nextInt();
            numero = Integer.toString(num);
            System.out.println(numero.length());

        }while(!numero.equals("0"));
    }
}