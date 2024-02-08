public class Circulo extends Figura {
    
    private double radio;
    private double PI = 3.14;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double area() {
        return (PI * radio *radio);
    }
    @Override
    public double perimetro() {
        return (2 * PI * radio);
    }
}