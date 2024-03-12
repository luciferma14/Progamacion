import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextoFich{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String texto;
        Boolean salir = true;

        while (salir){

            try{
                
                System.out.print("Texto: ");
                texto = sc.nextLine();

                if (texto.equals("Salir")){
                    salir = false;
                    System.exit(0);
                }else{
                    FileWriter fich = new FileWriter("fichero2.txt",true);
                    fich.write(texto + "\n");
                    fich.close();
                }
            }catch(IOException e){
                System.out.println("Error");
            }
        }
    }
}