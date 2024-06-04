

public class Triangulo extends Figura {
    
    private double base;
    private double altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double area(){
        return (base * altura) / 2;
    }

    public double perimetro(){
        double lado = Math.sqrt(Math.pow(base, 2) + Math.pow(altura,2));
        return base + altura + lado;
    }
}