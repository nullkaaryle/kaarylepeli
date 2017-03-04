package kaarylepeli.rakennusosat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PilviTest {

    Pilvi pilvi;

    @Before
    public void setUp() {
        pilvi = new Pilvi(Pilvityyppi.PIENI);
    }

    @Test
    public void pilvenLuominenOnnistuu() {
        assertNotNull(pilvi);
    }

    @Test
    public void pilvenLuomisenJalkeenOnAsetettuVauhti() {
        assertFalse(pilvi.haeVauhti() == 0);
    }

    @Test
    public void pilvenLuomisenJalkeenOnAsetettuLahtopisteX() {
        assertFalse(pilvi.haeHahmonX() == 0);
    }

    @Test
    public void pilvenLuomisenJalkeenOnAsetettuLahtopisteY() {
        assertFalse(pilvi.haeHahmonY() == 0);
    }

    @Test
    public void pilvessaOnOsia() {
        int pilvenosia = pilvi.haeOsat().size();
        assertFalse(pilvenosia == 0);
    }

    @Test
    public void pilvessaOnOikeaMaaraOsia() {
        int pilvenosia = pilvi.haeOsat().size();
        assertEquals(pilvenosia, 1);
    }

    @Test
    public void vasemmanYlakulmanYloytyy() {
        Osa kulma = pilvi.haeVasenYlakulma();
        assertEquals(kulma.haeOsanY(), 30);
    }

    @Test
    public void vasemmanYlakulmanXloytyy() {
        Osa kulma = pilvi.haeVasenYlakulma();
        assertEquals(kulma.haeOsanX(), 1000);
    }

    @Test
    public void haePilvityyppiToimii() {
        assertEquals(pilvi.haePilvityyppi(), Pilvityyppi.PIENI);
    }

    @Test
    public void vauhdinHakuToimii() {
        assertEquals(pilvi.haeVauhti(), 4);
    }

}
