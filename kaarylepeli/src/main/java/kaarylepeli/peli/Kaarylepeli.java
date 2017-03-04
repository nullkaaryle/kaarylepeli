package kaarylepeli.peli;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import kaarylepeli.gui.*;
import kaarylepeli.rakennusosat.*;

/**
 * Pelin silmukka. Perii Timer-luokan ja toteuttaa sen myötä ActionListenerin.
 */
public class Kaarylepeli extends Timer implements ActionListener {

    private int korkeus;
    private int leveys;
    private Paivitettava paivitettava;
    private boolean peliJatkuu;
    private int vauhti;
    private Kaaryle kaaryle;
    private List<Hahmo> puolukat;
    private int puolukanvali;
    private Pisteenlaskija pisteenlaskija;
    private List<Muusi> muusit;
    private List<Pilvi> pilvet;

    /**
     * Kaarylepeli-luokan konstruktori. Kutsuu myös Timer-luokan konstruktoria.
     */
    public Kaarylepeli() {
        super(1000, null);
        addActionListener(this);
        setInitialDelay(1000);
        this.leveys = 1000;
        this.korkeus = 300;
        this.paivitettava = null;
        this.peliJatkuu = true;
        this.vauhti = 12;
        this.kaaryle = new Kaaryle();
        this.puolukat = new ArrayList<>();
        this.puolukanvali = 500;
        this.muusit = new ArrayList<>();
        this.pilvet = new ArrayList<>();
        luoPuolukat(5);
        luoMuusit();
        luoPilvet();
        this.pisteenlaskija = new Pisteenlaskija();
    }

    /**
     * Pelisilmukka. Kello käynnistetään Mainissa
     *
     * @param kello automaattinen ajastin
     */
    @Override
    public void actionPerformed(ActionEvent kello) {
        this.paivitettava.paivita();

        if (peliJatkuu == false) {
            this.stop();
            return;
        }

        pilvetLipuvat();
        muusiEtenee();
        kaaryleenHyppy();
        puolukatVyoryvat();
        pisteenlaskija.lisaaPisteet(puolukat, vauhti);
        tarkistaOsumat();
        tarkistaVaikeustaso();
        this.setDelay(50);
    }

    /**
     * Metodin avulla asetetaan kaiken huippupisteitä lukuunottamatta
     * alkutilaan.
     */
    public void aloitaUusiPeli() {
        pisteenlaskija.nollaaPisteetJaEnnatys();
        this.puolukat.clear();
        this.puolukanvali = 500;
        luoPuolukat(5);
        this.muusit.clear();
        luoMuusit();
        this.kaaryle = new Kaaryle();
        this.vauhti = 12;
        this.peliJatkuu = true;
        this.restart();
    }

    /**
     * Metodina avulla haetaan pelikentän leveys.
     *
     * @return palauttaa pelikentän leveyden
     */
    public int haeKentanLeveys() {
        return this.leveys;
    }

    /**
     * Metodin avulla haetaan pelikentän korkeus.
     *
     * @return palauttaa pelikentän korkeuden
     */
    public int haeKentanKorkeus() {
        return this.korkeus;
    }

    /**
     * Metodin avulla saadaan haettua Paivitettavan eli Piirtäjän.
     *
     * @return Paivitettava-rajapinnan täyttävän
     */
    public Paivitettava haePaivitettava() {
        return this.paivitettava;
    }

    /**
     * Asettaa Piirtäjän Käärylepeliin.
     *
     * @param paivitettava rajapinnan Paivittava täyttävä
     */
    public void asetaPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    /**
     * Tämän metodin avulla voi tarkistaa, onko peli päättynyt.
     *
     * @return palauttaa true, jos peli on käynnissä, false, jos peli on
     * päättynyt
     */
    public boolean peliJatkuu() {
        return this.peliJatkuu;
    }

    /**
     * Metodin avulla voidaan hakea Pisteenlaskija.
     *
     * @return Pisteenlaskija-olion
     */
    public Pisteenlaskija haePisteenlaskija() {
        return this.pisteenlaskija;
    }

    /**
     * Metodin avulla voidaan hakea pelin senhetkinen vauhti.
     *
     * @return vauhti kokonaislukuna
     */
    public int haeVauhti() {
        return this.vauhti;
    }

    /**
     * Yksikin puolukka on tappava.
     */
    public void tarkistaOsumat() {
        for (Hahmo puolukka : this.puolukat) {

            if (this.kaaryle.osuu(puolukka)) {
                this.peliJatkuu = false;
                pisteenlaskija.tallennaHuippupisteet();
            }
        }
    }

    /**
     * Vaikeustasoa lisätään pisteiden mukaan puolukoiden väliä lyhentämällä
     * sekä pelin vauhtia lisäämällä.
     */
    public void tarkistaVaikeustaso() {
        if (this.pisteenlaskija.haePisteet() % 1500 == 0) {
            this.vauhti++;
        }

        if (this.pisteenlaskija.haePisteet() % 250 == 0 && this.puolukanvali > 50) {
            this.puolukanvali -= 50;
        }
    }

    /**
     * Metodin avulla haetaan Kaaryle-hahmo.
     *
     * @return palauttaa Kaaryle-olion.
     */
    public Kaaryle haeKaaryle() {
        return this.kaaryle;
    }

