package kaarylepeli.peli;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KaarylepeliKaaryleTest {

    Kaarylepeli peli;
    Kaaryle kaaryle;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
        kaaryle = peli.haeKaaryle();
    }

    @Test
    public void kaaryleOnOlemassa() {
        assertNotNull(peli.haeKaaryle());
    }

    @Test
    public void kaaryleOnAluksiMaassa() {
        assertEquals(peli.haeKaaryle().hyppyarvo(), 0);
    }

    @Test
    public void josAloitetaanUusiPeliKaaryleOnPaikoillaan() {
        kaaryle.asetaSuunta(Suunta.YLOS);
        kaaryle.liiku(5);
        peli.aloitaUusiPeli();
        assertTrue(kaaryle.onMaassa());
    }

    @Test
    public void hyppyarvotesti1() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(4);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 20);
        assertEquals(kaaryle.hyppyarvo(), 15);
    }

    @Test
    public void hyppyarvotesti2() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(29);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 20);
        assertEquals(kaaryle.hyppyarvo(), 40);
    }

    @Test
    public void hyppyarvotesti3() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(34);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 10);
        assertEquals(kaaryle.hyppyarvo(), 45);
    }

    @Test
    public void hyppyarvotesti4() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(49);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 10);
        assertEquals(kaaryle.hyppyarvo(), 60);
    }

    @Test
    public void hyppyarvotesti5() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(54);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 5);
        assertEquals(kaaryle.hyppyarvo(), 65);
    }

    @Test
    public void hyppyarvotesti6() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(68);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi - 5);
        assertEquals(kaaryle.hyppyarvo(), 79);
    }

    @Test
    public void hyppyarvotesti7() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(69);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi + 5);
        assertEquals(kaaryle.hyppyarvo(), 80);
    }

    @Test
    public void hyppyarvotesti8() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(74);
        kaaryle.asetaSuunta(Suunta.YLOS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi + 5);
        assertEquals(kaaryle.hyppyarvo(), 85);
    }

    @Test
    public void hyppyarvotesti9() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(89);
        kaaryle.asetaSuunta(Suunta.ALAS);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi + 10);
        assertEquals(kaaryle.hyppyarvo(), 100);
    }

    @Test
    public void hyppyarvotesti10() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.asetaSuunta(Suunta.ALAS);
        kaaryle.kasvataHyppyarvoa(94);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi + 10);
        assertEquals(kaaryle.hyppyarvo(), 105);
    }

    @Test
    public void hyppyarvotesti11() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.asetaSuunta(Suunta.ALAS);
        kaaryle.kasvataHyppyarvoa(109);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi + 20);
        assertEquals(kaaryle.hyppyarvo(), 120);
    }

    @Test
    public void hyppyarvotesti12() {
        int kaaryleenYAluksi = kaaryle.haeHahmonY();
        kaaryle.hyppaaIlmaan();
        kaaryle.kasvataHyppyarvoa(-1);
        peli.kaaryleenHyppy();
        assertEquals(kaaryle.haeHahmonY(), kaaryleenYAluksi);
    }
}
