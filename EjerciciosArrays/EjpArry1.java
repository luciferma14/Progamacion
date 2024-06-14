public class EjpArry1 {
    public static void main(System[] args) {

        int [] intArray = new int[10];

        for (int i = 0; i < 10; i++) {

            intArray[i] = i + 1;

            System.out.println("Pos " + (i) + ":" + intArray[i]);

        }

        System.out.println("------------");

        for (int i = 9; i < 0; i--) {

            System.out.println("Pos " + (i) + ":" + intArray[i]);
        }

    }
}