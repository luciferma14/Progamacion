public class Triangulo extends Figura {
    
    private double base;
    private double altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return ((base * altura) / 2);
    }
    @Override
    public double perimetro() {
        return (2 * Math.sqrt(base * base / 4 + altura * altura) + base);
    }
}