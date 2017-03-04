package kaarylepeli.peli;

import kaarylepeli.rakennusosat.Pilvi;
import kaarylepeli.rakennusosat.Pilvityyppi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaarylepeliPilviTest {

    Kaarylepeli peli;

    @Before
    public void setUp() {
        peli = new Kaarylepeli();
    }

    @Test
    public void pilviaOnOlemassA() {
        assertFalse(peli.haePilvet().isEmpty());
    }

    @Test
    public void pilviaOnNelja() {
        assertEquals(peli.haePilvet().size(), 4);
    }

    @Test
    public void pilviLiikkuuVasemmalle() {
        int pilvenXAluksi = peli.haePilvet().get(0).haeHahmonX();
        peli.pilvetLipuvat();
        int pilvenXNyt = peli.haePilvet().get(0).haeHahmonX();
        assertTrue(pilvenXAluksi > pilvenXNyt);
    }

    @Test
    public void josPilviHaihtuuSeSyntyyUudelleen() {
        int ekanPilvenXAluksi = peli.haePilvet().get(0).haeHahmonX();

        for (int i = 0; i < 290; i++) {
            peli.pilvetLipuvat();
        }

        int tokanPilvenXLopuksi = peli.haePilvet().get(0).haeHahmonX();
        assertTrue(ekanPilvenXAluksi > tokanPilvenXLopuksi);
    }

    @Test
    public void pilviHaihtuuVastaKunSitaEiEnaaNay() {
        peli.haePilvet().clear();
        Pilvi pilvi = new Pilvi(Pilvityyppi.JATTI);
        peli.haePilvet().add(pilvi);
        
        for (int i = 0; i < 1250; i++) {
            peli.pilvetLipuvat();
        }
        
        assertEquals(pilvi.haeHahmonX(), -150);
    }
    
    @Test
    public void josPilviOnReunassaSeSyntyyUudelleen() {
        peli.haePilvet().clear();
        Pilvi pilvi = new Pilvi(Pilvityyppi.JATTI);
        peli.haePilvet().add(pilvi);
        
        for (int i = 0; i < 1251; i++) {
            peli.pilvetLipuvat();
        }

        assertTrue(peli.haePilvet().get(0).haeHahmonX() == 1100);
    }
    
     @Test
    public void josPilviiEiOleReunassaSitaEiPoisteta() {
        int ekanPilvenXAluksi = peli.haePilvet().get(0).haeHahmonX();

        for (int i = 0; i < 10; i++) {
            peli.pilvetLipuvat();
        }

        int ekanPilvenXLopuksi = peli.haePilvet().get(0).haeHahmonX();
        assertTrue(ekanPilvenXAluksi > ekanPilvenXLopuksi);
    }
    
    

}
