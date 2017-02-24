package kaarylepeli.rakennusosat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MuusiTest {

    Muusi muusi;

    @Before
    public void setUp() {
        this.muusi = new Muusi(0, 300);
    }

    @Test
    public void muusinLuominenOnnistuu() {
        assertNotNull(muusi);
    }

    @Test
    public void muusissaOnOsa() {
        int muusinOsia = muusi.haeOsat().size();
        assertFalse(muusinOsia == 0);
    }

    @Test
    public void muusissaOnOikeaMaaraOsia() {
        int muusinOsia = muusi.haeOsat().size();
        assertEquals(muusinOsia, 1);
    }

    @Test
    public void osanLisaysKasvattaaHahmonOsienMaaraa() {
        int osiaAluksi = muusi.haeOsat().size();
        muusi.lisaaOsa(new Osa(10, 10));
        assertEquals(muusi.haeOsat().size(), osiaAluksi + 1);
    }

    @Test
    public void hahmojenOsumatHuomataan() {
        Muusi muusi2 = new Muusi(1, 300);
        muusi2.liiku(1);
        assertTrue(muusi.osuu(muusi2));
    }

    @Test
    public void vasemmanYlakulmanOsaLoytyy() {
        Osa kulma = muusi.haeVasenYlakulma();
        assertEquals(kulma.toString(), "(0,235)");
    }

    public void vasemmanYlakulmanYloytyy() {
        Osa kulma = muusi.haeVasenYlakulma();
        assertEquals(kulma.haeOsanY(), 300);
    }

    public void vasemmanYlakulmanXloytyy() {
        Osa kulma = muusi.haeVasenYlakulma();
        assertEquals(kulma.haeOsanX(), 0);
    }

}
