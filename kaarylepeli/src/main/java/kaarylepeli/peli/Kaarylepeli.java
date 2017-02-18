package kaarylepeli.peli;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import kaarylepeli.gui.Kayttoliittyma;
import kaarylepeli.gui.Paivitettava;
import kaarylepeli.gui.Piirtaja;
import kaarylepeli.rakennusosat.*;

/**
 * Pelin silmukka. Perii Timer-luokan ja toteuttaa sen myötä ActionListenerin.
 */
public class Kaarylepeli extends Timer implements ActionListener {

    private int korkeus;
    private int leveys;
    private int pisteet;
    private int huippupisteet;
    private boolean ennatys;
    private boolean peliJatkuu;
    private Kaaryle kaaryle;
    private List<Puolukka> puolukat;
    private Paivitettava paivitettava;

    /**
     * Kaarylepeli-luokan konstruktori. Kutsuu myös Timer-luokan konstruktoria.
     */
    public Kaarylepeli() {
        super(1000, null);
        addActionListener(this);
        setInitialDelay(1000);
        this.paivitettava = null;
        this.leveys = 1000;
        this.korkeus = 300;
        this.kaaryle = new Kaaryle();
        this.puolukat = new ArrayList<>();
        luoPuolukat(5);
        this.peliJatkuu = true;
        this.pisteet = 0;
        this.huippupisteet = 0;
        this.ennatys = false;
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
     * Metodin avulla haetaan lista kaikista Puolukka-hahmoista.
     *
     * @return palauttaa puolukat Listissä.
     */
    public List<Puolukka> haePuolukat() {
        return this.puolukat;
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
     * Metodin avulla haetaan pelikentän korkeus.
     *
     * @return palauttaa pelikentän korkeuden
     */
    public int haeKentanKorkeus() {
        return this.korkeus;
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
     * Metodin avulla voidaan hakea tämän hetkiset pisteet.
     *
     * @return palauttaa pisteet kokonaislukuna
     */
    public int haePisteet() {
        return this.pisteet;
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
     * Metodi hakee tämän pelisession huippupisteet. Lisätty lähinnä testausta
     * varten.
     *
     * @return palauttaa kokonaislukuna huippupisteet
     */
    public int haeHuippupisteet() {
        return this.huippupisteet;
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
     * Pelisilmukka. Kello käynnistetään Mainissa
     *
     * @param kello automaattinen ajastin
     */
    @Override
    public void actionPerformed(ActionEvent kello) {

        if (peliJatkuu == false) {
            this.stop();
            return;
        }
        pisteet++;
        kaaryleenHyppy();
        puolukatVyoryvat();
        tarkistaOsumat();
        this.paivitettava.paivita();
        this.setDelay(50);
    }

    /**
     * Metodin avulla asetetaan Hahmot ja pisteet huippupisteitä lukuunottamatta
     * alkutilaan.
     */
    public void aloitaUusiPeli() {
        this.ennatys = false;
        this.pisteet = 0;
        this.puolukat.clear();
        luoPuolukat(5);
        this.kaaryle = new Kaaryle();
        this.peliJatkuu = true;
        this.restart();
    }

    /**
     * Metodi tarkistaa saiko pelaaja huippupisteet.
     *
     * @param pisteet pelin lopputilanteen pisteet
     */
    public void tallennaHuippupisteet(int pisteet) {
        if (pisteet > this.huippupisteet) {
            this.huippupisteet = pisteet;
            this.ennatys = true;
        }
    }

    /**
     * Yksikin puolukka on tappava.
     */
    public void tarkistaOsumat() {
        for (Puolukka puolukka : this.puolukat) {

            if (this.kaaryle.osuu(puolukka)) {
                this.peliJatkuu = false;
                tallennaHuippupisteet(this.pisteet);

            }
        }
    }

    /**
     * Puolukan kuoltua se tapetaan ja luodaan uusi Puolukka-olio tilalle.
     * Liikkuminen aina oikealta vasemmalle, 10 yksikköä kerrallaan.
     */
    public void puolukatVyoryvat() {
        boolean puolukkaKuoli = false;

        for (Puolukka puolukka : this.puolukat) {
            puolukka.liiku(12);

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
     * Hyppää. Pitää kirjaa ollaanko menty jo lakipisteen ohi.
     */
    public void kaaryleenHyppy() {
        if (this.kaaryle.onMaassa() == false) {

            int hyppyarvo = kaaryle.hyppyarvo();

            if (hyppyarvo > 0 && hyppyarvo <= 30) {
                this.kaaryle.asetaSuunta(Suunta.YLOS);
                this.kaaryle.liiku(20);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

            if (hyppyarvo > 30 && hyppyarvo <= 50) {
                this.kaaryle.liiku(10);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

            if (hyppyarvo > 50 && hyppyarvo < 70) {
                this.kaaryle.liiku(5);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

            if (hyppyarvo >= 70 && hyppyarvo < 90) {
                this.kaaryle.asetaSuunta(Suunta.ALAS);
                this.kaaryle.liiku(5);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

            if (hyppyarvo >= 90 && hyppyarvo < 110) {
                this.kaaryle.liiku(10);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

            if (hyppyarvo >= 110) {
                this.kaaryle.liiku(20);
                this.kaaryle.kasvataHyppyarvoa(10);
            }

        }
    }

    /**
     * Luo puolukat alussa peliin.
     *
     * @param maara kostruktorissa määritelty puolukoiden kokonaismäärä
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
        int vali = 150 + arpoja.nextInt(500);
        int edellisenPuolukanX = this.leveys;

        if (!this.puolukat.isEmpty()) {
            int puolukoita = this.puolukat.size();
            edellisenPuolukanX = this.puolukat.get(this.puolukat.size() - 1).haeHahmonX();
        }

        this.puolukat.add(new Puolukka(edellisenPuolukanX + vali, this.korkeus));

    }

}
