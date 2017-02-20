package kaarylepeli.rakennusosat;

/**
 * Muusi koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Muusi extends Hahmo {

    /**
     * Konstruktori kutsuu Hahmo-luokan konstruktoria. luoMuusi()-metodia
     * kutsutaan konstruktorista.
     */
    public Muusi(int lahtopisteX, int kentanKorkeus) {
        super();
        luoMuusi(lahtopisteX, kentanKorkeus);
    }

    public void luoMuusi(int lahtopisteX, int kentanKorkeus) {
        for (int x = lahtopisteX; x < (lahtopisteX + 1); x++) {

            for (int y = (kentanKorkeus - 65); y < (kentanKorkeus - 64); y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }

    }
}
