package kaarylepeli.rakennusosat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OsaTest {

    Osa osa;

    @Before
    public void setUp() {
        osa = new Osa(10, 10);
    }

    @Test
    public void uudenXkoordinaatinAsetusToimii() {
        osa.asetaOsanX(20);
        assertEquals(osa.haeOsanX(), 20);
    }

    @Test
    public void uudenYkoordinaatinAsetusToimii() {
        osa.asetaOsanY(20);
        assertEquals(osa.haeOsanY(), 20);
    }

    @Test
    public void osanToStringMetodiOnOikeinMuotoiltu() {
        assertEquals(osa.toString(), "(10,10)");
    }

    @Test
    public void osienOsuminenToisiinsaHuomataan() {
        Osa toinenOsa = new Osa(10, 10);
        assertTrue(osa.osuu(toinenOsa));
    }

}
