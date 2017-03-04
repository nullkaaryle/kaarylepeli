package kaarylepeli.peli;

import java.util.List;
import kaarylepeli.rakennusosat.*;

/**
 * Pisteenlaskija-luokka auttaa Kaarylepeli-luokkaa ylläpitämällä
 * pistetilannetta ja niihin liittyviä.
 */
public class Pisteenlaskija {

    private int pisteet;
    private int huippupisteet;
    private boolean ennatys;

    /**
     * Pisteenlaskija luokan konstruktori.
     */
    public Pisteenlaskija() {
        this.pisteet = 0;
        this.huippupisteet = 0;
        this.ennatys = false;
    }

    /**
     * Metodin avulla voidaan hakea tämän hetkiset pisteet.
     *
     * @return palauttaa pisteet kokonaislukuna
     */
    public int haePisteet() {
        return this.pisteet;
    }

    /**
     * Metodi hakee tämän pelisession huippupisteet. Lisätty lähinnä testausta
     * varten.
     *
     * @return palauttaa kokonaislukuna huippupisteet
     */
    public int haeHuippupisteet() {
        return this.huippupisteet;
    }

    /**
     * Metodin avulla selviää tuliko päättyneessä pelissä huippupisteet. Pisteet
     * eivät tallennu.
     *
     * @return palauttaa true ensimmäisellä pelikerralla ja jos saadut pisteet
     * olivat huippupisteet
     */
    public boolean tuliEnnatys() {
        return this.ennatys;
    }

    /**
     * Metodi päivittää pistetilanteen. Jos kaaryle on onnistunut hyppäämään
     * puolukan yli, annetaan lisäpisteitä.
     *
     * @param hahmot Lista Hahmoja (esim. puolukoita)
     * @param vauhti pelin vauhti kokonaislukuna
     */
    public void lisaaPisteet(List<Hahmo> hahmot, int vauhti) {
        this.pisteet++;

        for (Hahmo hahmo : hahmot) {
            if (hahmo.haeHahmonX() >= 50 && hahmo.haeHahmonX() <= (50 + vauhti)) {
                this.pisteet += 50;
            }
        }
    }

    /**
     * Metodi tarkistaa saiko pelaaja huippupisteet.
     */
    public void tallennaHuippupisteet() {
        if (this.pisteet > this.huippupisteet) {
            this.huippupisteet = pisteet;
            this.ennatys = true;
        }
    }

    /**
     * Metodin avulla saadaan alustettua pisteet ja ennätystieto, kun aloitetaan
     * uusi peli.
     */
    public void nollaaPisteetJaEnnatys() {
        this.pisteet = 0;
        this.ennatys = false;
    }

}
