package kaarylepeli.rakennusosat;

import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Osa;
import kaarylepeli.rakennusosat.Hahmo;
import static kaarylepeli.rakennusosat.Suunta.*;

/**
 * Puolukka koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Puolukka extends Hahmo {

    public Puolukka(int lahtopisteX, int kentanKorkeus) {
        super();
        luoPuolukka(lahtopisteX, kentanKorkeus);
    }

    /**
     * Metodia kutsutaan konstruktorista, ja se luo uudelle puolukalle osat.
     * Metodissa annetaan lähtöpisteen x-koordinaatti puolukan sijainti
     * y-akselilla riippuu kentän ja muusin korkeudesta.
     *
     * @param lahtopisteX Käyttäjän määrittelemä lähtöpiste
     * @param kentanKorkeus Pelikentälle asetettu korkeus
     */
    public void luoPuolukka(int lahtopisteX, int kentanKorkeus) {

        for (int x = lahtopisteX; x < (lahtopisteX + 30); x++) {

            for (int y = (kentanKorkeus - 80); y < (kentanKorkeus - 50); y++) {  //vakiot asettavat puolukan oikeaan kohtaan
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }
}
