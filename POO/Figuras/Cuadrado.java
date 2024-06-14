public class Cuadrado extends Figura {
    
    private double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double area() {
        return (lado * lado) ;
    }
    @Override
    public double perimetro() {
        return (4 * lado);
    }
}