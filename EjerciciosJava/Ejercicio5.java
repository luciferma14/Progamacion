public class Ejercicio5 {
    public static void main(String[] args) {

        String nombre = "Lucia Ferrandis Martinez";

        int primerespacio = nombre.indexOf(' ');
        int segundoespacio = nombre.indexOf(' ',primerespacio+1);



        System.out.println(nombre.substring(0,primerespacio));
        System.out.println(nombre.substring(primerespacio+1,segundoespacio)); 
        System.out.println(nombre.substring(segundoespacio+1));                
        

    }
}