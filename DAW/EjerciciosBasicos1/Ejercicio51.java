public class Ejercicio51 {
    public static void main(String[] args) {
        int i = 8;
        int j = 5;
        float x = 0.005f;
        float y = -0.01f;
        char c = 'c';
        char d = 'd';

        System.out.println(!(c == 99));
        System.out.println(!(x > 0));
        System.out.println(c > d || c > 0);
        System.out.println(i <= j && i >= c);
        System.out.println(i > 0 && i < 5);
        System.out.println(i > 0 || j < 5);
        System.out.println(x > y && i > 0 || j < 5);

    }
}