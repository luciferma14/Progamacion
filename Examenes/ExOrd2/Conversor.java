package ExOrd2;

import java.util.*;
public class Conversor {

    public static void main(String[] args) {
        
        try {
            List<String> docsIn = Api.leerDocs("docs_in.txt");
            List<String> docsOK = new ArrayList<>();
            List<String> docsKO = new ArrayList<>();

            for (String linea : docsIn){
                if (linea.matches("\\d{8}[A-Z]")){
                    Doc doc = new Doc(linea, null, null);
                    if (Validador.esValido(doc)){
                        Validador.fichero(doc);
                    }else{
                        docsKO.add(linea);
                    }
                }else if (linea.matches("\\d{20},[A-Z0-9]{11}")){
                    if (Algoritmos.validarCCC(linea.split( ",")[0])){
                        docsOK.add("CCC:" + linea.replace(",", "-"));
                    }else {
                        docsKO.add(linea);
                    }
                }else if (linea.matches("\\d{16},\\d{2}/\\d{2}")) {
                    if (Algoritmos.validarTarjeta(linea.split(",")[0])) {
                        docsOK.add("Card:" + linea.replace(",", "-"));
                    } else {
                        docsKO.add(linea);
                    }
                }else {
                    docsKO.add(linea);
                }
            
                Api.escribirDoc("docs_ok.txt", docsOK);
                Api.escribirDoc("docs_ko.txt", docsKO);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}