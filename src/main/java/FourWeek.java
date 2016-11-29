import org.joda.time.DateTime;

import java.util.Calendar;

/**
 * Created by remco on 29-11-16.
 */
public class FourWeek {

    public VierWekelijksePeriode getVierWekelijksePeriode(int jaar, int periode){

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
        return new VierWekelijksePeriode(periode,jaar, beginPeriode, eindePeriode);
    }

    public DateTime getBegin4WekenPeriode(DateTime datumStart){

        DateTime eersteMaandag = getEersteMaandagVanEersteWeekVanJaar(datumStart.getYear());

        int periode = 1;
        DateTime beginPeriode = eersteMaandag;
        DateTime eindePeriode = eersteMaandag.plusWeeks(4).minusDays(1);
        while (datumStart.isAfter(eindePeriode)){
            periode++;
            beginPeriode =beginPeriode.plusWeeks(4);
            eindePeriode = eindePeriode.plusWeeks(4);
        }
        if (periode == 1){
            beginPeriode = new DateTime(datumStart.getYear(), 1,1, 0, 0);
        }
        return beginPeriode;
    }

    public void printPeriodes(int jaar){
        for (int periode = 1; periode <14; periode++){
            System.out.println(VierWekelijksePeriode.getVierWekelijksePeriode(jaar, periode).toString());
        }

    }

    public DateTime getEersteMaandagVanEersteWeekVanJaar(int year) {
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


}
