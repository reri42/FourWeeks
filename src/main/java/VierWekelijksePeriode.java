import org.joda.time.DateTime;

/**
 * Created by remco on 29-11-16.
 */
public class VierWekelijksePeriode {

    private int periode;
    private DateTime beginPeriode;
    private DateTime eindePeriode;

    public int getPeriode() {
        return periode;
    }

    public DateTime getBeginPeriode() {
        return beginPeriode;
    }

    public DateTime getEindePeriode() {
        return eindePeriode;
    }

    public VierWekelijksePeriode(int periode, DateTime beginPeriode, DateTime eindePeriode) {
        this.periode = periode;
        this.beginPeriode = beginPeriode;
        this.eindePeriode = eindePeriode;
    }

    public String toString(){
        return "Periode " + periode + "\t"+beginPeriode.toString() + "\t" + eindePeriode.toString();
    }
}
