package lib;

public class Pizzas {
    private String mediana = "mediana";
    private String familiar = "familiar";
    private String margarita = "margarita";
    private String cuatroQuesos = "cuatroQuesos";
    private String funghi = "funghi";
    private String pedida;
    private String servida;
/**
   public String TamMediana(String tam){
    return this.mediana = "mediana";
   }
   public String TamFamiliar(String tam){
    return this.familiar = "familiar";
   }
    // -------------------------------------------
   public String TipoMargarita(String tip){
    return this.margarita = "margarita";
   }
   public String TipoCuatroQuesos(String tip){
    return this.cuatroQuesos = "cuatro quesos";
   }
   public String TipoFunghi(String tip){
    return this.funghi = "funghi";
   }
    // -------------------------------------------
   public String EstPedida(String est){
    return this.pedida = "pedida";
   }
   public String EstServida(String est){
    return this.servida = "servida";
   }
    // -------------------------------------------
    public String getMediana() {
        return mediana;
    }
    public void setMediana(String mediana) {
        this.mediana = mediana;
    }
    // -------------------------------------------
    public String getFamiliar() {
        return familiar;
    }
    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }
    // -------------------------------------------
    public String getMargarita() {
        return margarita;
    }
    public void setMargarita(String margarita) {
        this.margarita = margarita;
    }
    // -------------------------------------------
    public String getCuatroQuesos() {
        return cuatroQuesos;
    }
    public void setCuatroQuesos(String cuatroQuesos) {
        this.cuatroQuesos = cuatroQuesos;
    }
    // -------------------------------------------
    public String getFunghi() {
        return funghi;
    }
    public void setFunghi(String funghi) {
        this.funghi = funghi;
    }
*/
// -------------------------------------------
    public String getTotalPedidas() {
        return pedida;
    }
    public void setTotalPedidas(String pedida) {
        this.pedida = pedida;
    }
// -------------------------------------------
    public String getTotalServidas() {
        return servida;
    }
    public void setTotalServidas(String servida) {
        this.servida = servida;
    }
// -------------------------------------------
    public String Sirve(String pizza){
        if (pizza == servida){
            return this.servida;
        }else {
            return this.pedida;
        }
    }




}
