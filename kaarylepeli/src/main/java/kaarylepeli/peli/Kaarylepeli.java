package kaarylepeli.peli;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import kaarylepeli.gui.Paivitettava;
import kaarylepeli.rakennusosat.*;

public class Kaarylepeli extends Timer implements ActionListener {

    private int korkeus;
    private int leveys;
    private boolean peliJatkuu;
    private Kaaryle kaaryle;
    private ArrayList<Puolukka> puolukat;
    private Paivitettava paivitettava;

    public Kaarylepeli() {
        super(1000, null);  //Timerilta peritty
        this.leveys = 1000;
        this.korkeus = 300;
        this.peliJatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);  //voisi myös käynnistyä, kun pelaaja painaa painiketta
        this.kaaryle = new Kaaryle();
        this.puolukat = luoPuolukat();
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

    //-----------------------------------------------------
    //pelisilmukan hahmotelma
    //tällä hetkellä kentällä vain kaksi liikkuvaa objektia
    //kaaryle ja puolukka
    //eli näyttää siltä kuin puolukka liikkuisi kohti kaaryletta
    //koska kentässä ei ole vielä rullaavaa taustaa
    @Override
    public void actionPerformed(ActionEvent kello) {

        if (peliJatkuu == false) {
            System.out.println("*** Peli loppui! ***");
            this.stop();
            //pistenäyttö + sammutus
            return;
        }

        kaaryleenHyppy();
        puolukatVyoryvat();
        tarkistaOsumat();
        this.paivitettava.paivita();
        this.setDelay(50);
    }

    //------------------------------------------------------------------
    //tällä hetkellä yksi puolukka tapetaan ja luodaan uusi Puolukka-olio
    //jatkossa todennäköisesti useita puolukaita, joita kierrätetään kentän läpi
    //liikkuminen aina oikealta vasemmalle
    //10 yksikköä kerrallaan
    public void puolukatVyoryvat() {
        boolean puolukkaKuoli = false;

        for (Puolukka puolukka : this.puolukat) {
            for (int i = 0; i < 10; i++) {
                puolukka.liikuVasemmalle();
            }

            if (puolukka.haeHahmonX() <= -50) {
                puolukkaKuoli = true;
            }
        }

        if (puolukkaKuoli == true) {
            this.puolukat.remove(0);
            this.puolukat.add(new Puolukka());
        }
    }

    //----------------------------------------------------
    //yksikin puolukka on tappava
    //tällä hetkellä puolukat ovat todellisuudessa neliöitä
    //mutta jatkossa voidaan harkita oikeasti pyöreitä kulmia
    public void tarkistaOsumat() {
        for (Puolukka puolukka : this.puolukat) {

            if (this.kaaryle.osuu(puolukka)) {
                this.peliJatkuu = false;
            }
        }
    }

    //-------------------------------------------------------
    //yhden silmukan aikana jos hyppyarvo ei ole nolla
    //liikutaan 10 yksikköä y-akselilla
    //hyppyarvo pitää kirjaa ollaanko menty jo lakipisteen 100 ohi
    //eli pitääkö liikkua jo alaspäin, ettei mennä avaruuteen
    //jatkossa hahmolla voi olla suunta ja vauhti
    //ja logiikka voidaan eriyttää tästä luokasta
    public void kaaryleenHyppy() {
        int hyppyarvo = this.kaaryle.hyppyarvo();

        if (hyppyarvo > 0 && hyppyarvo < 101) {
            for (int i = 0; i < 10; i++) {
                this.kaaryle.liikuYlos();
            }
            this.kaaryle.kasvataHyppyarvoa(10);
        }

        if (hyppyarvo >= 101) {
            for (int i = 0; i < 10; i++) {
                this.kaaryle.liikuAlas();
            }
            this.kaaryle.kasvataHyppyarvoa(10);
        }

    }

    public void asetaPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public ArrayList<Puolukka> luoPuolukat() {
        ArrayList<Puolukka> puolukkalista = new ArrayList<>();
        //jatkossa arvotaan alkupuolukat ja sijainnit jonkin logiikan mukaan
        //eivät saa olla liian lähellä toisiaan tai liian harvassa
        puolukkalista.add(new Puolukka());
        return puolukkalista;
    }

}