    /**
     * Hyppää, mikäli kääryleen jalat ovat ilmassa.
     */
    public void kaaryleenHyppy() {
        if (this.kaaryle.onMaassa() == false) {
            this.kaaryle.hyppaa();
        }
    }

    /**
     * Metodin avulla haetaan lista kaikista Puolukka-hahmoista.
     *
     * @return palauttaa puolukat Listissä.
     */
    public List<Hahmo> haePuolukat() {
        return this.puolukat;
    }

    /**
     * Metodin avulla saadaan selville puolukanvali,jonka avulla maaritetaan
     * uuden puolukan sijainti edelliseen puolukkaan nähden.
     *
     * @return puolukanvalimuuttuja kokonaislukuna
     */
    public int haePuolukanvali() {
        return this.puolukanvali;
    }

    /**
     * Luo puolukat alussa peliin.
     *
     * @param maara konstruktorissa määritelty puolukoiden kokonaismäärä
     */
    public void luoPuolukat(int maara) {
        for (int i = 1; i <= maara; i++) {
            lisaaPuolukka();
        }
    }

    /**
     * Lisaa peliin puolukan ja asettaa sen edeltävän puolukan jälkeen
     * satunnaiselle etäisyydelle. Puolukat eivät saa olla liian lähellä
     * toisiaan tai liian harvassa.
     */
    public void lisaaPuolukka() {
        Random arpoja = new Random();
        int vali = 150 + arpoja.nextInt(this.puolukanvali);
        int edellisenPuolukanX = this.leveys;

        if (!this.puolukat.isEmpty()) {
            int puolukoita = this.puolukat.size();
            edellisenPuolukanX = this.puolukat.get(this.puolukat.size() - 1).haeHahmonX();
        }

        this.puolukat.add(new Puolukka(edellisenPuolukanX + vali, this.korkeus));
    }

    /**
     * Puolukan kuoltua se tapetaan ja luodaan uusi Puolukka-olio tilalle.
     * Liikkuminen aina oikealta vasemmalle, 10 yksikköä kerrallaan.
     */
    public void puolukatVyoryvat() {
        boolean puolukkaKuoli = false;

        for (Hahmo puolukka : this.puolukat) {
            puolukka.liiku(this.vauhti);

            if (puolukka.haeHahmonX() <= -50) {
                puolukkaKuoli = true;
            }
        }

        if (puolukkaKuoli == true) {
            this.puolukat.remove(0);
            lisaaPuolukka();
        }
    }

    /**
     * Metodin avulla haetaan lista kaikista Muusi-hahmoista.
     *
     * @return palauttaa muusit Listissä
     */
    public List<Muusi> haeMuusit() {
        return this.muusit;
    }

    /**
     * Luo muusit alussa peliin. Muusit luodaan piirtämistä varten.
     */
    public void luoMuusit() {
        this.muusit.add(new Muusi(0, this.korkeus));
        this.muusit.add(new Muusi(3000, this.korkeus));
    }

    /**
     * Metodin avulla saadaan muusi liikkumaan, jolloin luodaan vaikutelma
     * juoksevasta Kaaryleesta. Muusin pitää liikkua samaa vauhtia kuin
     * puolukoiden.
     */
    public void muusiEtenee() {
        boolean muusiYliReunan = false;

        for (Hahmo muusi : this.muusit) {
            muusi.liiku(this.vauhti);

            if (muusi.haeHahmonX() <= -3000) {
                muusiYliReunan = true;
            }
        }

        if (muusiYliReunan == true) {
            this.muusit.remove(0);
            this.muusit.add(new Muusi(3000, this.korkeus));
        }
    }

    /**
     * Metodin avulla haetaan lista kaikista Pilvi-hahmoista.
     *
     * @return palauttaa ArrayList:ssa pelin pilvet
     */
    public List<Pilvi> haePilvet() {
        return this.pilvet;
    }

    /**
     * Metodi luo Pilvi-hahmot peliin. Pilvihahmoja on pelissä aina neljä
     * erilaista, ja ne edustavat kukin omaa pilvityyppiään.
     */
    public void luoPilvet() {
        this.pilvet.add(new Pilvi(Pilvityyppi.PIENI));
        this.pilvet.add(new Pilvi(Pilvityyppi.KESKI));
        this.pilvet.add(new Pilvi(Pilvityyppi.ISO));
        this.pilvet.add(new Pilvi(Pilvityyppi.JATTI));
    }

    /**
     * Metodin avulla saadaan pilvet liikkumaan.
     */
    public void pilvetLipuvat() {
        boolean pilviLapiTaivaan = false;
        List<Pilvi> haihtuneet = new ArrayList<>();

        for (Pilvi pilvi : this.pilvet) {
            pilvi.liiku(pilvi.haeVauhti());

            if (pilvi.haeHahmonX() < -150) {
                pilviLapiTaivaan = true;
                haihtuneet.add(pilvi);
            }
        }

        if (pilviLapiTaivaan == true) {

            for (int i = 0; i < haihtuneet.size(); i++) {
                Pilvi haihtunut = haihtuneet.get(i);
                this.pilvet.add(new Pilvi(haihtunut.haePilvityyppi()));
                this.pilvet.remove(haihtunut);
            }
        }

    }

}
