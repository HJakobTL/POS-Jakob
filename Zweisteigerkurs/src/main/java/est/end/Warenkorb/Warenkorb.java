package est.end.Warenkorb;

import java.util.ArrayList;
import java.util.Objects;

public class Warenkorb {

    private final ArrayList<Artikel> artikeln;

    public Warenkorb() {
        this.artikeln = new ArrayList<>();
    }

    public void getArtikel(String bezeichnung, double preis) {
        System.out.println(bezeichnung + ": " + preis + "€");
    }

    public void aufnehmen(Artikel ar) {
        if (ar == null) {
            return;
        }
        if (artikeln.contains(ar)) {
            ar.setMenge(ar.getMenge()+1);
        }
        else {
            artikeln.add(ar);
        }
    }

    public boolean istDrinnen(String bezeichnung, double preis){
        for (Artikel artikel : artikeln) {
            if (Objects.equals(artikel.getBezeichnung(), bezeichnung) && artikel.getPreis() == preis) {
                return true;
            }
        }
        return false;
    }

    public double berechneSumme() {
        double summe = 0;
        if(artikeln.isEmpty()) {
            return 0.0;
        }
        for (Artikel artikel : artikeln) {
            summe += artikel.berechneGesamtpreis();
        }
        return summe;
    }

    public double berechneDurchschnittspreis() {
        if (artikeln.isEmpty()) return 0.0;
        return berechneSumme() / mengeArtikel();
    }

    public int anzahlArtikel() {
        return artikeln.size();
    }

    public int mengeArtikel() {
        int menge = 0;
        for (Artikel artikel : artikeln) {
            menge += artikel.getMenge();
        }
        return menge;
    }

    @Override
    public String toString() {
        return "Warenkorb{" +
                "Ihre Waren=" + artikeln +
                '}';
    }
}