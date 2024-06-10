package ExOrd2;

import java.util.*;

public class Conversor {

    public static void main(String[] args) {
        
        try {
            List<String> docsIn = Api.leerDocs("docs_in.txt");
            List<String> docsOK = new ArrayList<>();
            List<String> docsKO = new ArrayList<>();

            for (String line : docsIn){
                if (line.matches("\\d{8}[A-Z]")){
                    Doc doc = new Doc(line, null, null);
                    if (Validador.esValido(doc)){
                        Validador.fichero(doc);
                    }else{
                        docsKO.add(line);
                    }
                }else if (line.matches("\\d{20},[A-Z0-9]{11}")){
                    if (Algoritmos.validarCCC(line.split( ",")[0])){
                        docsOK.add("CCC:" + line.replace(",", "-"));
                    }else {
                        docsKO.add(line);
                    }
                }else if (line.matches("\\d{16},\\d{2}/\\d{2}")) {
                    if (Algoritmos.validarTarjeta(line.split(",")[0])) {
                        docsOK.add("Card:" + line.replace(",", "-"));
                    } else {
                        docsKO.add(line);
                    }
                }else {
                    docsKO.add(line);
                }
            
                Api.escribirDoc("docs_ok.txt", docsOK);
                Api.escribirDoc("docs_ko.txt", docsKO);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
    
}
