import org.joda.time.DateTime;

/**
 * Created by remco on 29-11-16.
 */
public class VierWekelijksePeriode {

    private int periode;
    private int jaar;
    private DateTime beginPeriode;
    private DateTime eindePeriode;

    public int getJaar() {
        return jaar;
    }

    public int getPeriode() {
        return periode;
    }

    public DateTime getBeginPeriode() {
        return beginPeriode;
    }

    public DateTime getEindePeriode() {
        return eindePeriode;
    }

    public VierWekelijksePeriode(int periode, int jaar, DateTime beginPeriode, DateTime eindePeriode) {
        this.periode = periode;
        this.jaar = jaar;
        this.beginPeriode = beginPeriode;
        this.eindePeriode = eindePeriode;
    }

    public static VierWekelijksePeriode getVierWekelijksePeriode(int jaar, int periode){

        assert(jaar>=2010 && jaar<=2020);
        assert(periode>=1 && periode<=13);
        DateTime eersteMaandag = getEersteMaandagVanEersteWeekVanJaar(jaar);

        int i=1;
        DateTime beginPeriode = eersteMaandag;
        DateTime eindePeriode = eersteMaandag.plusWeeks(4).minusDays(1);
        while (i<periode){
            i++;
            beginPeriode =beginPeriode.plusWeeks(4);
            eindePeriode = eindePeriode.plusWeeks(4);
        }
        if (periode == 1){
            beginPeriode = new DateTime(jaar, 1,1, 0, 0);
        }
        if (periode == 13){
            eindePeriode = new DateTime(jaar, 12,31, 0,0);
        }
        return new VierWekelijksePeriode(periode, jaar, beginPeriode, eindePeriode);
    }

    public VierWekelijksePeriode getVorige(){
        int nieuwePeriode = this.periode-1;
        int nieuwJaar = this.jaar;
        if (this.periode==1){
            nieuwePeriode= 13;
            nieuwJaar = nieuwJaar-1;
        }
        return getVierWekelijksePeriode(nieuwJaar, nieuwePeriode);
    }

    private static DateTime getEersteMaandagVanEersteWeekVanJaar(int year) {
        DateTime eenJanuari = new DateTime(year, 1,1, 0, 0);
        int dagEenJanuari = eenJanuari.getDayOfWeek();
        DateTime eersteDatumPeriode1;
        if (dagEenJanuari<=4){
            // we moeten terug naar 1
            eersteDatumPeriode1 =eenJanuari.minusDays(dagEenJanuari-1);
        } else {
            // we moeten vooruit naar 8
            eersteDatumPeriode1 =eenJanuari.plusDays(8-dagEenJanuari);
        }

        return eersteDatumPeriode1;
    }


    public String toString(){
        return "Periode " + periode + "\t"+beginPeriode.toString() + "\t" + eindePeriode.toString();
    }
}
