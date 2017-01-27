package kaarylepeli;

public class Osa {  //yksi osa on yksi osanen hahmoa

    private int x;
    private int y;

    public Osa(int alkuX, int alkuY) {
        this.x = alkuX;
        this.y = alkuY;
    }

    public Osa haeOsa() {
        return this;
    }

    public int haeOsanX() {
        return this.x;
    }

    public int haeOsanY() {
        return this.y;
    }

    public void asetaOsanX(int uusiX) {
        this.x = uusiX;
    }

    public void asetaOsanY(int uusiY) {
        this.y = uusiY;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean osuu(Osa osa) {
        return this.x == osa.haeOsanX()
                && this.y == osa.haeOsanY();
    }

}
