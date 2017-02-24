package kaarylepeli.peli;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Puolukka;
import org.junit.*;
import static org.junit.Assert.*;

public class KaarylepeliPuolukkaTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void puolukoitaOnOlemassa() {
        assertFalse(peli.haePuolukat().isEmpty());
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
        int vali = p2.haeHahmonX() - p1.haeHahmonX();
        assertTrue(vali >= 150);
    }

    @Test
    public void puolukatEivatLiianKaukanaToisistaan() {
        Puolukka p1 = peli.haePuolukat().get(0);
        Puolukka p2 = peli.haePuolukat().get(1);
        int vali = p2.haeHahmonX() - p1.haeHahmonX();
        assertTrue(vali <= 150 + 500);
    }

    @Test
    public void josAloitetaanUusiPeliPuolukoitaOnViisi() {
        peli.lisaaPuolukka();
        peli.aloitaUusiPeli();
        assertEquals(peli.haePuolukat().size(), 5);
    }

    @Test
    public void josPuolukkaMeneeYliReunanSeSyntyyUudelleen() {
        Puolukka puolukka = new Puolukka(0, peli.haeKentanKorkeus());
        peli.haePuolukat().clear();
        peli.haePuolukat().add(puolukka);

        for (int i = 0; i < 5; i++) {
            peli.puolukatVyoryvat();
        }
        assertTrue(peli.haePuolukat().get(0).haeHahmonX() > 0);
    }

    @Test
    public void josPuolukkaMeneeTasanReunalleSeSyntyyUudelleen() {
        Puolukka puolukka = new Puolukka(10, peli.haeKentanKorkeus());
        peli.haePuolukat().clear();
        peli.haePuolukat().add(puolukka);

        for (int i = 0; i < 5; i++) {
            peli.puolukatVyoryvat();
        }
        assertTrue(peli.haePuolukat().get(0).haeHahmonX() > 10);
    }

    @Test
    public void josPuolukkaMeneeYliReunanMaaraPysyyOikeana() {
        Puolukka puolukka = new Puolukka(0, peli.haeKentanKorkeus());
        peli.haePuolukat().clear();
        peli.haePuolukat().add(puolukka);

        for (int i = 0; i < 5; i++) {
            peli.puolukatVyoryvat();
        }
        assertEquals(peli.haePuolukat().size(), 1);
    }

}
