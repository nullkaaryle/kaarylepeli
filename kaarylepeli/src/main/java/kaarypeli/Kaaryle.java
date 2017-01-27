package kaarypeli;

public class Kaaryle extends Hahmo {  //kaaryle koostuu Osista

    public Kaaryle() {
        super();
        luoKaaryle();
    }

    public void luoKaaryle() {
        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 10; y++) {
                this.lisaaOsa(new Osa(x, y));
            }
        }
    }

}
