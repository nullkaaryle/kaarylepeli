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
    private Image taustakuva;
    private Image kaaryleenKuva;
    private Image puolukanKuva;
    private Image muusinKuva;
    private Image pokaalinKuva;

    /**
     * Piirtaja-luokan konstruktori.
     *
     * @param peli Kaarylepeli-luokka parametrina
     */
    public Piirtaja(Kaarylepeli peli) {
        this.kaarylepeli = peli;
        this.leveys = peli.haeKentanLeveys();
        this.korkeus = peli.haeKentanKorkeus();
        this.taustakuva = new ImageIcon("src/main/resources/kaarylepelikuvat/tausta.png").getImage();
        this.kaaryleenKuva = new ImageIcon("src/main/resources/kaarylepelikuvat/kaaryle.png").getImage();
        this.puolukanKuva = new ImageIcon("src/main/resources/kaarylepelikuvat/puolukka.png").getImage();
        this.muusinKuva = new ImageIcon("src/main/resources/kaarylepelikuvat/muusi.png").getImage();
        this.pokaalinKuva = new ImageIcon("src/main/resources/kaarylepelikuvat/pokaali.png").getImage();
    }

    /**
     * Metodi pyytää uudelleenpiirtoa eli kentän päivitystä.
     */
    @Override
    public void paivita() {
        this.repaint();
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
        piirraMuusi(graf2d);
        piirraPuolukat(graf2d);
        piirraKaaryle(graf2d);
        piirraPisteet(graf2d);
    }

    /**
     * Metodi piirtää pelin taustan.
     *
     * @param g grafiikka
     */
    public void piirraTausta(Graphics g) {
        g.drawImage(taustakuva, 0, 0, this);
    }

    /**
     * Metodi piirtää muusin pelikentän alareunaan.
     *
     * @param g grafiikka
     */
    public void piirraMuusi(Graphics g) {
        g.drawImage(muusinKuva, 0, (this.korkeus - 65), this);
    }

    /**
     * Metodi piirtää pelin puolukat.
     *
     * @param g grafiikka
     */
    public void piirraPuolukat(Graphics g) {
        for (Puolukka puolukka : this.kaarylepeli.haePuolukat()) {
            g.drawImage(puolukanKuva, puolukka.haeHahmonX(), puolukka.haeHahmonY(), this);
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
        g.drawImage(kaaryleenKuva, kaaryleenX, kaaryleenY, this);
    }

    /**
     * Metodi piirtää pistetilanteen pelikentän vasempaan yläkulmaan, ja lopulta
     * Game Over -tekstin.
     *
     * @param g grafiikka
     */
    public void piirraPisteet(Graphics g) {
        String pisteteksti = "Pisteet: " + String.valueOf(kaarylepeli.haePisteet());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 20));
        g.drawString(pisteteksti, 20, 30);

        if (kaarylepeli.peliJatkuu() == false) {
            piirraLopputilanne(g, pisteteksti);
        }
    }

    /**
     * Pelin päätyttyä piirtää Game Over -tekstin ja mahdolliset ennätyspisteet.
     *
     * @param g grafiikka
     * @param pisteteksti pisteteksti String-muodosaa
     */
    public void piirraLopputilanne(Graphics g, String pisteteksti) {
        g.setFont(new Font("Arial", 1, 50));
        g.drawString("Peli päättyi!", leveys / 2 - 150, korkeus / 2);
        g.setFont(new Font("Arial", 1, 23));
        g.drawString("- paina enter ja pelaa uudelleen -", leveys / 2 - 190, korkeus / 2 + 35);

        if (kaarylepeli.tuliEnnatys()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString(pisteteksti + " - UUSI ENNÄTYS!", 20, 30);
            g.drawImage(pokaalinKuva, kaarylepeli.haeKaaryle().haeHahmonX() + 50, kaarylepeli.haeKaaryle().haeHahmonY() + 20, this);
        }

    }

}
