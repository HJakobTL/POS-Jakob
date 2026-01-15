package est.end.ArrayList;

import java.util.ArrayList;

public class MainArrayList {
    public static void main(String[] args) {
        // Einfache ArrayListe machen
        ArrayList Liste = new ArrayList();
        Liste.add("Hello");
        Liste.add(5);
        Liste.add(3.14);
        System.out.println(Liste);

        // String only ArrayListe
        ArrayList<String> StringListe = new ArrayList<>();
        StringListe.add("Meine");
        StringListe.add("StringListe");
        // Int kann nicht eingefügt werden
        // StringListe.add(21);

        // Integer vs int
        int a = 7;
        Integer b = a;
        int c = b;
        // a = null; // int kann kein null haben -> error
        // b = null; // Integer kann null haben -> kein error

        Integer d = 12;
        Integer e = d * b;
        System.out.println(e);
    }
}
