package kaarypeli;

public class Puolukka extends Hahmo { //puolukka koostuu Osista
    
    public Puolukka() {
        super();
        luoPuolukka();
    }
    
    public void luoPuolukka() {
        for (int x = 0; x < 3; x++) {
            
            for (int y = 0; y < 3; y++) {
                this.lisaaOsa(new Osa(x,y));
            }
        }
    }

}
