package kaarylepeli.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import kaarylepeli.peli.*;
import kaarylepeli.rakennusosat.*;

/**
 * Piirtoalusta, joka piirtää pelin sisällön.
 */
public class Piirtaja extends JPanel implements Paivitettava {

    private Kaarylepeli kaarylepeli;
    private int leveys;
    private int korkeus;
    private BufferedImage taustakuva;
    private BufferedImage kaaryleenKuva;
    private BufferedImage puolukanKuva;
    private BufferedImage kaaryleVasenJalka;
    private BufferedImage kaaryleOikeaJalka;
    private BufferedImage kaaryleenHyppyKuva;
    private BufferedImage huippupisteKuva;
    private BufferedImage muusinKuva;
    private int juoksujalkaVasen;
    private int juoksujalkaOikea;

    /**
     * Piirtaja-luokan konstruktori.
     *
     * @param peli Kaarylepeli-luokka parametrina
     */
    public Piirtaja(Kaarylepeli peli) throws IOException {
            this.kaarylepeli = peli;
            this.leveys = peli.haeKentanLeveys();
            this.korkeus = peli.haeKentanKorkeus();
            this.taustakuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/tausta.png"));
            this.kaaryleenKuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/kaaryle.png"));
            this.kaaryleOikeaJalka = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/kaaryleOikeaJalka.png"));
            this.kaaryleVasenJalka = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/kaaryleVasenJalka.png"));
            this.kaaryleenHyppyKuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/kaaryleHyppy.png"));
            this.puolukanKuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/puolukkaIsompi.png"));
            this.muusinKuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/muusi.png"));
            this.huippupisteKuva = ImageIO.read(getClass().getClassLoader().getResourceAsStream("kaarylepelikuvat/huippupisteet.png"));
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
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Metodi piirtää muusin pelikentän alareunaan.
     *
     * @param g grafiikka
     */
    public void piirraMuusi(Graphics g) {
        for (Muusi muusi : this.kaarylepeli.haeMuusit()) {
            g.drawImage(muusinKuva, muusi.haeHahmonX(), muusi.haeHahmonY(), this);
            Toolkit.getDefaultToolkit().sync();
        }

        //g.drawImage(muusinKuva, 0, (this.korkeus - 65), this);
    }

    /**
     * Metodi piirtää pelin puolukat.
     *
     * @param g grafiikka
     */
    public void piirraPuolukat(Graphics g) {
        for (Puolukka puolukka : this.kaarylepeli.haePuolukat()) {
            g.drawImage(puolukanKuva, puolukka.haeHahmonX(), puolukka.haeHahmonY(), this);
            Toolkit.getDefaultToolkit().sync();
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

        if (this.kaarylepeli.haeKaaryle().onMaassa() == false) {
            g.drawImage(kaaryleenHyppyKuva, kaaryleenX, kaaryleenY, this);
            Toolkit.getDefaultToolkit().sync();
        } else {

            if (this.juoksujalkaVasen <= 1) {
                g.drawImage(kaaryleVasenJalka, kaaryleenX, kaaryleenY, this);
                Toolkit.getDefaultToolkit().sync();
                juoksujalkaVasen++;

            } else {
                g.drawImage(kaaryleOikeaJalka, kaaryleenX, kaaryleenY, this);
                Toolkit.getDefaultToolkit().sync();
                juoksujalkaOikea++;
            }

            if (juoksujalkaOikea == 1) {
                juoksujalkaOikea = 0;
                juoksujalkaVasen = 0;
            }
        }

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

        if (kaarylepeli.haePisteet() > kaarylepeli.haeHuippupisteet() && kaarylepeli.haeHuippupisteet() != 0) {
            g.setColor(Color.YELLOW);
        }

        g.setFont(new Font("Arial", 1, 20));
        g.drawString(pisteteksti, 20, 30);
        Toolkit.getDefaultToolkit().sync();

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
        Toolkit.getDefaultToolkit().sync();

        if (kaarylepeli.tuliEnnatys()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString(pisteteksti + " - UUSI ENNÄTYS!", 20, 30);
            Toolkit.getDefaultToolkit().sync();
            g.drawImage(huippupisteKuva, kaarylepeli.haeKaaryle().haeHahmonX() - 12, kaarylepeli.haeKaaryle().haeHahmonY() + 15, this);
            Toolkit.getDefaultToolkit().sync();
        }

    }

}
