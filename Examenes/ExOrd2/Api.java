package ExOrd2;

import java.nio.file.*;
import java.util.*;

public class Api {
    public static List<String> leerDocs(String arch) throws Exception {
        return Files.readAllLines(Paths.get(arch));
    }
    public static void escribirDoc(String arch, List<String> docs) throws Exception {
        Files.write(Paths.get(arch), docs);
    }
}
