package kaarylepeli.peli;

import kaarylepeli.gui.Paivitettava;
import kaarylepeli.gui.Piirtaja;
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
    
    @Test
    public void pisteitaAluksiNolla() {
        assertEquals(peli.haePisteet(), 0);
    }
    
    @Test
    public void puolukoidenMaaraOikein() {
        assertEquals(peli.haePuolukat().size(), 5);
    }
    
    @Test
    public void puolukkaEiVoiSyntyaToisenEdelle() {
        Puolukka p1 = peli.haePuolukat().get(0);
        Puolukka p2 = peli.haePuolukat().get(1);
        int vali = p2.haeHahmonX() - p1.haeHahmonX();
        assertTrue(vali > 0);
    }
    
    @Test
    public void puolukatEivatLiianLahellaToisiaan() {
        Puolukka p1 = peli.haePuolukat().get(0);
        Puolukka p2 = peli.haePuolukat().get(1);
        int vali = Math.abs(p1.haeHahmonX() - p2.haeHahmonX());
        assertTrue(vali >= 150);
    }
    
    @Test
    public void puolukatEivatLiianKaukanaToisistaan() {
        Puolukka p1 = peli.haePuolukat().get(0);
        Puolukka p2 = peli.haePuolukat().get(1);
        int vali = Math.abs(p1.haeHahmonX() - p2.haeHahmonX());
        assertTrue(vali <= 150 + 500);
    }
    
    
    
    @Test
    public void paivitettavanAsetusToimii() {
        Piirtaja paivi = new Piirtaja(peli);
        peli.asetaPaivitettava(paivi);
        assertNotNull(peli.haePaivitettava());
    }

}
