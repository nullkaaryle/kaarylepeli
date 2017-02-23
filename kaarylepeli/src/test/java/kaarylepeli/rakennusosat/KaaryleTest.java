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
        assertEquals(kaaryleenOsia, 3750);
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
        kaaryle2.liiku(2);
        assertTrue(kaaryle.osuu(kaaryle2));
    }

    @Test
    public void vasemmanYlakulmanOsaLoytyy() {
        Osa kulma = kaaryle.haeVasenYlakulma();
        assertEquals(kulma.toString(), "(50,150)");
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
    public void kaaryleOnAluksiMaassa1() {
        assertEquals(kaaryle.hyppyarvo(), 0);
    }

    @Test
    public void hyppyarvonLisaysOnnistuu() {
        kaaryle.kasvataHyppyarvoa(10);
        assertEquals(kaaryle.hyppyarvo(), 10);
    }

    @Test
    public void hyppyarvonLakipisteOikein() {
        kaaryle.kasvataHyppyarvoa(200);
        assertEquals(kaaryle.hyppyarvo(), 0);
    }

    @Test
    public void hyppyarvonMuutosOikein() {
        kaaryle.kasvataHyppyarvoa(100);
        assertEquals(kaaryle.hyppyarvo(), 100);
    }

    @Test
    public void kaaryleOsaaLiikkua() {
        int kaaryleX = kaaryle.haeHahmonX();
        kaaryle.liiku(10);
        assertEquals(kaaryle.haeHahmonX(), kaaryleX - 10);
    }

    @Test
    public void haeSuuntaToimii() {
        assertEquals(kaaryle.haeSuunta(), Suunta.VASEN);
    }

    @Test
    public void kaaryleenSuunnanAsetusToimii() {
        int xAluksi = kaaryle.haeHahmonX();
        kaaryle.asetaSuunta(Suunta.OIKEA);
        kaaryle.liiku(10);
        assertTrue(xAluksi < kaaryle.haeHahmonX());
    }

    @Test
    public void kaaryleOnAluksiMaassa2() {
        assertTrue(kaaryle.onMaassa());
    }

    @Test
    public void hyppaaIlmaanLisaaHyppyarvoa() {
        kaaryle.hyppaaIlmaan();
        assertEquals(kaaryle.hyppyarvo(), 1);
    }

    @Test
    public void ilmaanHyppaamisenJalkeenEiOllaMaassa() {
        kaaryle.hyppaaIlmaan();
        assertFalse(kaaryle.onMaassa());
    }

    @Test
    public void josOnJoHypattyEiHypataUudelleen() {
        kaaryle.hyppaaIlmaan();
        kaaryle.hyppaaIlmaan();
        assertEquals(kaaryle.hyppyarvo(), 1);
    }

    @Test
    public void hyppyarvoOnLakipisteessa() {
        kaaryle.kasvataHyppyarvoa(140);
        assertTrue(kaaryle.onMaassa());
    }

    @Test
    public void hyppyarvoOnYliLakipisteen() {
        kaaryle.kasvataHyppyarvoa(141);
        assertTrue(kaaryle.onMaassa());
    }
}
