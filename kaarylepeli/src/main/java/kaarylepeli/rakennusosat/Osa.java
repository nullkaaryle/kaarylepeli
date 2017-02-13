package kaarylepeli.rakennusosat;

/**
 * Hahmo-luokan oliot koostuvat Osa-luokan olioista.
 */
public class Osa {  //

    private int x;
    private int y;

    /**
     * Osa-luokan konstruktori.
     *
     * @param alkuX Osan x-koordinaatti
     * @param alkuY Osan y-koordinaatti
     */
    public Osa(int alkuX, int alkuY) {
        this.x = alkuX;
        this.y = alkuY;
    }

    /**
     * Metodin avulla haetaan osan koordinaatti.
     *
     * @return palauttaa tämän osan x-koordinaatin
     */
    public int haeOsanX() {
        return this.x;
    }

    /**
     * Metodin avulla haetaan osan koordinaatti.
     *
     * @return palauttaa tämän osan y-koordinaatin
     */
    public int haeOsanY() {
        return this.y;
    }

    /**
     * Metodin avulla saadaan muutettua Osan x-koordinaatin arvo.
     *
     * @param uusiX käyttäjän antama uusi x-koordinaatti
     */
    public void asetaOsanX(int uusiX) {
        this.x = uusiX;
    }

    /**
     * Metodin avulla saadaan muutettua Osan y-koordinaatin arvo.
     *
     * @param uusiY käyttäjän antama uusi y-koordinaatti
     */
    public void asetaOsanY(int uusiY) {
        this.y = uusiY;
    }

    /**
     * Apumetodi koordinaattien tarkistusta varten.
     *
     * @return palauttaa Osan koordinaatit merkkijonona
     */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Tämä metodi tarkistaa, onko kahdella Osalla täsmälleen sama sijainti
     * kentällä eli sama x- ja y-koordinaatti.
     *
     * @param osa Osa jonka koordinaatteja vertaillaan
     * @return palauttaa true, jos nämä kaksi Osaa osuvat toisiinsa
     */
    public boolean osuu(Osa osa) {
        return this.x == osa.haeOsanX()
                && this.y == osa.haeOsanY();
    }

}
