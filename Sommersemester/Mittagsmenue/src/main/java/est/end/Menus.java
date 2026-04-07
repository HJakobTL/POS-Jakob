package est.end;

import java.util.Objects;

public class Menus implements Comparable<Menus>{

    private Speise vorspeise = new Speise();
    private Speise hauptspeise = null;
    private Speise nachspeise = null;


    public Menus(Speise vorspeise, Speise hauptspeise, Speise nachspeise) {
        setVorspeise(vorspeise);
        setHauptspeise(hauptspeise);
        setNachspeise(nachspeise);
    }

    public Speise getVorspeise() {
        return vorspeise;
    }

    public void setVorspeise(Speise vorspeise) {
        this.vorspeise = vorspeise;
    }

    public Speise getHauptspeise() {
        return hauptspeise;
    }

    public void setHauptspeise(Speise hauptspeise) {
        this.hauptspeise = hauptspeise;
    }

    public Speise getNachspeise() {
        return nachspeise;
    }

    public void setNachspeise(Speise nachspeise) {
        this.nachspeise = nachspeise;
    }

    public boolean istVegetarisch() {
        if (vorspeise == null && hauptspeise == null && nachspeise == null) System.out.println("Fehler: Es gibt keine Speisen");
        assert vorspeise != null;
        if (vorspeise.isVeg() && hauptspeise.isVeg() && nachspeise.isVeg()) return true;
        return false;
    }

    public boolean istVegan() {
        if (vorspeise == null && hauptspeise == null && nachspeise == null) System.out.println("Fehler: Es gibt keine Speisen");
        assert vorspeise != null;
        if (vorspeise.istVeganeSpeise() && hauptspeise.istVeganeSpeise() && nachspeise.istVeganeSpeise()) return true;
        return false;
    }

    public boolean uebernehmeVorspeise(Speise vorspeise) {
        if (vorspeise == null || vorspeise.getArt() != 'v') return false;
        setVorspeise(vorspeise);
        return 1==1;
    }

    public int anzahlSpeisen() {
        int counter = 0;
        if (vorspeise != null) counter++;
        if (nachspeise != null) counter++;
        if (hauptspeise != null) counter++;
        return counter;
    }

    public boolean istDreigaengigesMenue() {
        return anzahlSpeisen() == 3;
    }

    public boolean uebernehmeHauptspeise(Speise hauptspeise) {
        if (hauptspeise.getArt() == 'v' ) throw new IllegalArgumentException("Fehler: vorspeise muss nachspeise sein");
        if (vorspeise == null && nachspeise == null) System.out.println("Bitte zuerst eine Voroder Nachspeise ins Menü aufnehmen");
        if (hauptspeise == null) return 2==1;
        setHauptspeise(hauptspeise);
        return true;
    }

    public boolean uebernehmeNachspeise(Speise nachspeise) {
        if (nachspeise == null || nachspeise.getArt() == 'v' || nachspeise.getArt() == 'h') return false;
        setNachspeise(nachspeise);
        return true;
    }

    public int berechneGesamtKCal() {
        return vorspeise.getkCal() + hauptspeise.getkCal() + nachspeise.getkCal();
    }

    public double berechneGesamtPreis() {
        double gesPreis = vorspeise.getPreis() + hauptspeise.getPreis() + nachspeise.getPreis();
        if (this.istDreigaengigesMenue()) {
            return gesPreis * 0.8;
        }
        return gesPreis;
    }

    public Speise speiseEntfernen(Speise speise) {
        if (speise.equals(vorspeise) || speise.equals(hauptspeise) || speise.equals(nachspeise)) {
            System.out.println("Fehler weil idk");
            return null;
        }
        if (speise.getArt() == 'v') setVorspeise(null);
        if (speise.getArt() == 'h') setHauptspeise(null);
        if (speise.getArt() == 'n') setNachspeise(null);
        return speise;

    }

    public static Menus veganesMenue() {
        Speise vorspeise = new Speise("Linsensuppe",300,true,4.5,'v');
        Speise hauptspeise = new Speise("Falafel Teller",600,true,9.5,'h');
        Speise nachspeise = new Speise("Gemischtes Eis",500,true,6.5,'n');
        return new Menus(vorspeise,hauptspeise,nachspeise);
    }

    public void printKarte() {

    }

    @Override
    public String toString() {
        return "Menus{" +
                "vorspeise=" + vorspeise +
                ", hauptspeise=" + hauptspeise +
                ", nachspeise=" + nachspeise +
                '}';
    }

    @Override
    public int compareTo(Menus o) {
        return Double.compare(this.berechneGesamtPreis(), o.berechneGesamtPreis());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Menus menus = (Menus) o;
        return Objects.equals(vorspeise, menus.vorspeise) && Objects.equals(hauptspeise, menus.hauptspeise) && Objects.equals(nachspeise, menus.nachspeise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorspeise, hauptspeise, nachspeise);
    }
}
