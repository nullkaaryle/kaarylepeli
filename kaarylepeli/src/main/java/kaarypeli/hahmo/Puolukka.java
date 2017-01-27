package kaarypeli.hahmo;

public class Puolukka extends Hahmo {

    public Puolukka(int alkuX, int alkuY) {
        super(alkuX, alkuY);
    }

    @Override
    public void liiku() {
        this.asetaX(this.haeX() - 1);
    }

}
