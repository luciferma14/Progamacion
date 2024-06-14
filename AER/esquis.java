/*
 * 
 * Para celebrar el aniversario de la exitosa y extravagante serie televisiva de los noventa Doctor en Alaska se ha organizado una competición invernal en el lejano y maravilloso pueblo de Cicely, Alaska, donde participarán sus estrafalarios vecinos y el médico neoyorquino, judío y urbanita, Dr. Joel Fleischman.

Los productores, cumpliendo con ciertos compromisos publicitarios, han recibido unos esquís que deben repartir entre los participantes, teniendo en cuenta que se esquía mejor cuando la longitud de los esquís es acorde con la altura del esquiador.

En concreto, el responsable de la competición recomienda minimizar la suma de las diferencias (en valor absoluto) entre la altura de cada esquiador y la longitud de los esquís que le han sido asignados. Pero los productores no saben cómo conseguirlo, por lo que te han contratado, poniendo en tus manos el éxito del evento.

Entrada
La entrada consta de una serie de casos de prueba. Para cada caso, primero aparece el número N de esquiadores y esquís que hay que emparejar (entre 1 y 200.000). A continuación aparecen dos líneas con N enteros cada una, la primera con las alturas de los esquiadores y la segunda con las longitudes de los esquís (todos números entre 1 y 1.000.000).

La entrada termina con un caso sin esquiadores.

Salida
Para cada caso de prueba se escribirá una línea con la mínima suma de diferencias entre cada esquiador y sus esquís. Se garantiza que el resultado nunca será mayor que 109.


EJ Entrada
3
10 15 20
16 12 23
2
175 200
140 150
0


Salida
6
85
 
 */







import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class esquis {

    private static Integer menor (ArrayList<Integer> esquis, ArrayList<Integer> perso) {

        Integer menor = 0;

        if (perso.size() == 1) menor = Math.abs(perso.get(0)-esquis.get(0));
        else {

            TreeSet<Integer> menores = new TreeSet<Integer>();
            ArrayList<Integer> perso2 = new ArrayList<Integer>(perso);
            perso2.remove(0);

            for (int i = 0; i < perso.size(); i++) {
                ArrayList<Integer> esquis2 = new ArrayList<Integer>(esquis);
                esquis2.remove(i);
                menores.add(Math.abs(perso.get(0)-esquis.get(i))+menor(esquis2, perso2));
            }
            menor = menores.getFirst();
        }

        return menor;

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int casos = 1;

        while (casos != 0) {

            casos = sc.nextInt();
            if (casos > 0) {

                ArrayList<Integer> esquis = new ArrayList<Integer>();
                for (int i = 1; i <= casos; i++) {
                    esquis.add(sc.nextInt());
                }
                ArrayList<Integer> perso = new ArrayList<Integer>();
                for (int i = 1; i <= casos; i++) {
                    perso.add(sc.nextInt());
                }
                System.out.println(menor(esquis,perso));
            }

        }
    }
}