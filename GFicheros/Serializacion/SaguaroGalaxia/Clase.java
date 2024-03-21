import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Clase {

    private static String FichGala = "sag.bin";
    private static ArrayList<Galaxia> gala;

    public static void main(String[] args) {

        HashMap<String, Galaxia> galaxia = new HashMap<>();
        ArrayList<Galaxia> galaxiaList = new ArrayList<>(galaxia.values());
        File file = new File("sag.bin");

        Scanner sc = new Scanner(System.in);
        
        try( FileInputStream fis = new FileInputStream(FichGala);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            boolean finis = true;
            
            while (finis) {
                try {
                    Galaxia gala = (Galaxia) ois.readObject();
                    galaxiaList.add(gala);
                    galaxia.put(gala.object, gala);
                }catch (EOFException e) {
                    finis = false;
                }catch (ClassNotFoundException e){
                    System.out.println("Error");
                }
            }
            ois.close();
            fis.close();
            
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
       
        int opc;
        boolean salir = false;
        String objs;
        Galaxia gala;
        String cons;
        double mag;

        while (!salir){
            System.out.println(" -------Menú-------");
            System.out.println("1 - Nombre del objeto");
            System.out.println("2 - Constelación");
            System.out.println("3 - Magnitud límite");
            System.out.println("4 - Salir");
            System.out.print("Opción: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    try {
                        System.out.print("Objeto: ");
                        objs = sc.next();
                        gala = galaxia.get(objs);
                        System.out.println("OBJECT: " + gala.object);
                        System.out.println("CON: " + gala.con);
                        System.out.println("RA: " + gala.ra);
                        System.out.println("DE: " + gala.dec);
                        System.out.println("MA: " + gala.mag);
                    
                    } catch (Exception e){
                        System.out.println("No existe ese objeto :(");  
                    }
                break;
                case 2:
                    System.out.print("Constelación: ");
                    cons = sc.next();
                    for (int i = 0; i < galaxiaList.size(); i++){
                        Galaxia galax = galaxiaList.get(i);
                        if  (galax.con.equals(cons)){
                            System.out.println("OBJECT: " + galax.object);
                            System.out.println("CON: " + galax.con);
                            System.out.println("RA: " + galax.ra);
                            System.out.println("DE: " + galax.dec);
                            System.out.println("MA: " + galax.mag);
                        }else{
                            System.out.println("No existe esa constelación :(");
                        }
                    }
                break;
                case 3:
                    System.out.print("Magnitud límite: ");
                    mag = sc.nextDouble();
                    try {
                        for (int i = 0; i < galaxiaList.size(); i++){
                            Galaxia galax = galaxiaList.get(i);
                            if  (galax.mag.compareTo(String.valueOf(mag)) <= 0 ){
                                System.out.println("OBJECT: " + galax.object);
                                System.out.println("CON: " + galax.con);
                                System.out.println("RA: " + galax.ra);
                                System.out.println("DE: " + galax.dec);
                                System.out.println("MA: " + galax.mag);
                            }else{
                                System.out.println("No existe esa magnitud :(");
                            }
                        }
                    }catch (Exception e) {
                        System.out.println("El número tiene que llevar ','");
                    }
                    sc.nextLine();
                break;
                case 4:
                    salir = true;
                break;
                default:
                    System.out.println("Opción no válida");
                break;
            }
        }
    }
}