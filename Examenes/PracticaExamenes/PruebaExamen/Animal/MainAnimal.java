public class MainAnimal {
    
    public static void main(String[] args) {
        
        Gato gato = new Gato();
        Perro perro = new Perro();

        String sonGato;
        String sonPerro;

        sonGato = gato.hacerSonido("Miau");
        sonPerro = perro.hacerSonido("Guau");

        System.out.println("Sonido gato: " + sonGato);
        System.out.println("Sonido perro: " + sonPerro);
    }
}
