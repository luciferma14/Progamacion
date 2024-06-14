public class Calculo{

    private Catalogo catalogo;
    private double precioTotal;

    public Calculo(Catalogo catalogo){
        this.catalogo = catalogo;
    }
        
    @SuppressWarnings("unused")
    public void calcular(String referencia, double volumen) throws Exception {
        Tablon tablon = new Tablon(referencia, 1, 1, 1, volumen);
        if (tablon == null) {
            throw new Exception("No se encuentra la referencia " + referencia);
        }
        int m3 = 1;

        int largo = tablon.largo;
        int ancho = tablon.ancho;
        int alto = tablon.alto;
        int area = largo * ancho;
        double unidades = (m3 * 10^9) / (alto * ancho * largo);
        double precioTotal = unidades * tablon.precio;
        double precioPorM3 = precioTotal * m3;

        this.setPrecioTotal(precioTotal);
        this.setUnidades(unidades);
        this.setPrecioPorM3(precioPorM3);
    }
    
    
    private void setPrecioPorM3(double precioPorM3) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPrecioPorM3'");
    }

    private void setUnidades(double unidades) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUnidades'");
    }

    private void setPrecioTotal(double precioTotal2) {
            
        throw new UnsupportedOperationException("Unimplemented method 'getPrecioTotal'");
    }

    public double getUnidades() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUnidades'");
    }

    public double getPrecioTotal() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getPrecioTotal'");
    }

    public double getPrecioPorM3() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPrecioPorM3'");
    }

    public class Tablon {

        private String referencia;   
        private int largo;    
        private int ancho;   
        private int alto;
        private double precio;
    
        public Tablon(String referencia, int largo, int ancho, int alto, double precio) {
    
            this.referencia = referencia;
            this.largo = largo;
            this.ancho = ancho;
            this.alto = alto;
            this.precio = precio;
        }
    }
}