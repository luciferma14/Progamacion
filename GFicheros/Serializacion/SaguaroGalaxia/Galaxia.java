import java.io.Serializable;

public class Galaxia implements Serializable{

    public String object;
    public String con;
    public String ra;
    public String dec;
    public String mag;

    public Galaxia (String object, String con, String ra, String dec, String mag){
        this.object = object;
        this.con = con;
        this.ra = ra;
        this.dec = dec;
        this.mag = mag;
   }
}