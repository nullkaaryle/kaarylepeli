package kaarylepeli.peli;

import kaarylepeli.rakennusosat.Osa;
import kaarylepeli.rakennusosat.Puolukka;
import kaarylepeli.rakennusosat.Kaaryle;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class kaarylepeliTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void kaaryleOnOlemassa() {
        assertNotNull(peli.haeKaaryle());
    }

    @Test
    public void puolukoitaOnOlemassa() {
        assertFalse(peli.haePuolukat().isEmpty());
    }

    @Test
    public void kaaryleOnAluksiMaassa() {
        assertEquals(peli.haeKaaryle().hyppyarvo(), 0);
    }

}
