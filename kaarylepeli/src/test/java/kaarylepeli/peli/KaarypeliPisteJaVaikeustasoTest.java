package kaarylepeli.peli;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Puolukka;
import org.junit.*;
import static org.junit.Assert.*;

public class KaarypeliPisteJaVaikeustasoTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void pisteitaAluksiNolla() {
        assertEquals(peli.haePisteet(), 0);
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
    public void josUudetPisteetOnSamatKuinHuippuPisteetEiTallenneta() {
        for (int i = 0; i < 10; i++) {
            peli.lisaaPisteet();
        }
        peli.tallennaHuippupisteet(peli.haePisteet());

        peli.aloitaUusiPeli();
        for (int i = 0; i < 10; i++) {
            peli.lisaaPisteet();
        }
        peli.tallennaHuippupisteet(peli.haePisteet());
        assertFalse(peli.tuliEnnatys());
    }

    @Test
    public void josUudetPisteetOnPienemmatKuinHuippuPisteetEiTallenneta() {
        for (int i = 0; i < 10; i++) {
            peli.lisaaPisteet();
        }
        int pisteet = peli.haePisteet();
        peli.tallennaHuippupisteet(pisteet);

        peli.aloitaUusiPeli();
        for (int i = 0; i < 9; i++) {
            peli.lisaaPisteet();
        }
        pisteet = peli.haePisteet();
        assertEquals(peli.haeHuippupisteet(), 10);
    }

    @Test
    public void pisteidenLisaysOnnistuu() {
        peli.lisaaPisteet();
        assertEquals(peli.haePisteet(), 1);
    }

    @Test
    public void vaikeustasoLisaaVauhtia() {
        int vauhti = peli.haeVauhti();

        for (int i = 0; i < 1500; i++) {
            peli.lisaaPisteet();
        }

        peli.tarkistaVaikeustaso();
        assertTrue(peli.haeVauhti() > vauhti);
    }

    @Test
    public void vaikeustasoPienentaaPuolukanValia() {
        int valiAluksi = peli.haePuolukanvali();

        for (int i = 0; i < 250; i++) {
            peli.lisaaPisteet();
        }

        peli.tarkistaVaikeustaso();
        assertTrue(peli.haePuolukanvali() < valiAluksi);
    }

    @Test
    public void vaikeustasoEiPienennaPuolukanValiaLiikaa() {
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 250; j++) {
                peli.lisaaPisteet();
            }

            peli.tarkistaVaikeustaso();
        }
        assertTrue(peli.haePuolukanvali() >= 50);
    }

    @Test
    public void kuolemanYhteydessaTallennetaanHuippupisteet() {
        peli.lisaaPisteet();
        Puolukka puolukka = new Puolukka(50, peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        peli.tarkistaOsumat();
        assertEquals(peli.haeHuippupisteet(), 1);
    }

    @Test
    public void puolukanYlittamisestaLisapisteita1() {
        peli.haePuolukat().clear();
        Puolukka puolukka = new Puolukka(50, peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        peli.lisaaPisteet();
        assertEquals(peli.haePisteet(), 51);
    }

    @Test
    public void puolukanYlittamisestaLisapisteita2() {
        peli.haePuolukat().clear();
        Puolukka puolukka = new Puolukka(50 + peli.haeVauhti(), peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        peli.lisaaPisteet();
        assertEquals(peli.haePisteet(), 51);
    }

}
