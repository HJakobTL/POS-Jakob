package est.end;

public class Menus {

    private Speise vorspeise = new Speise();
    private Speise hauptspeise = new Speise();
    private Speise nachspeise = new Speise();


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

    @Override
    public String toString() {
        return "Menus{" +
                "vorspeise=" + vorspeise +
                ", hauptspeise=" + hauptspeise +
                ", nachspeise=" + nachspeise +
                '}';
    }
}
