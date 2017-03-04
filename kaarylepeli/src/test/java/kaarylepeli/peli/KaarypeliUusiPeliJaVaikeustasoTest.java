package kaarylepeli.peli;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Puolukka;
import org.junit.*;
import static org.junit.Assert.*;

public class KaarypeliUusiPeliJaVaikeustasoTest {

    Kaarylepeli peli;
    Pisteenlaskija laskija;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
        laskija = peli.haePisteenlaskija();

        for (int i = 0; i < 5; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }
    }

    @Test
    public void josAloitetaanUusiPeliPisteitaEiOle() {
        peli.aloitaUusiPeli();
        assertEquals(laskija.haePisteet(), 0);
    }

    @Test
    public void josAloitetaanUusiPeliEnnatystaEiOle() {
        peli.aloitaUusiPeli();
        assertFalse(laskija.tuliEnnatys());
    }

    @Test
    public void josAloitetaanUusiPeliHuippupisteetSailyvat() {
        laskija.tallennaHuippupisteet();
        peli.aloitaUusiPeli();
        assertEquals(laskija.haeHuippupisteet(), 5);
    }

    @Test
    public void vaikeustasoLisaaVauhtia() {
        int vauhtiAluksi = peli.haeVauhti();

        for (int i = 0; i < 1495; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        peli.tarkistaVaikeustaso();
        assertTrue(peli.haeVauhti() > vauhtiAluksi);
    }

    @Test
    public void vaikeustasoPienentaaPuolukanValia() {
        int valiAluksi = peli.haePuolukanvali();

        for (int i = 0; i < 245; i++) {
            laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        }

        peli.tarkistaVaikeustaso();
        assertTrue(peli.haePuolukanvali() < valiAluksi);
    }

    @Test
    public void vaikeustasoEiPienennaPuolukanValiaLiikaa() {
        peli.aloitaUusiPeli();
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 250; j++) {
                laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
            }
            peli.tarkistaVaikeustaso();
        }
        assertTrue(peli.haePuolukanvali() >= 50);
    }

    @Test
    public void kuolemanYhteydessaTallennetaanHuippupisteet() {
        peli.aloitaUusiPeli();
        laskija.lisaaPisteet(peli.haePuolukat(), peli.haeVauhti());
        Puolukka puolukka = new Puolukka(50, peli.haeKentanKorkeus());
        peli.haePuolukat().add(puolukka);
        peli.tarkistaOsumat();
        assertEquals(laskija.haeHuippupisteet(), 1);
    }

}
