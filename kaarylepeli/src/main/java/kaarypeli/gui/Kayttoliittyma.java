
package kaarypeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kaarypeli.peli.Kaarylepeli;

public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private Kaarylepeli kaarylepeli;
    private int sivunpituus;
    private Piirtoalusta piirtoalusta;
    
    public Kayttoliittyma(Kaarylepeli kaarylepeli, int sivunpituus) {
        this.kaarylepeli = kaarylepeli;
        this.sivunpituus = sivunpituus;
        this.piirtoalusta = piirtoalusta;
    }

    @Override
    public void run() {
        frame = new JFrame("Käärylepeli");
        int leveys = (kaarylepeli.haeLeveys() + 1) * sivunpituus + 10;
        int korkeus = (kaarylepeli.haeKorkeus() + 1) * sivunpituus + 10;
        
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        this.piirtoalusta = new Piirtoalusta(this.kaarylepeli);
        container.add(piirtoalusta);
        
    }
    
    public JFrame haeFrame() {
        return this.frame;
    }
    
    public Paivitettava haePaivitettava() {
        return this.piirtoalusta;
    }
    
}
