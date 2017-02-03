package kaarylepeli.rakennusosat;

import kaarylepeli.rakennusosat.Hahmo;

public class Kaaryle extends Hahmo {  //kaaryle koostuu Osista

    private int hyppyarvo;
    private int hypynKorkeus;

    public Kaaryle() {
        super();
        luoKaaryle();
        this.hyppyarvo = 0;
        this.hypynKorkeus = 100;
    }

    //--------------------------------------
    //kääryle ei ikinä liiku vaakasuorassa
    //alkusijainti määrätään tällä hetkellä tässä luonnin yhteydessä
    public void luoKaaryle() {
        for (int x = 50; x < 100; x++) {

            for (int y = 175; y < 275; y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

    //-----------------------------------------------
    //hyppyarvo on karkea keino kertoa onko kääryle maassa
    //tai pitäisikö sen olla liikkumassa ylös- vai alaspäin
    public int hyppyarvo() {
        return this.hyppyarvo;
    }

    //--------------------------------------------
    //kun hyppy on suoritettu, kaaryle on taas maassa
    //ja arvoksi asetetaan jälleen 0
    //hypyn kesto pelisilmukkoina on tällä hetkellä 200
    public void kasvataHyppyarvoa(int maara) {
        this.hyppyarvo += maara;

        if (this.hyppyarvo >= (this.hypynKorkeus * 2)) {
            this.hyppyarvo = 0;
        }
    }

}
