import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by remco on 29-11-16.
 */
public class FourWeekTest {

    FourWeek fourWeek;
    @Before
    public void setup(){
        fourWeek = new FourWeek();
    }
    
    @Test
    public void checkEersteMaandagVanEersteWeekVanJaar() {

        DateTime date1 =fourWeek.getEersteMaandagVanEersteWeekVanJaar(2009);
        DateTime date2 = new DateTime(2008,12,29,0,0);
        Assert.assertTrue(date1.equals(date2));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2010).equals(new DateTime(2010,1,4,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2011).equals(new DateTime(2011,1,3,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2012).equals(new DateTime(2012,1,2,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2013).equals(new DateTime(2012,12,31,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2014).equals(new DateTime(2013,12,30,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2015).equals(new DateTime(2014,12,29,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2016).equals(new DateTime(2016,1,4,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2017).equals(new DateTime(2017,1,2,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2018).equals(new DateTime(2018,1,1,0,0)));
        Assert.assertTrue(fourWeek.getEersteMaandagVanEersteWeekVanJaar(2019).equals(new DateTime(2018,12,31,0,0)));


    }

    @Test
    public void test4Week(){
        DateTime beginPeriode =fourWeek.getBegin4WekenPeriode(new DateTime(2015, 4, 5, 0, 0));
        Assert.assertTrue(beginPeriode.equals(new DateTime(2015,3,23,0,0)));

    }

    @Test
    public void testVorige(){
        VierWekelijksePeriode eerstePeriode2015 = VierWekelijksePeriode.getVierWekelijksePeriode(2015,1);
        assertEquals(eerstePeriode2015.getVorige().getBeginPeriode(), new DateTime(2014,12,1,0,0));
        assertEquals(VierWekelijksePeriode.getVierWekelijksePeriode(2016,1).getVorige().getBeginPeriode(), new DateTime(2015,11,30,0,0));
    }

    @Test
    public void testPeriodes(){
        for (int jaar= 2010; jaar <2021; jaar++){
            fourWeek.printPeriodes(jaar);
        }
    }
}