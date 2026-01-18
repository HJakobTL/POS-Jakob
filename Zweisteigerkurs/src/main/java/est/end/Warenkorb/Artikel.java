package est.end.Warenkorb;

public class Artikel {
    private String bezeichnung;
    private double preis;
    private int menge;

    public Artikel(String bezeichnung, double preis, int menge) {
        this.setBezeichnung(bezeichnung);
        this.setPreis(preis);
        this.setMenge(menge);
    }

    public Artikel() {
        this.setBezeichnung("Brot");
        this.setPreis(4.95);
        this.setMenge(1);
    }

    // Setter und Getter
    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getMenge() {
        return menge;
    }

    public double getPreis() {
        return preis;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setMenge(int menge) {
        if (menge< 1) {
            throw new IllegalArgumentException("Muss größer 1 sein!");
        }
        this.menge = menge;
    }

    public void setPreis(double preis) {
        if (preis < 0.1) {
            throw new IllegalArgumentException("Muss größer 0.1 sein!");
        }
        this.preis = preis;
    }

    // Hilfsfunktionen
    public double berechneGesamtpreis() {
        return preis * menge;
    }

    @Override
    public String toString() {
        return  "Name='" + bezeichnung + '\'' +
                ", Preis=" + preis +
                ", Menge=" + menge +
                '}';
    }
}
