package kaarypeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import kaarypeli.gui.Paivitettava;
import kaarypeli.hahmo.Kaaryle;
import kaarypeli.hahmo.Puolukka;

//Peliluuppi

public class Kaarylepeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Kaaryle kaaryle;
    private Puolukka puolukka;
    private Paivitettava paivitettava;

    public Kaarylepeli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.kaaryle = new Kaaryle(5, 1);
        this.puolukka = new Puolukka(15, 1);
        addActionListener(this);
        setInitialDelay(2000);
    }
    
    public int haeLeveys() {
        return this.leveys;
    }
    
    public int haeKorkeus() {
        return this.korkeus;
    }
    
    public Kaaryle haeKaaryle() {
        return this.kaaryle;
    }
    
    public Puolukka haePuolukka() {
        return this.puolukka;
    }
    
    public void asetaKaaryle(Kaaryle uusiKaaryle) {
        this.kaaryle = uusiKaaryle;
    }
    
    public void asetaPuolukka(Puolukka uusiPuolukka) {
        this.puolukka = uusiPuolukka;
    }
    
    public void asetaPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.kaaryle.liiku();
        this.paivitettava.paivita();
        
        
    }

}
