package kaarylepeli.peli;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KaarylepeliMuusiTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void muusejaOnOlemassa() {
        assertFalse(peli.haeMuusit().isEmpty());
    }

    @Test
    public void josAloitetaanUusiPeliMuusin1SijaintiOnOikein() {
        peli.aloitaUusiPeli();
        assertEquals(peli.haeMuusit().get(0).haeHahmonX(), 0);
    }

    @Test
    public void josAloitetaanUusiPeliMuusin2SijaintiOnOikein() {
        peli.aloitaUusiPeli();
        assertEquals(peli.haeMuusit().get(1).haeHahmonX(), 3000);
    }

    @Test
    public void josAloitetaanUusiPeliMuusejaOnKaksi() {
        peli.aloitaUusiPeli();
        assertEquals(peli.haeMuusit().size(), 2);
    }

    @Test
    public void muusiLiikkuuVasemmalle() {
        int muusinXAluksi = peli.haeMuusit().get(0).haeHahmonX();
        peli.muusiEtenee();
        int muusinXNyt = peli.haeMuusit().get(0).haeHahmonX();
        assertTrue(muusinXAluksi > muusinXNyt);
    }

    @Test
    public void muusiLiikkuuSamaaVauhtiaKuinPuolukka() {
        int muusinXAluksi = peli.haeMuusit().get(0).haeHahmonX();
        int puolukanXAluksi = peli.haePuolukat().get(0).haeHahmonX();
        peli.muusiEtenee();
        peli.puolukatVyoryvat();
        int muusinXNyt = peli.haeMuusit().get(0).haeHahmonX();
        int puolukanXNyt = peli.haePuolukat().get(0).haeHahmonX();
        assertEquals(muusinXAluksi - muusinXNyt, puolukanXAluksi - puolukanXNyt);
    }

    @Test
    public void josMuusiMeneeReunanYliSeSyntyyUudelleen() {
        int ekanMuusinXAluksi = peli.haeMuusit().get(0).haeHahmonX();

        for (int i = 0; i < 3010; i++) {
            peli.muusiEtenee();
        }

        int ekanMuusinXLopuksi = peli.haeMuusit().get(1).haeHahmonX();
        assertTrue(ekanMuusinXAluksi < ekanMuusinXLopuksi);
    }

    @Test
    public void josMuusiOnReunassaSeSyntyyUudelleen() {
        peli.haeMuusit().clear();
        peli.haeMuusit().add(new Muusi(-2988, peli.haeKentanKorkeus()));
        peli.muusiEtenee();

        assertTrue(peli.haeMuusit().get(0).haeHahmonX() == 3000);
    }

    @Test
    public void josMuusiEiOleReunassaSitaEiPoisteta() {
        int ekanMuusinXAluksi = peli.haeMuusit().get(0).haeHahmonX();

        for (int i = 0; i < 100; i++) {
            peli.muusiEtenee();
        }

        int ekanMuusinXLopuksi = peli.haeMuusit().get(0).haeHahmonX();
        assertTrue(ekanMuusinXAluksi > ekanMuusinXLopuksi);
    }
}
