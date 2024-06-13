import java.util.Scanner;
import java.util.TreeSet;

public class AER_312 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> numeros = new TreeSet<Integer>();

        do{
            numeros = new TreeSet<Integer>();
            int num;
            int suma = 0;
            do{
                num = sc.nextInt();
                if (num != 0) {suma += num; numeros.add(num);}
                
            }while(num != 0);
            if (!numeros.isEmpty()){

                int c = numeros.getFirst();
                boolean marca = true;
                
                while(marca){
                    marca = false;
                    for (Integer i : numeros){
                        int result = i % c;
                        if (result != 0){
                            c -= 1;
                            marca = true;
                        }
                    }
                }
                System.out.println(suma / c);
            }
        }while (!numeros.isEmpty());
    }
}
