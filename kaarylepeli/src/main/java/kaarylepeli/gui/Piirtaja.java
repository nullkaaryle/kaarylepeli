package kaarylepeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Puolukka;

public class Piirtaja extends JPanel implements Paivitettava {

    private Kaarylepeli kaarylepeli;

    public Piirtaja(Kaarylepeli peli) {
        this.kaarylepeli = peli;
    }

    @Override
    protected void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);

        Graphics2D graf2d = (Graphics2D) grafiikka;
        piirraPuolukat(graf2d);
        piirraKaaryle(graf2d);
    }

    public void piirraPuolukat(Graphics grafiikka) {
        grafiikka.setColor(Color.RED);
        for (Puolukka puolukka : this.kaarylepeli.haePuolukat()) {
            grafiikka.fillOval(puolukka.haeHahmonX(), puolukka.haeHahmonY(), 30, 30);  //puolukan X ja y

        }
    }

    public void piirraKaaryle(Graphics grafiikka) {
        grafiikka.setColor(Color.GREEN);
        grafiikka.fillRect(this.kaarylepeli.haeKaaryle().haeHahmonX(), this.kaarylepeli.haeKaaryle().haeHahmonY(), 50, 100);  //kaaryleen X ja y
    }

    @Override
    public void paivita() {
        this.repaint();
    }

}
