package kaarylepeli.rakennusosat;

import kaarylepeli.rakennusosat.Hahmo;

/**
 * Kaaryle koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Kaaryle extends Hahmo {

    private int hyppyarvo;
    private int hypynKorkeus;
    private boolean onMaassa;

    /**
     * Konstruktori kutsuu Hahmo-luokan konstruktoria. luoKaaryle()-metodia
     * kutsutaan konstruktorista.
     */
    public Kaaryle() {
        super();
        luoKaaryle();
        this.hyppyarvo = 0;
        this.hypynKorkeus = 70;
        this.onMaassa = true;
    }

    /**
     * Metodia kutsutaan konstruktorista, ja se luo uudelle kaaryleelle osat.
     * Kaaryle ei liiku vaakasuorassa. Kaaryle seisoo aina muusin pinnalla
     * kentän vasemmalla puolella ja sen leveys on 50 ja korkeus 100 osaa.
     */
    public void luoKaaryle() {
        for (int x = 50; x < 100; x++) {

            for (int y = 150; y < 225; y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

    /**
     * Metodin avulla voidaan tarkistaa, voiko seuraava hyppy alkaa.
     *
     * @return palauttaa true jos Kaaryle ei ole hyppäämässä, false jos jalat
     * ovat ilmassa
     */
    public boolean onMaassa() {
        return this.onMaassa;
    }

    /**
     * Metodin avulla hyppääminen alkaa.
     */
    public void hyppaaIlmaan() {
        if (this.hyppyarvo == 0) {
            this.onMaassa = false;
            this.hyppyarvo++;
        }
    }

    /**
     * Metodi asettaa Kaaryleen maahan ja merkitsee hypyn päättyneeksi.
     */
    public void laskeuduMaahan() {
        this.onMaassa = true;
        this.hyppyarvo = 0;
    }

    /**
     * Hyppyarvo on karkea keino kertoa, onko kaaryle maassa tai pitäisikö sen
     * olla liikkumassa ylös- vai alaspäin.
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
            this.laskeuduMaahan();
        }
    }

    /**
     * Suorittaa kääryleen hypyn. Pitää kirjaa, onko menty jo lakipisteen ohi.
     */
    public void hyppaa() {
        int hyppyarvo = hyppyarvo();

        if (hyppyarvo > 0 && hyppyarvo <= 30) {
            asetaSuunta(Suunta.YLOS);
            liiku(20);
            kasvataHyppyarvoa(10);
        }

        if (hyppyarvo > 30 && hyppyarvo <= 50) {
            liiku(10);
            kasvataHyppyarvoa(10);
        }

        if (hyppyarvo > 50 && hyppyarvo < 70) {
            liiku(5);
            kasvataHyppyarvoa(10);
        }

        if (hyppyarvo >= 70 && hyppyarvo < 90) {
            asetaSuunta(Suunta.ALAS);
            liiku(5);
            kasvataHyppyarvoa(10);
        }

        if (hyppyarvo >= 90 && hyppyarvo < 110) {
            liiku(10);
            kasvataHyppyarvoa(10);
        }

        if (hyppyarvo >= 110) {
            liiku(20);
            kasvataHyppyarvoa(10);
        }
    }

}
