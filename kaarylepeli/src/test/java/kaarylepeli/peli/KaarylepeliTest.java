package kaarylepeli.peli;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Timer;
import kaarylepeli.gui.*;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.*;
import static org.junit.Assert.*;
import org.junit.*;

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
    public void paivitettavanAsetusToimii() throws IOException {
        Piirtaja paivi = new Piirtaja(peli);
        peli.asetaPaivitettava(paivi);
        assertNotNull(peli.haePaivitettava());
    }

    @Test
    public void josAloitetaanUusiPeliPeliOnKaynnissa() {
        peli.aloitaUusiPeli();
        assertTrue(peli.peliJatkuu());
    }

    @Test
    public void kuolemanYhteydessaPeliEiJatku() {
        Puolukka puolukka = new Puolukka(50, peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        peli.tarkistaOsumat();
        assertFalse(peli.peliJatkuu());
    }

    @Test
    public void josEiOsumaaPeliJatkuu() {
        peli.tarkistaOsumat();
        assertTrue(peli.peliJatkuu());
    }

}
