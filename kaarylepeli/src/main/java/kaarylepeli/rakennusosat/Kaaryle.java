package kaarylepeli.rakennusosat;

import static kaarylepeli.rakennusosat.Suunta.*;

import kaarylepeli.rakennusosat.Hahmo;

/**
 * Kaaryle koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Kaaryle extends Hahmo {

    private int hyppyarvo;
    private int hypynKorkeus;

    public Kaaryle() {
        super();
        luoKaaryle();
        this.hyppyarvo = 0;
        this.hypynKorkeus = 100;
    }

    /**
     * Metodia kutsutaan konstruktorista, ja se luo uudelle kaaryleelle osat.
     * Kaaryle ei liiku vaakasuorassa. Kaaryle seisoo aina muusin pinnalla
     * kentän vasemmalla puolella ja sen leveys on 50 ja korkeus 100 osaa.
     */
    public void luoKaaryle() {
        for (int x = 50; x < 100; x++) {

            for (int y = 150; y < 250; y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

    /**
     * Hyppyarvo on karkea keino kertoa, onko kaaryle maassa tai pitäisikö sen
     * olla liikkumassa ylös- vai alaspäin
     *
     * @return palauttaa kaaryleen hyppyarvon
     */
    public int hyppyarvo() {
        return this.hyppyarvo;
    }

    /**
     * Kun hyppy on suoritettu, kaaryle on taas maassa, ja arvoksi asetetaan
     * jälleen 0. Hypyn kesto pelisilmukkoina on 200.
     *
     * @param maara kertoo kuinka paljon kaaryle on liikkunut
     */
    public void kasvataHyppyarvoa(int maara) {
        this.hyppyarvo += maara;

        if (this.hyppyarvo >= (this.hypynKorkeus * 2)) {
            this.hyppyarvo = 0;
        }
    }

}
