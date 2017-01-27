package kaarypeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kaarypeli.peli.Kaarylepeli;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Kaarylepeli kaarypeli;

    public Piirtoalusta(Kaarylepeli kaarylepeli) {
        this.kaarypeli = kaarypeli;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.PINK);
        graphics.fillOval(this.kaarypeli.haePuolukka().haeX(), this.kaarypeli.haePuolukka().haeY(), 2, 2);
    }

    @Override
    public void paivita() {
        this.repaint();
    }

}
