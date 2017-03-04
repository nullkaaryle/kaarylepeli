package kaarylepeli.rakennusosat;

import java.util.Random;

/**
 * Pilvi koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Pilvi extends Hahmo {

    private Pilvityyppi pilvityyppi;
    private int vauhti;
    private int lahtopisteX;
    private int lahtopisteY;

    /**
     * Konstruktori kutsuu Hahmo-luokan konstruktoria. luoPilvi() -metodia
     * kutsutaan konstruktorista.
     *
     * @param pilvityyppi luetelty tyyppi
     */
    public Pilvi(Pilvityyppi pilvityyppi) {
        super();
        this.pilvityyppi = pilvityyppi;
        this.vauhti = 0;
        this.lahtopisteX = 0;
        this.lahtopisteY = 0;
        luoPilvi();
    }

    /**
     * Luo uuden pilven peliin ja asettaa sille alkuarvot.
     */
    public void luoPilvi() {
        this.asetaArvot();

        for (int x = lahtopisteX; x < (lahtopisteX + 1); x++) {

            for (int y = lahtopisteY; y < (lahtopisteY + 1); y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

    /**
     * Asettaa pilvelle pilvityppin mukaiset ennaltamäärätyt arvot, eli vauhdin
     * ja lähtöpisteen x- ja y-koordinaatin.
     */
    public void asetaArvot() {
        if (this.pilvityyppi == Pilvityyppi.PIENI) {
            this.vauhti = 4;
            this.lahtopisteX = 1000;
            this.lahtopisteY = 30;
        }

        if (this.pilvityyppi == Pilvityyppi.KESKI) {
            this.vauhti = 3;
            this.lahtopisteX = 1200;
            this.lahtopisteY = 50;
        }

        if (this.pilvityyppi == Pilvityyppi.ISO) {
            this.vauhti = 2;
            this.lahtopisteX = 1100;
            this.lahtopisteY = 40;
        }

        if (this.pilvityyppi == Pilvityyppi.JATTI) {
            this.vauhti = 1;
            this.lahtopisteX = 1100;
            this.lahtopisteY = 60;
        }
    }

    /**
     * Metodin avulla saadaan haettua pilven vauhti.
     *
     * @return vauhti kokonaislukuna
     */
    public int haeVauhti() {
        return this.vauhti;
    }

    /**
     * Metodin avulla saadaan haettua pilven enum.
     *
     * @return lueteltu tyyppi Pilvityyppi
     */
    public Pilvityyppi haePilvityyppi() {
        return this.pilvityyppi;
    }

}
