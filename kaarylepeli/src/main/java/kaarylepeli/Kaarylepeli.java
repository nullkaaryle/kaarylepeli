package kaarylepeli;

public class Kaarylepeli {

    public static void main(String[] args) {
        Puolukka puolami = new Puolukka();
        System.out.println("Puolamin koordinaatit: " + puolami.haeOsat());
        Kaaryle kaeaerylae = new Kaaryle();
        System.out.println("Kaeaerylaen koordinaatit: " + kaeaerylae.haeOsat());
        System.out.println("-------");
        System.out.println("Puolami ja Kaeaerylae kohtasivat: " + puolami.osuu(kaeaerylae));
        System.out.println("*************");
        
        for (int i = 0; i < 10; i++) {
            kaeaerylae.liikuAlas();
        }
        System.out.println("Kaeaerylae pakenee!");
        System.out.println("Puolamin koordinaatit: " + puolami.haeOsat());
        System.out.println("Kaeaerylaen koordinaatit: " + kaeaerylae.haeOsat());
        System.out.println("-------");
        System.out.println("Puolami ja Kaeaerylae kohtasivat: " + puolami.osuu(kaeaerylae));
    }

}
