package kaarylepeli;

import javax.swing.SwingUtilities;
import kaarylepeli.gui.Kayttoliittyma;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Kaaryle;

public class Main {

    public static void main(String[] args) {

        Kaarylepeli kaarylepeli = new Kaarylepeli();

        Kayttoliittyma liittyma = new Kayttoliittyma(kaarylepeli);
        SwingUtilities.invokeLater(liittyma);

        while (liittyma.haePaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtäjää ei ole vielä luotu.");
            }
        }

        kaarylepeli.asetaPaivitettava(liittyma.haePaivitettava());
        kaarylepeli.start();

    }

}
