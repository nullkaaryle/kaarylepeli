package kaarylepeli.rakennusosat;

/**
 * Muusi koostuu Osista ja toteuttaa luokan Hahmo.
 */
public class Muusi extends Hahmo {

    /**
     * Konstruktori kutsuu Hahmo-luokan konstruktoria. luoMuusi()-metodia
     * kutsutaan konstruktorista.
     *
     * @param lahtopisteX lahtopisteen x-koordinaatti kokonaislukuna
     * @param kentanKorkeus pelikentan korkeus kokonaislukuna
     */
    public Muusi(int lahtopisteX, int kentanKorkeus) {
        super();
        luoMuusi(lahtopisteX, kentanKorkeus);
    }

    /**
     * Metodia kutsutaan konstruktorista, ja se luo uudelle muusille yhden Osat.
     * Metodissa annetaan lähtöpisteen x-koordinaatti. muusin sijainti
     * y-akselilla riippuu kentän ja muusin korkeudesta. Vakiot asettavat muusin
     * oikeaan kohtaan. Koska muusi on ei-interaktiivinen Hahmo, jolla ei ole
     * osumia muiden Hahmojen kanssa, luomme vain muusin vasemman yläkulman
     * piirtämistä varten.
     *
     * @param lahtopisteX käyttäjän määrittelemä lähtöpiste
     * @param kentanKorkeus pelikentälle asetettu korkeus
     */
    public void luoMuusi(int lahtopisteX, int kentanKorkeus) {
        for (int x = lahtopisteX; x < (lahtopisteX + 1); x++) {

            for (int y = (kentanKorkeus - 65); y < (kentanKorkeus - 64); y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }

    }
}
