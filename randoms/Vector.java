
import java.util.Scanner;
public class Vector {
public static String[] rellenaVectorStr(int numElem) {
Scanner sc = new Scanner(System.in);
String[] vecStr = new String[numElem];
for (int i = 0; i < numElem; i++) {
System.out.printf("Introduce el elemento %d:",i);
vecStr[i]=sc.nextLine();
}
sc.close();
return vecStr;
}
}