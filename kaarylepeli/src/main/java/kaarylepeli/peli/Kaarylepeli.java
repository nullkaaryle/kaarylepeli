package kaarylepeli.peli;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import kaarylepeli.gui.Paivitettava;
import kaarylepeli.rakennusosat.*;

/**
 * Pelin silmukka. Perii Timer-luokan ja toteuttaa sen myötä ActionListenerin.
 *
 */
public class Kaarylepeli extends Timer implements ActionListener {

    private int korkeus;
    private int leveys;
    private int pisteet;
    private boolean peliJatkuu;
    private Kaaryle kaaryle;
    private ArrayList<Puolukka> puolukat;
    private Paivitettava paivitettava;

    public Kaarylepeli() {
        super(1000, null);  //Timerilta peritty
        this.leveys = 1000;
        this.korkeus = 300;
        this.pisteet = 0;
        addActionListener(this);
        setInitialDelay(1000);  //voisi myös käynnistyä, kun pelaaja painaa painiketta
        this.kaaryle = new Kaaryle();
        this.puolukat = new ArrayList<>();
        luoPuolukat(5);
        this.peliJatkuu = true;
        this.paivitettava = null;
    }

    public Kaaryle haeKaaryle() {
        return this.kaaryle;
    }

    public ArrayList<Puolukka> haePuolukat() {
        return this.puolukat;
    }

    public boolean peliJatkuu() {
        return this.peliJatkuu;
    }

    public int haeKentanKorkeus() {
        return this.korkeus;
    }

    public int haeKentanLeveys() {
        return this.leveys;
    }

    public int haePisteet() {
        return this.pisteet;
    }

    public Paivitettava haePaivitettava() {
        return this.paivitettava;
    }

    public void asetaPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    /**
     * Pelisilmukka.
     *
     * @param kello
     */
    @Override
    public void actionPerformed(ActionEvent kello) { //kello käynnistyy Mainissa

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
     * Puolukan kuoltua se tapetaan ja luodaan uusi Puolukka-olio tilalle.
     * Liikkuminen aina oikealta vasemmalle, 10 yksikköä kerrallaan.
     */
    public void puolukatVyoryvat() {
        boolean puolukkaKuoli = false;

        for (Puolukka puolukka : this.puolukat) {
            puolukka.liiku(10);

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
     * Yksikin puolukka on tappava.
     */
    public void tarkistaOsumat() {
        for (Puolukka puolukka : this.puolukat) {

            if (this.kaaryle.osuu(puolukka)) {
                this.peliJatkuu = false;
            }
        }
    }

    /**
     * Hyppää. Pitää kirjaa ollaanko menty jo lakipisteen ohi.
     */
    public void kaaryleenHyppy() {
        int hyppyarvo = this.kaaryle.hyppyarvo();

        if (hyppyarvo > 0 && hyppyarvo < 101) {
            this.kaaryle.asetaSuunta(Suunta.YLOS);
            this.kaaryle.liiku(10);
            this.kaaryle.kasvataHyppyarvoa(10);
        }
        if (hyppyarvo >= 101) {
            this.kaaryle.asetaSuunta(Suunta.ALAS);
            this.kaaryle.liiku(10);
            this.kaaryle.kasvataHyppyarvoa(10);
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

    // 
    //
    //
    /**
     * Lisaa peliin puolukan ja asettaa sen edeltävän puolukan jälkeen
     * satunnaiselle etäisyydelle. Puolukat eivät saa olla liian lähellä
     * toisiaan tai liian harvassa.
     */
    public void lisaaPuolukka() {
        Random arpoja = new Random();
        int vali = 150 + arpoja.nextInt(500);
        int edellisenPuolukanX = leveys;

        if (!this.puolukat.isEmpty()) {
            int puolukoita = this.puolukat.size();
            edellisenPuolukanX = this.puolukat.get(this.puolukat.size() - 1).haeHahmonX();
        }

        this.puolukat.add(new Puolukka(edellisenPuolukanX + vali, haeKentanKorkeus()));

    }

}
