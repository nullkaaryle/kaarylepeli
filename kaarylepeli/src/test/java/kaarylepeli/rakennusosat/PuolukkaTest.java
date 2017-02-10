package kaarylepeli.rakennusosat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PuolukkaTest {

    Puolukka puolukka;

    @Before
    public void setUp() {
        puolukka = new Puolukka(100, 300);
    }

    @Test
    public void puolukanLuominenOnnistuu() {
        assertNotNull(puolukka);
    }

    @Test
    public void puolukassaOnOsia() {
        int puolukanOsia = puolukka.haeOsat().size();
        assertFalse(puolukanOsia == 0);
    }

    @Test
    public void puolukassaOikeaMaaraOsia() {
        int puolukanOsia = puolukka.haeOsat().size();
        assertEquals(puolukanOsia, 900);
    }

    @Test
    public void osanLisaysKasvattaaHahmonOsienMaaraa() {
        int osiaAluksi = puolukka.haeOsat().size();
        puolukka.lisaaOsa(new Osa(10, 10));
        assertEquals(puolukka.haeOsat().size(), osiaAluksi + 1);
    }

    @Test
    public void puolukkaLiikkuuOikeanMaaran() {
        int yAluksi = puolukka.haeHahmonY();
        puolukka.asetaSuunta(Suunta.ALAS);
        puolukka.liiku(5);
        assertEquals(yAluksi + 5, puolukka.haeHahmonY());
    }

    @Test
    public void hahmojenOsumatHuomataan() {
        Puolukka puolukka2 = new Puolukka(100, 300);
        puolukka2.liiku(5);
        assertTrue(puolukka.osuu(puolukka2));
    }

    @Test
    public void vasemmanYlakulmanOsaLoytyy() {
        Osa kulma = puolukka.haeVasenYlakulma();
        assertEquals(kulma.toString(), "(100,220)");
    }

    public void vasemmanYlakulmanYloytyy() {
        Osa kulma = puolukka.haeVasenYlakulma();
        assertEquals(kulma.haeOsanY(), 245);
    }

    public void vasemmanYlakulmanXloytyy() {
        Osa kulma = puolukka.haeVasenYlakulma();
        assertEquals(kulma.haeOsanX(), 970);
    }
    
    @Test
    public void haeSuuntaToimii() {
        assertEquals(puolukka.haeSuunta(), Suunta.VASEN);
    }

}
