package kaarylepeli.gui;

import java.awt.event.*;
import javax.swing.SwingUtilities;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Kaaryle;

/**
 * Näppäimistönkuuntelija-luokka.
 */
public class Kuuntelija implements KeyListener {

    private Kaarylepeli kaarylepeli;

    /**
     * Kuuntelija-luokan konstruktori.
     *
     * @param kaarylepeli Kaarylepeli-luokan ilmentymä
     */
    public Kuuntelija(Kaarylepeli kaarylepeli) {
        this.kaarylepeli = kaarylepeli;
    }

    /**
     * Tarkastaa näppäimistön painalluksen ja muokkaa pelin toimintoja sen
     * mukaisesti.
     *
     * @param e tapahtuma näppäimistöltä
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.kaarylepeli.haeKaaryle().onMaassa()) {
                this.kaarylepeli.haeKaaryle().hyppaaIlmaan();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && this.kaarylepeli.peliJatkuu() == false) {
            this.kaarylepeli.aloitaUusiPeli();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ei tueta (ainakaan aluksi)
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //ei tueta 
    }

}
