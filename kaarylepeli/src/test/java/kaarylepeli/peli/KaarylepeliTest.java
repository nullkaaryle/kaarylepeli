package kaarylepeli.peli;

import kaarylepeli.rakennusosat.Osa;
import kaarylepeli.rakennusosat.Puolukka;
import kaarylepeli.rakennusosat.Kaaryle;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KaarylepeliTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void peliOnAluksiKaynnissa() {
        assertTrue(peli.peliJatkuu());
    }

    @Test
    public void haeKorkeusPalauttaaPositiivisenKokonaisluvun() {
        int korkeus = peli.haeKentanKorkeus();
        assertTrue(korkeus > 0);
    }

    @Test
    public void haeLeveysPalauttaaPositiivisenKokonaisluvun() {
        int leveys = peli.haeKentanLeveys();
        assertTrue(leveys > 0);
    }

    @Test
    public void haeKorkeusEiPalautaLiianKorkeaaKenttaa() {
        int korkeus = peli.haeKentanKorkeus();
        assertTrue(korkeus < 5000);
    }

    @Test
    public void haeLeveysEiPalautaLiianLeveaaKenttaa() {
        int leveys = peli.haeKentanLeveys();
        assertTrue(leveys < 5000);
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
