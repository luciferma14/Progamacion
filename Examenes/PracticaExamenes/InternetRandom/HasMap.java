import java.util.HashMap;

public class HasMap{
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("Lucia", 1);
        map.put("Alvaro", 2);
        map.put("Anabel", 3);
        map.put("Salva", 4);

        System.out.println(map.get("Lucia"));
    }
}