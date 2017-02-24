package kaarylepeli.gui;

import java.awt.Container;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Kayttoliittyma-luokan konstruktori. Aluksi kehystä ja piirtäjää ei ole
     * asetettu.
     *
     * @param peli Kaarylepeli luokan ilmentymä
     */
    public Kayttoliittyma(Kaarylepeli peli) {
        this.kaarylepeli = peli;
        this.kehys = null;
        this.piirtaja = null;
    }

    /**
     * Metodin avulla haetaan käyttöliittymän JFrame. Palauttaa null, jos ei
     * asetettu.
     *
     * @return palauttaa JFrame-kehyksen
     */
    public JFrame haeKehys() {
        return this.kehys;
    }

    /**
     * Metodin avulla haetaan käyttöliittymän Paivettava-rajapinnan toteuttava
     * olio. Palauttaa null, jos ei asetettu.
     *
     * @return palauttaa Piirtaja-olion
     */
    public Paivitettava haePaivitettava() {
        return this.piirtaja;
    }

    /**
     * Luo ja asettaa kehyksen eli pelin näkyväksi. Kuvatiedostojen lukijan
     * mahdollisesti heittämät virheet napataan tässä.
     */
    @Override
    public void run() {
        this.kehys = new JFrame("Käärylepeli");
        kehys.setSize(this.kaarylepeli.haeKentanLeveys(), this.kaarylepeli.haeKentanKorkeus());
        kehys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kehys.setResizable(false);

        try {
            luoKomponentit(kehys.getContentPane());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ongelma pelikomponenttien luomisessa.", "Virheilmoitus", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Piirtaja.class.getName()).log(Level.SEVERE, null, ex);
        }

        kehys.setVisible(true);
    }

    /**
     * Metodi luo käyttöliittymäkomponentit Piirtaja ja Kuuntelija.
     *
     * @param sisaltaja Container-olio
     * @throws IOException heittaa poikkeuksen eteenpain run()-metodille
     */
    public void luoKomponentit(Container sisaltaja) throws IOException {
        this.piirtaja = new Piirtaja(this.kaarylepeli);
        sisaltaja.add(piirtaja);
        Kuuntelija kuuntelija = new Kuuntelija(this.kaarylepeli);
        this.kehys.addKeyListener(kuuntelija);
    }

}
