package kaarypeli.hahmo;

public abstract class Hahmo {
    
    private int x;
    private int y;
    
   public Hahmo(int alkuX, int alkuY) {
        this.x = alkuX;
        this.y = alkuY;
    }
    
    public int haeX() {
        return this.x;
    }
    
    public int haeY() {
        return this.y;
    }
    
    public void asetaX(int uusiX) {
        this.x = uusiX;
    }
    
    public void asetaY(int uusiY) {
        this.y = uusiY;
    }
    
    public boolean osuu(Hahmo hahmo) {
        return this.x == hahmo.haeX() && this.y == hahmo.haeY();
    }
    
    public abstract void liiku();
   
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    
    
    
}
