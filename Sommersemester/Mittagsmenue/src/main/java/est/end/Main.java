package est.end;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Speise s1 = new Speise("apfle",250,false,5,'N');
        Speise s3 = new Speise("Banane",250,false,5,'H');
        Speise leer = new Speise("leer",1,false,1.5,'v');
        Speise s4 = s1.alsVorspeise();
        System.out.println(s1);
        System.out.println(s1.kCalKleinePortion());
        System.out.println(s1.istVorspeise());
        System.out.println(s1.alsVorspeise());
        Speise s2 = s1.alsVeganeSpeise(200,7);
        System.out.println(s2);
        s2 = s1.alsVeganeSpeise(300,8);
        System.out.println(s2);

        Menus m1 = new Menus(null,null,s1);
        System.out.println(m1);
        System.out.println(m1.anzahlSpeisen());
        m1.uebernehmeVorspeise(s4);
        System.out.println(m1);
        System.out.println(m1.anzahlSpeisen());
        //System.out.println(m1.istVegan());
        //System.out.println(m1.istVegetarisch());

    }
}