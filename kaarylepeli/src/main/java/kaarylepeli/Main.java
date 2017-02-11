package kaarylepeli;

import javax.swing.SwingUtilities;
import kaarylepeli.gui.Kayttoliittyma;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Kaaryle;

public class Main {

    /**
     * Pääohjelma, jossa luodaan uusi peli, sen käyttöliittymä ja käynnistetään
     * pelin kello.
     * 
     * @param args  komentoriviargumentit
     */
    public static void main(String[] args) {

        Kaarylepeli kaarylepeli = new Kaarylepeli();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kaarylepeli);
        SwingUtilities.invokeLater(kayttoliittyma);

        while (kayttoliittyma.haePaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtäjää ei ole vielä luotu.");
            }
        }

        kaarylepeli.asetaPaivitettava(kayttoliittyma.haePaivitettava());
        kaarylepeli.start();

    }

}
