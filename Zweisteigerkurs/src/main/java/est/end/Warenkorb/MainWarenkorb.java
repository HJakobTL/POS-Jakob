package est.end.Warenkorb;

public class MainWarenkorb {
    void main(){
        Artikel banane = new Artikel("Banane",13,1);
        Artikel apfel = new Artikel("Apfel",27,1);
        Artikel brot = new Artikel();
        Warenkorb warenkorb1 = new Warenkorb();

        warenkorb1.aufnehmen(banane);
        warenkorb1.aufnehmen(apfel);
        warenkorb1.aufnehmen(apfel);
        warenkorb1.aufnehmen(banane);
        warenkorb1.aufnehmen(brot);

        warenkorb1.getArtikel("Katze",21);
        boolean test = warenkorb1.istDrinnen("Banane",13);
        System.out.println(test);
        double sum = warenkorb1.berechneSumme();
        System.out.println(sum);
        System.out.println(warenkorb1.berechneDurchschnittspreis());
        System.out.println(warenkorb1.anzahlArtikel());
        System.out.println(warenkorb1);
    }


}
