/////////////////////////////////////
//ESTE CODIGO NO SE PUEDE MODIFICAR//
/////////////////////////////////////
import java.util.HashMap;

public class Catalogo {

    public static HashMap<String, Tablon> listado() {

        HashMap<String,Tablon> lista = new HashMap<>();

        lista.put("U1", new Tablon(1000,100,10,10));
        lista.put("U2", new Tablon(0,0,10,10));
        lista.put("U3", new Tablon(1100,300,10,15));
        lista.put("U4", new Tablon(1200,400,10,20));
        lista.put("U5", new Tablon(1300,500,10,25));
        lista.put("L1", new Tablon(1000,100,20,10));
        lista.put("L2", new Tablon(0,0,10,10));
        lista.put("L3", new Tablon(1100,300,20,15));
        lista.put("L4", new Tablon(1200,400,20,20));
        lista.put("L5", new Tablon(1300,500,20,25));
        lista.put("H1", new Tablon(1000,100,30,10));
        lista.put("H2", new Tablon(0,0,10,10));
        lista.put("H3", new Tablon(1100,300,30,15));
        lista.put("H4", new Tablon(1200,400,30,20));
        lista.put("H5", new Tablon(1300,500,30,25));

        return lista;

    }

}




