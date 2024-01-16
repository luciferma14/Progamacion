public class Ejercicio2 {
        public static void main(String[] args) {
        float a = 8.0f;
        int b = 3;
        char c = '5';
        float resint = (a - b + c);
        float resdouble = (a - b + c);
        System.out.println("a + b + c = "+(a + b + c)+ "resint = "+resint+" resdouble = "+resdouble);
        resint = (2 * b + 3 * (a - c));
        resdouble = (2 * b + 3 * (a - c));
        System.out.println("2 * b + 3 * (a - c) = "+(2 * b + 3 * (a - c))+ "resint = "+resint+" resdouble = "+resdouble);
        resint = (a / b);
        resdouble = (a / b);
        System.out.println("a / b = "+(a / b)+ "resint = "+resint+" resdouble = "+resdouble);
        resint = (a % b);
        resdouble = (a % b);
        System.out.println("a % b = "+(a % b)+ "resint = "+resint+" resdouble = "+resdouble);
        resint = (a / c - 2);
        resdouble = (a / c - 2);
        System.out.println("a / c - 2 = "+ (a / c - 2)+ "resint = "+resint+" resdouble = "+resdouble);
        resint = (a * (c % b));
        resdouble = (a * (c % b));
        System.out.println("a * (c % b) = "+ (a * (c % b))+ "resint = "+resint+"resdouble = "+resdouble);
        resint = ((3 * a - 2 * b) % (2 * a - c));
        resdouble = ((3 * a - 2 * b) % (2 * a - c));
        System.out.println("(3 * a - 2 * b) % (2 * a - c) = "+ ((3 * a - 2 * b) % (2 * a - c))+ "resint = "+resint+"resdouble = "+resdouble);
        resint = ((a - 3 * b) % (c + 2 * a) / (a - c));
        resdouble = ((a - 3 * b) % (c + 2 * a) / (a - c));
        System.out.println("(a - 3 * b) % (c + 2 * a) / (a - c) = "+ ((a - 3 * b) % (c + 2 * a) / (a - c))+ "resint = "+resint+"resdouble = "+resdouble);
        resint = (a - b - c * 2);
        resdouble = (a - b - c * 2);
        System.out.println("a - b - c * 2= "+ (a - b - c * 2)+ "resint = "+resint+"resdouble = "+resdouble);

        }    
    }