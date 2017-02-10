package kaarylepeli.rakennusosat;

/**
 * Hahmo-luokan oliot koostuvat Osa-luokan olioista.
 *
 */
public class Osa {  //

    private int x;
    private int y;

    public Osa(int alkuX, int alkuY) {
        this.x = alkuX;
        this.y = alkuY;
    }

    public int haeOsanX() {
        return this.x;
    }

    public int haeOsanY() {
        return this.y;
    }

    public void asetaOsanX(int uusiX) {
        this.x = uusiX;
    }

    public void asetaOsanY(int uusiY) {
        this.y = uusiY;
    }

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
