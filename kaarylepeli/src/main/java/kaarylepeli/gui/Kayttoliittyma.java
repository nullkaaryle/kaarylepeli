package kaarylepeli.gui;

import java.awt.Container;
import javax.swing.*;
import kaarylepeli.peli.Kaarylepeli;
import kaarylepeli.rakennusosat.Kaaryle;
import kaarylepeli.rakennusosat.Puolukka;

public class Kayttoliittyma implements Runnable {

    private Kaarylepeli kaarylepeli;
    private JFrame kehys;
    private Piirtaja piirtaja;

    public Kayttoliittyma(Kaarylepeli peli) {
        this.kaarylepeli = peli;
    }

    @Override
    public void run() {
        this.kehys = new JFrame("Käärylepeli");
        kehys.setSize(this.kaarylepeli.haeKentanLeveys(), this.kaarylepeli.haeKentanKorkeus());
        kehys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        luoKomponentit(kehys.getContentPane());
        kehys.setVisible(true);

    }
    
    public void luoKomponentit(Container sisaltaja) {
        this.piirtaja = new Piirtaja(this.kaarylepeli);
        sisaltaja.add(piirtaja);
        Kuuntelija kuuntelija = new Kuuntelija(this.kaarylepeli.haeKaaryle());
        this.kehys.addKeyListener(kuuntelija);
    }
    
    public JFrame haeKehys() {
        return this.kehys;
    }

    public Paivitettava haePaivitettava() {
        return this.piirtaja;
    }
    
    public void sammuta() {
        kehys.setVisible(false);
        kehys.dispose();
    }
}

