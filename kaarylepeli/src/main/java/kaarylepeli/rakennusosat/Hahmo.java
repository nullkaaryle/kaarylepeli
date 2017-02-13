package kaarylepeli.rakennusosat;

import java.util.*;
import kaarylepeli.peli.Kaarylepeli;
import static kaarylepeli.rakennusosat.Suunta.*;

/**
 * Hahmo on Puolukkaa ja Kääryletta yhdistävä abstrakti luokka, yksi hahmo
 * koostuu useasta osasta. Jatkossa hahmolla voisi olla myös vauhti.
 */
public abstract class Hahmo {

    private List<Osa> osat;
    private Suunta suunta;

    /**
     * Hahmo-luokan konstruktori.
     */
    public Hahmo() {
        this.osat = new ArrayList<Osa>();
        this.suunta = VASEN;
    }

    /**
     * Metodin avulla saadaan haettua hahmon tämän hetkinen suunta.
     *
     * @return palauttaa hahmon suunnan
     */
    public Suunta haeSuunta() {
        return this.suunta;
    }

    /**
     * Metodin avulla saadaan haettua kaikki hahmoon kuuluvat Osa-oliot.
     *
     * @return hahmon osat ArrayList-muodossa
     */
    public List<Osa> haeOsat() {
        return this.osat;
    }

    /**
     * Kaarylepeli-luokka kayttaa uuden suunnan asettamista hypyn aikana.
     *
     * @param uusiSuunta pelin määrittelemä suunta kääryleelle
     */
    public void asetaSuunta(Suunta uusiSuunta) {
        this.suunta = uusiSuunta;
    }

    /**
     * Metodi lisaa maaritellyn osan hahmon osalistaan (viimeiseksi).
     *
     * @param uusiOsa uusi Osa joka halutaan lisätä hahmoon
     */
    public void lisaaOsa(Osa uusiOsa) {
        this.osat.add(uusiOsa);
    }

    /**
     * Tarkistaa osuuko tämän Hahmo-olion mikään Osa parametrinä annetun
     * Hahmo-olion osaan.
     *
     * @param hahmo pelin antama toinen Hahmo
     * @return palauttaa true jos hahmot osuvat toisiinsa
     */
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

    /**
     * Liikuttaa hahmoa (kaikkia sen Osia) halutun yksikkömaaran.
     *
     * @param maara pelin syöte
     */
    public void liiku(int maara) {
        if (this.suunta == OIKEA) {
            liikuOikealle(maara);
        }

        if (this.suunta == VASEN) {
            liikuVasemmalle(maara);
        }

        if (this.suunta == ALAS) {
            liikuAlas(maara);
        }

        if (this.suunta == YLOS) {
            liikuYlos(maara);
        }
    }

    /**
     * Liikuttaa hahmoa (kaikkia sen Osia) halutun yksikkömaaran oikealle.
     *
     * @param maara liikumetodista (pelin syöte)
     *
     */
    private void liikuOikealle(int maara) {
        for (int i = 0; i < maara; i++) {

            for (Osa osa : this.osat) {
                int x = osa.haeOsanX();
                int uusiX = x + 1;
                osa.asetaOsanX(uusiX);
            }
        }
    }

    /**
     * Liikuttaa hahmoa (kaikkia sen Osia) halutun yksikkömaaran vasemmalle.
     *
     * @param maara liikumetodista (pelin syöte)
     */
    private void liikuVasemmalle(int maara) {
        for (int i = 0; i < maara; i++) {

            for (Osa osa : this.osat) {
                int x = osa.haeOsanX();
                int uusiX = x - 1;
                osa.asetaOsanX(uusiX);
            }
        }
    }

    /**
     * Liikuttaa hahmoa (kaikkia sen Osia) halutun yksikkömaaran alaspäin.
     *
     * @param maara liikumetodista (pelin syöte)
     */
    private void liikuAlas(int maara) {
        for (int i = 0; i < maara; i++) {

            for (Osa osa : this.osat) {
                int y = osa.haeOsanY();
                int uusiY = y + 1;
                osa.asetaOsanY(uusiY);
            }
        }
    }

    /**
     * Liikuttaa hahmoa (kaikkia sen Osia) halutun yksikkömaaran ylöspäin.
     *
     * @param maara liikumetodista (pelin syöte)
     */
    private void liikuYlos(int maara) {
        for (int i = 0; i < maara; i++) {

            for (Osa osa : this.osat) {
                int y = osa.haeOsanY();
                int uusiY = y - 1;
                osa.asetaOsanY(uusiY);
            }
        }
    }

    /**
     * Metodissa haetaan hahmon vasemman reunan koordinaatit piirtämistä varten.
     *
     * @return palauttaa vasemman yläkulman Osan, jonka avulla hahmo piirretään
     */
    public Osa haeVasenYlakulma() {
        return this.osat.get(0);
    }

    /**
     * Yläkulman avulla saadaan hahmon x-koordinaatti piirtämistä varten.
     *
     * @return palauttaa x-koordinaatin
     */
    public int haeHahmonX() {
        return haeVasenYlakulma().haeOsanX();
    }

    /**
     * Yläkulman avulla saadaan hahmon y-koordinaatti piirtämistä varten.
     *
     * @return palauttaa y-koordinaatin
     */
    public int haeHahmonY() {
        return haeVasenYlakulma().haeOsanY();
    }

}
