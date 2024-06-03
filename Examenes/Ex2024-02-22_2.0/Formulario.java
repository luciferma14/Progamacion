import java.util.ArrayList;

public class Formulario {
    
    private String cliente;
    protected String id;
    private static int totalID;

    public Formulario(String cliente){
        totalID++;
        this.id = ""+ totalID;
        this.cliente = cliente;
    }

    public String getId(){
        return id;
    }

    public String getCliente(){
        return cliente;
    }

    public ArrayList<String> pinta() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("ID: "+id);
        lista.add("Cliente: "+cliente);

        return lista;
    }
}