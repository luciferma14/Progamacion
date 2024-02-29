public class Pieza{

    private String nombre;
    private String color;
    
    public double area(){
        return 5.0;
    }

    @Override
    public boolean equals(Object o) {

        try{
            Pieza p = (Pieza) o;
            return this.color.equals(p.color) &&
            this.nombre.equals(p.nombre) &&
            this.area() == p.area();
        }catch(ClassCastException e){
            System.out.println("Error: no se puede comparar esos dos valores ");
            return false;
        }
    }

    public Pieza(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
    }
        

    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Pieza p1 = new Pieza("cuadrado","rojo");
        Pieza p2 = new Pieza("cuadrado","rojo");
        Double d = new Double(1.0);
        String k = "Hola";
        boolean b1 = p1.equals(p2);
        boolean b2 = d.equals(k);
        boolean b3 = k.equals(p2);
        boolean b4 = p1.equals(d);
    }
}