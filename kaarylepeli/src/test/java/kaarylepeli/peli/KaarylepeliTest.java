package kaarylepeli.peli;

import java.io.IOException;
import kaarylepeli.gui.Paivitettava;
import kaarylepeli.gui.Piirtaja;
import kaarylepeli.rakennusosat.Osa;
import kaarylepeli.rakennusosat.Puolukka;
import kaarylepeli.rakennusosat.Kaaryle;
import kaarylepeli.rakennusosat.Suunta;
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
    public void paivitettavanAsetusToimii() throws IOException {
        Piirtaja paivi = new Piirtaja(peli);
        peli.asetaPaivitettava(paivi);
        assertNotNull(peli.haePaivitettava());
    }

    @Test
    public void aluksiEiOleEnnatysta() {
        assertFalse(peli.tuliEnnatys());
    }

    @Test
    public void aluksiHuippupisteetNolla() {
        assertEquals(peli.haeHuippupisteet(), 0);
    }

    @Test
    public void huippuPisteidenTallennusOnnistuu() {
        peli.tallennaHuippupisteet(5);
        assertEquals(peli.haeHuippupisteet(), 5);
    }

    @Test
    public void ainaParemmatPisteetTallentuuHuippupisteiksi() {
        peli.tallennaHuippupisteet(5);
        peli.tallennaHuippupisteet(10);
        assertEquals(peli.haeHuippupisteet(), 10);
    }

    @Test
    public void josAloitetaanUusiPeliEnnatysSailyy() {
        peli.tallennaHuippupisteet(5);
        peli.aloitaUusiPeli();
        assertEquals(peli.haeHuippupisteet(), 5);
    }

    @Test
    public void josAloitetaanUusiPeliPisteitaEiOle() {
        assertEquals(peli.haePisteet(), 0);
    }

    @Test
    public void josAloitetaanUusiPeliPuolukoitaOnViisi() {
      //  peli.lisaaPuolukka();
        peli.aloitaUusiPeli();
        assertEquals(peli.haePuolukat().size(), 5);
    }

    @Test
    public void josAloitetaanUusiPeliPeliOnKaynnissa() {
        peli.aloitaUusiPeli();
        assertTrue(peli.peliJatkuu());
    }

    @Test
    public void josAloitetaanUusiPeliKaaryleOnPaikoillaan() {
        peli.haeKaaryle().asetaSuunta(Suunta.YLOS);
        peli.haeKaaryle().liiku(5);
        peli.aloitaUusiPeli();
        assertTrue(peli.haeKaaryle().onMaassa());
    }

    @Test
    public void josUudetPisteetOnSamatKuinHuippuPisteetEiTallenneta() {
        peli.tallennaHuippupisteet(5);
        peli.tallennaHuippupisteet(5);
        assertEquals(peli.haeHuippupisteet(), 5);
    }

}
