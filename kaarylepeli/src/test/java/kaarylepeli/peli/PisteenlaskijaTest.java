package kaarylepeli.peli;

import java.util.ArrayList;
import kaarylepeli.peli.Pisteenlaskija;
import kaarylepeli.rakennusosat.Hahmo;
import kaarylepeli.rakennusosat.Puolukka;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PisteenlaskijaTest {

    Pisteenlaskija laskija;
    Kaarylepeli peli;

    @Before
    public void setUp() {
        this.peli = new Kaarylepeli();
        this.laskija = peli.haePisteenlaskija();
    }

    @Test
    public void pisteitaAluksiNolla() {
        assertEquals(laskija.haePisteet(), 0);
    }

    @Test
    public void aluksiEiOleEnnatysta() {
        assertFalse(laskija.tuliEnnatys());
    }

    @Test
    public void aluksiHuippupisteetNolla() {
        assertEquals(laskija.haeHuippupisteet(), 0);
    }

    @Test
    public void pisteidenHakuOnnistuu() {
        assertEquals(laskija.haePisteet(), 0);
    }

    @Test
    public void huippupisteidenHakuOnnistuu() {

    }

    @Test
    public void pisteidenLisaysOnnistuu() {
        laskija.lisaaPisteet(peli.haePuolukat(), 12);
        assertEquals(laskija.haePisteet(), 1);
    }

    @Test
    public void huippuPisteidenTallennusOnnistuu() {
        for (int i = 0; i < 5; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), 12);
        }
        laskija.tallennaHuippupisteet();
        assertEquals(laskija.haeHuippupisteet(), 5);
    }

    @Test
    public void ainaParemmatPisteetTallentuuHuippupisteiksi() {
    }

    @Test
    public void josUudetPisteetOnSamatKuinHuippuPisteetEiTallenneta() {
        for (int i = 0; i < 10; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        laskija.tallennaHuippupisteet();
        peli.aloitaUusiPeli();
        
        for (int i = 0; i < 10; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        laskija.tallennaHuippupisteet();
        assertFalse(laskija.tuliEnnatys());
    }

    @Test
    public void josUudetPisteetOnPienemmatKuinHuippuPisteetEiTallenneta() {
        for (int i = 0; i < 10; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        int pisteet = laskija.haePisteet();
        laskija.tallennaHuippupisteet();

        peli.aloitaUusiPeli();
        for (int i = 0; i < 9; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        laskija.tallennaHuippupisteet();
        assertEquals(laskija.haeHuippupisteet(), 10);
    }

    @Test
    public void puolukanYlittamisestaLisapisteita1() {
        peli.haePuolukat().clear();
        Hahmo puolukka = new Puolukka(50, peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        assertEquals(laskija.haePisteet(), 51);
    }

    @Test
    public void puolukanYlittamisestaLisapisteita2() {
        peli.haePuolukat().clear();
        Puolukka puolukka = new Puolukka(50 + peli.haeVauhti(), peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        assertEquals(laskija.haePisteet(), 51);
    }
    
}
