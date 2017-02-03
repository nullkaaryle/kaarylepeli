package kaarylepeli.rakennusosat;

import kaarylepeli.rakennusosat.Osa;
import kaarylepeli.rakennusosat.Hahmo;

public class Puolukka extends Hahmo { //puolukka koostuu Osista

    public Puolukka() {
        super();
        luoPuolukka();
    }

    //----------------------------------------------------
    //pelissä on tällä hetkellä vain kerrallaan yksi puolukka,
    //ja uudelle puolukalle määrätään tietty sijainti 
    //aina syntymän yhteydessä
    //mutta jatkossa todennäköisesti useita puolukoita
    //joiden sijainnit arvotaan satunnaisuuden luomiseksi
    public void luoPuolukka() {
        for (int x = 970; x < 1000; x++) {

            for (int y = 245; y < 275; y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

}
