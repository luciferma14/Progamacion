package EstructuraDinamica;

import java.util.Scanner;
import java.util.Stack;

public class CalRPN {

    public static void mostrarPila(Stack<Double> pila) {
        int tam = pila.size();
        Stack<Double> copiaPila = new Stack<>();
        copiaPila.addAll(pila);
    
        for (int i = tam; i > 0; i--) {
            System.out.printf("%02d:    %.2f%n", i, copiaPila.pop());
        }
    
        System.out.println("Q = SALIR");
        System.out.println("OPERACIONES");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Double> pila = new Stack<>();

        boolean salir = false;
        String entrada;

        while (!salir) {
            mostrarPila(pila);
            System.out.print("--> ");
            entrada = sc.nextLine();
        
            if (entrada.equalsIgnoreCase("q")) {
                salir = true;
            } else if (entrada.matches("-?\\d+(\\.\\d+)?")) {
                pila.push(Double.parseDouble(entrada));
            } else {
                if (!pila.isEmpty()) {
                    double num2 = pila.pop();
                    if (!pila.isEmpty()) {
                        double num1 = pila.pop();
                    
                        switch (entrada) {
                            case "+":
                                pila.push(num1 + num2);
                                break;
                            case "*":
                                pila.push(num1 * num2);
                                break;
                            case "/":
                                if (num2 != 0) {
                                    pila.push(num1 / num2);
                                } else {
                                    System.out.println("Error: División por cero");
                                }
                                break;
                            case "-":
                                pila.push(num1 - num2);
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    } else {
                        pila.push(num2); // Devolver el valor a la pila si no hay suficientes operandos
                        System.out.println("No hay suficientes operandos en la pila.");
                    }
                } else {
                    System.out.println("No hay suficientes operandos en la pila.");
                }
            }
        }
    }
}
