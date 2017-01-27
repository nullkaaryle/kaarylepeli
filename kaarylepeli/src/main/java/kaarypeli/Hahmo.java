package kaarypeli;

import java.util.*;

public abstract class Hahmo {  //Hahmo on Puolukkaa ja Kääryletta yhdistävä abstrakti luokka, yksi hahmo koostuu useasta osasta.

    private List<Osa> osat;

    public Hahmo() {
        this.osat = new ArrayList<Osa>();
    }

    public List<Osa> haeOsat() {
        return this.osat;
    }
    
    public void lisaaOsa(Osa uusiOsa) {
        this.osat.add(uusiOsa);
    }

    public boolean osuu(Hahmo hahmo) {
        for (Osa osa : this.osat) {

            for (Osa hahmonOsa : hahmo.haeOsat()) {

                if (osa.osuu(hahmonOsa)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public void liikuVasemmalle() {      //koordinaattien tarkistus puuttuu tässä vaiheessa!
        for (Osa osa : this.osat) {
            int x = osa.haeOsanX();
            int uusiX = x - 1;
            osa.asetaOsanX(uusiX);
        }
    }

    public void liikuYlos() {           //koordinaattien tarkistus puuttuu tässä vaiheessa
        for (Osa osa : this.osat) {
            int y = osa.haeOsanY();
            int uusiY = y - 1;
            osa.asetaOsanY(uusiY);
        }
    }

    public void liikuAlas() {           //koordinaattien tarkistus puuttuu tässä vaiheessa
        for (Osa osa : this.osat) {
            int y = osa.haeOsanY();
            int uusiY = y + 1;
            osa.asetaOsanY(uusiY);
        }

    }


}
