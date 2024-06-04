

public class Circulo extends Figura {
    
    private double PI = 3.14;
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }
    
    public double area(){
        return (PI * radio * radio);
    }

    public double perimetro(){
        return (2 * PI * radio);
    }
}   