import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsuContr{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String usu;
        String contr;
        Boolean salir = true;

        while (salir){

            try{
                
                System.out.print("Usuario: ");
                usu = sc.nextLine();

                if (usu.equals("Salir")){
                    salir = false;
                    System.exit(0);
                }
                System.out.print("Contraseña: ");
                contr = sc.nextLine();

                FileWriter fich = new FileWriter("fichero3.txt",true);
                fich.write(usu + ":" + contr + "\n");
                fich.close();
                
            }catch(IOException e){
                System.out.println("Error");
            }
        }
    }
}