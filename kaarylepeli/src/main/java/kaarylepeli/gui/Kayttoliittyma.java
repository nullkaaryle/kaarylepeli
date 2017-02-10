package kaarylepeli.gui;

import java.awt.Container;
import javax.swing.*;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Kaaryle;
import kaarylepeli.rakennusosat.Puolukka;

/**
 * Pelin käyttöliittymä, jossa luodaan kehys ja pelin komponentit.
 *
 */
public class Kayttoliittyma implements Runnable {

    private Kaarylepeli kaarylepeli;
    private JFrame kehys;
    private Piirtaja piirtaja;

    public Kayttoliittyma(Kaarylepeli peli) {
        this.kaarylepeli = peli;
        this.kehys = null;
        this.piirtaja = null;
    }

    public JFrame haeKehys() {
        return this.kehys;
    }

    public Paivitettava haePaivitettava() {
        return this.piirtaja;
    }

    /**
     * Luo ja asettaa kehyksen eli pelin näkyväksi.
     */
    @Override
    public void run() {
        this.kehys = new JFrame("Käärylepeli");
        kehys.setSize(this.kaarylepeli.haeKentanLeveys(), this.kaarylepeli.haeKentanKorkeus());
        kehys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kehys.setResizable(false);
        luoKomponentit(kehys.getContentPane());
        kehys.setVisible(true);
    }

    /**
     * Metodi luo käyttöliittymäkomponentit Piirtaja ja Kuuntelija.
     *
     * @param sisaltaja Container-olio
     */
    public void luoKomponentit(Container sisaltaja) {
        this.piirtaja = new Piirtaja(this.kaarylepeli);
        sisaltaja.add(piirtaja);
        Kuuntelija kuuntelija = new Kuuntelija(this.kaarylepeli.haeKaaryle());
        this.kehys.addKeyListener(kuuntelija);
    }

}
