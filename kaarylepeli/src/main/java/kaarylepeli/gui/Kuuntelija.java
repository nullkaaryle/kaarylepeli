package kaarylepeli.gui;

import java.awt.event.*;
import kaarylepeli.rakennusosat.Kaaryle;

/**
 * Näppäimistönkuuntelija-luokka.
 *
 */
public class Kuuntelija implements KeyListener {

    private Kaaryle kaaryle;

    public Kuuntelija(Kaaryle kaaryle) {
        this.kaaryle = kaaryle;
    }

    /**
     * Tarkastaa näppäimistön painalluksen ja muokkaa kaaryleen toimintoja sen
     * mukaisesti.
     *
     * @param e tapahtuma näppäimistöltä
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.kaaryle.hyppyarvo() == 0) {
                this.kaaryle.kasvataHyppyarvoa(1);
            }
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
