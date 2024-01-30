package lib;

public class Fraccion {
    
    private int numerador;
    private int denominador;


    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public Fraccion(int num, int den) {
        this.numerador = num;
        this.denominador = den;
    }


    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int MCD(int a, int b) {
        if (b == 0){
            return a;
        }else {
            return MCD(b, a % b);    
        }
    }

    public void Invertir(){
        int invertir;
        invertir = denominador;
        denominador = numerador;
        numerador = invertir;
    }
    public Fraccion Simplificar() {
        int mcd = MCD(numerador, denominador);
        Fraccion fraccionSimplificada = new Fraccion(numerador / mcd, denominador / mcd);
        
        return fraccionSimplificada;
    }
    
    public Fraccion Multiplicar(Fraccion a, Fraccion b){
        Fraccion frac = new Fraccion();
        frac.numerador = a.numerador * b.numerador;
        frac.denominador = a.denominador * b.denominador;
        return frac;
    }
    public Fraccion Dividir(Fraccion a, Fraccion b){
        Fraccion frac = new Fraccion();
        frac.numerador = a.numerador * b.denominador;
        frac.denominador = a.denominador * b.numerador;
        return frac;
    }
}
