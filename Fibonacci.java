package Recurisividad;
public class Fibonacci {

    public static int fibonacci(int N) {
        int res;
        if (N == 0) {
            res = 0;
        } else if (N == 1) {
            res=1;
        } else {
            res = fibonacci(N - 1) + fibonacci(N - 2);
        }
            return res;
    }

    public static void main (String[] args){

        System.out.println(fibonacci(Integer.valueOf(args[0])));
    }
}