package lib;

public class Tiempo {

    private int horas;
    private int mins;
    private int segundos;

    public Tiempo(int h, int m, int s) {
        this.horas = h;
        this.mins = m;
        this.segundos = s;
    }

    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
// -------------------------------------------
    public int getMins() {
        return mins;
    }
    public void setMins(int mins) {
        this.mins = mins;
    }
// -------------------------------------------
    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
// -------------------------------------------
    public Tiempo suma(Tiempo h, Tiempo m, Tiempo s){
        int totalHoras = this.horas + h.getHoras();
        int totalMins = this.mins + m.getMins();
        int totalSeg = this.segundos + s.getSegundos();

        //para que las horas, mins y segs no pasen de 60
        totalMins += totalSeg / 60;
        totalSeg %= 60;
        totalHoras += totalMins / 60;
        totalMins %= 60;

        return new Tiempo(totalHoras, totalMins, totalSeg);
    }

    public Tiempo resta(Tiempo h, Tiempo m, Tiempo s){
        int totalHoras = this.horas - h.getHoras();
        int totalMins = this.mins - m.getMins();
        int totalSeg = this.segundos - s.getSegundos();

        //para que los mins y seg no sean negativos
        if (totalSeg < 0) {
            totalMins--;
            totalSeg += 60;
        }
        if (totalMins < 0) {
            totalHoras--;
            totalMins += 60;
        }

        return new Tiempo(totalHoras, totalMins, totalSeg);
    }

    public String toString(){
        return String.format("%02d:%02d:%02d", horas, mins, segundos);
    }

    public int compareTo(Tiempo otroTiempo) {
        if (this.horas != otroTiempo.horas) {
            return this.horas - otroTiempo.horas;
        } else if (this.mins != otroTiempo.mins) {
            return this.mins - otroTiempo.mins;
        } else {
            return this.segundos - otroTiempo.segundos;
        }
    }
}    