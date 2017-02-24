package kaarylepeli.peli;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private List<Puolukka> puolukat;
    private int puolukanvali;
    private List<Muusi> muusit;
    private int pisteet;
    private int huippupisteet;
    private boolean ennatys;

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
        luoPuolukat(5);
        luoMuusit();
        this.pisteet = 0;
        this.huippupisteet = 0;
        this.ennatys = false;
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

        muusiEtenee();
        kaaryleenHyppy();
        puolukatVyoryvat();
        lisaaPisteet();
        tarkistaOsumat();
        tarkistaVaikeustaso();
        this.setDelay(50);

    }

    /**
     * Metodin avulla asetetaan kaiken huippupisteitä lukuunottamatta
     * alkutilaan.
     */
    public void aloitaUusiPeli() {
        this.ennatys = false;
        this.pisteet = 0;
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
     * Metodin avulla voidaan hakea pelin senhetkinen vauhti.
     *
     * @return vauhti kokonaislukuna
     */
    public int haeVauhti() {
        return this.vauhti;
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
     * Metodi päivittää pistetilanteen. Jos kaaryle on onnistunut hyppäämään
     * puolukan yli, annetaan lisäpisteitä.
     */
    public void lisaaPisteet() {
        pisteet++;

        for (Puolukka puolukka : this.puolukat) {
            if (puolukka.haeHahmonX() >= 50 && puolukka.haeHahmonX() <= (50 + vauhti)) {
                pisteet += 50;
            }
        }
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
     * Vaikeustasoa lisätään pisteiden mukaan puolukoiden väliä lyhentämällä
     * sekä pelin vauhtia lisäämällä.
     */
    public void tarkistaVaikeustaso() {
        if (this.pisteet % 1500 == 0) {
            this.vauhti++;
        }

        if (this.pisteet % 250 == 0 && this.puolukanvali > 50) {
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
     * Metodin avulla haetaan lista kaikista Puolukka-hahmoista.
     *
     * @return palauttaa puolukat Listissä.
     */
    public List<Puolukka> haePuolukat() {
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

        for (Puolukka puolukka : this.puolukat) {
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

        for (Muusi muusi : this.muusit) {
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
}
