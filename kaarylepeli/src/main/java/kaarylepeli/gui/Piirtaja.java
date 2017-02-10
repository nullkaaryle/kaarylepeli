package kaarylepeli.gui;

import java.awt.*;
import javax.swing.*;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Puolukka;

/**
 * Piirtoalusta, joka piirtää pelin sisällön.
 */
public class Piirtaja extends JPanel implements Paivitettava {

    private Kaarylepeli kaarylepeli;
    private int leveys;
    private int korkeus;

    public Piirtaja(Kaarylepeli peli) {
        this.kaarylepeli = peli;
        this.leveys = peli.haeKentanLeveys();
        this.korkeus = peli.haeKentanKorkeus();
    }

    /**
     * Kutsuu JPanel-luokalta perittyä piirtometodia. Metodissa kutsut pelin
     * sisällön piirtämiseen.
     *
     * @param g grafiikka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graf2d = (Graphics2D) g;
        graf2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        piirraTausta(graf2d);
        piirraPuolukat(graf2d);
        piirraKaaryle(graf2d);
        piirraPisteet(graf2d);
    }

    /**
     * Metodi piirtää pistetilanteen pelikentän vasempaan yläkulmaan, ja lopulta
     * Game Over -tekstin.
     *
     * @param g grafiikka
     */
    public void piirraPisteet(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 20));
        g.drawString("Pisteet: " + String.valueOf(kaarylepeli.haePisteet()), 20, 30);

        if (kaarylepeli.peliJatkuu() == false) {
            g.setFont(new Font("Arial", 1, 50));
            g.drawString("Peli päättyi!", leveys / 2 - 150, korkeus / 2);
        }
    }

    /**
     * Metodi piirtää pelin taustan ja maana toimivan perunamuusin.
     *
     * @param g grafiikka
     */
    public void piirraTausta(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, leveys, korkeus);
        g.setColor(Color.YELLOW);
        g.fillRect(0, korkeus - 50, leveys, 50);
    }

    /**
     * Metodi piirtää pelin puolukat.
     *
     * @param g grafiikka
     */
    public void piirraPuolukat(Graphics g) {
        g.setColor(Color.RED);
        for (Puolukka puolukka : this.kaarylepeli.haePuolukat()) {
            g.fillOval(puolukka.haeHahmonX(), puolukka.haeHahmonY(), 30, 30);
        }
    }

    /**
     * Metodi piirtää kaaryleen.
     *
     * @param g grafiikka
     */
    public void piirraKaaryle(Graphics g) {
        int kaaryleenX = this.kaarylepeli.haeKaaryle().haeHahmonX();
        int kaaryleenY = this.kaarylepeli.haeKaaryle().haeHahmonY();
        g.setColor(Color.GREEN);
        g.fillRect(kaaryleenX, kaaryleenY, 50, 100);
        Rectangle oval = new Rectangle();
    }

    /**
     * Metodi pyytää uudelleenpiirtoa eli kentän päivitystä.
     */
    @Override
    public void paivita() {
        this.repaint();
    }

}
