package kaarylepelitestit;

import kaarylepeli.Osa;
import kaarylepeli.Puolukka;
import kaarylepeli.Kaaryle;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class kaarylepeliTest {

    Puolukka puolukka;
    Kaaryle kaaryle;

    @Before
    public void setUp() {
        puolukka = new Puolukka();
        kaaryle = new Kaaryle();
    }

    @Test
    public void kaaryleenLuominenOnnistuu() {
        Kaaryle uusiKaaryle = new Kaaryle();
        assertFalse(uusiKaaryle == null);
    }

    @Test
    public void puolukanLuominenOnnistuu() {
        Puolukka uusiPuolukka = new Puolukka();
        assertFalse(uusiPuolukka == null);
    }

    @Test
    public void puolukassaOikeaMaaraOsia() {
        int puolukanOsia = puolukka.haeOsat().size();
        assertTrue(puolukanOsia == 9);
    }

    @Test
    public void kaaryleessaOikeaMaaraOsia() {
        int kaaryleenOsia = kaaryle.haeOsat().size();
        assertTrue(kaaryleenOsia == 50);
    }

    @Test
    public void osanLisaysKasvattaaHahmonOsienMaaraa() {
        puolukka.lisaaOsa(new Osa(4, 4));
        int puolukanOsia = puolukka.haeOsat().size();
        assertTrue(puolukanOsia == 10);
    }

    @Test
    public void osanToStringMetodiOnOikeinMuotoiltu() {
        Osa osa = new Osa(4, 6);
        assertEquals(osa.toString(), "(4,6)");
    }

    @Test
    public void osienOsuminenToisiinsaHuomataan() {
        Osa osa1 = new Osa(3, 9);
        Osa osa2 = new Osa(3, 9);
        assertTrue(osa1.osuu(osa2));
    }

    @Test
    public void hahmoLiikkuuAlaspain() {
        kaaryle.liikuAlas();
        kaaryle.liikuAlas();
        kaaryle.liikuAlas();
        assertFalse(kaaryle.osuu(puolukka));
    }

      @Test
    public void hahmoLiikkuuOikealle() {
        kaaryle.liikuOikealle();
        kaaryle.liikuOikealle();
        kaaryle.liikuOikealle();
        assertFalse(kaaryle.osuu(puolukka));
    }

    @Test
    public void hahmojenOsumatHuomataan() {
        assertTrue(puolukka.osuu(kaaryle));
    }

}
