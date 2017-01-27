
package kaarypeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kaarypeli.hahmo.Kaaryle;

public class Nappaimistonkuuntelija implements KeyListener {
    
    private Kaaryle kaaryle;
    
    public Nappaimistonkuuntelija(Kaaryle kaaryle) {
        this.kaaryle = kaaryle;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
