public class EjmArray2 {
    public static void main(String[] args) {

        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};

        for (int i = 0; i <=2; i++){
            for (int j = 0; j <= 2; j++){

                System.out.println(i + "," + j + ":" + matriz [i][j]);
            }
        }
    }
}
