package kaarypeli.peli;

import javax.swing.SwingUtilities;
import kaarypeli.gui.Kayttoliittyma;
import kaarypeli.hahmo.*;

public class Paaohjelma {

    public static void main(String[] args) {
        Puolukka puolami = new Puolukka(1, 2);
        System.out.println("Puolamin sijainti: " + puolami.toString());
        Kaaryle kaeaerylae = new Kaaryle(1, 2);
        System.out.println("Kaeaerylaen sijainti: " + kaeaerylae.toString());
        System.out.println("-------");
        System.out.println("Puolami ja Kaeaerylae kohtasivat: " + puolami.osuu(kaeaerylae));
        System.out.println("*************");
        puolami.liiku();
        kaeaerylae.liiku();
        System.out.println("Puolamin sijainti: " + puolami.toString());
        System.out.println("Kaeaerylaen sijainti: " + kaeaerylae.toString());
        System.out.println("-------");
        System.out.println("Puolami ja Kaeaerylae kohtasivat: " + puolami.osuu(kaeaerylae));
    }
}







//        Kaarylepeli kaarylepeli = new Kaarylepeli(20, 20);
//
//        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kaarylepeli, 20);
//        SwingUtilities.invokeLater(kayttoliittyma);
//
//        while (kayttoliittyma.haePaivitettava() == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                System.out.println("Piirtoalustaa ei ole vielä luotu.");
//            }
//        }
//
//        kaarylepeli.asetaPaivitettava(kayttoliittyma.haePaivitettava());
//        kaarylepeli.start();
//    }
