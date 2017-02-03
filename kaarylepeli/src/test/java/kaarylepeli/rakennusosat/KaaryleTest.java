package kaarylepeli.rakennusosat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaaryleTest {

    Kaaryle kaaryle;

    @Before
    public void setUp() {
        kaaryle = new Kaaryle();
    }

    @Test
    public void kaaryleenLuominenOnnistuu() {
        assertNotNull(kaaryle);
    }

    @Test
    public void kaaryleessaOnOsia() {
        int kaaryleenOsia = kaaryle.haeOsat().size();
        assertFalse(kaaryleenOsia == 0);
    }

    @Test
    public void kaaryleessaOikeaMaaraOsia() {
        int kaaryleenOsia = kaaryle.haeOsat().size();
        assertEquals(kaaryleenOsia, 5000);
    }

    @Test
    public void osanLisaysKasvattaaHahmonOsienMaaraa() {
        int osiaAluksi = kaaryle.haeOsat().size();
        kaaryle.lisaaOsa(new Osa(10, 10));
        assertEquals(kaaryle.haeOsat().size(), osiaAluksi + 1);
    }

    @Test
    public void hahmojenOsumatHuomataan() {
        Kaaryle kaaryle2 = new Kaaryle();
        kaaryle2.liikuOikealle();
        assertTrue(kaaryle.osuu(kaaryle2));
    }

    @Test
    public void vasemmanYlakulmanOsaLoytyy() {
        Osa kulma = kaaryle.haeVasenYlakulma();
        assertEquals(kulma.toString(), "(50,175)");
    }

    public void vasemmanYlakulmanYloytyy() {
        Osa kulma = kaaryle.haeVasenYlakulma();
        assertEquals(kulma.haeOsanY(), 175);
    }

    public void vasemmanYlakulmanXloytyy() {
        Osa kulma = kaaryle.haeVasenYlakulma();
        assertEquals(kulma.haeOsanX(), 50);
    }

    @Test
    public void kaaryleOnAluksiMaassa() {
        assertEquals(kaaryle.hyppyarvo(), 0);
    }

    @Test
    public void hyppyarvonLisaysOnnistuu() {
        kaaryle.kasvataHyppyarvoa(10);
        assertEquals(kaaryle.hyppyarvo(), 10);
    }

    @Test
    public void kaaryleLiikkuuAlaspain() {
        int yAluksi = kaaryle.haeHahmonY();
        kaaryle.liikuAlas();
        assertEquals(yAluksi + 1, kaaryle.haeHahmonY());
    }

    @Test
    public void kaaryleLiikkuuYlospain() {
        int yAluksi = kaaryle.haeHahmonY();
        kaaryle.liikuYlos();
        assertEquals(yAluksi - 1, kaaryle.haeHahmonY());
    }

    @Test
    public void kaaryleLiikkuuVasemmalle() {
        int xAluksi = kaaryle.haeHahmonX();
        kaaryle.liikuVasemmalle();
        assertEquals(xAluksi - 1, kaaryle.haeHahmonX());
    }

    @Test
    public void kaaryleLiikkuuOikealle() {
        int xAluksi = kaaryle.haeHahmonX();
        kaaryle.liikuOikealle();
        assertEquals(xAluksi + 1, kaaryle.haeHahmonX());
    }

}
