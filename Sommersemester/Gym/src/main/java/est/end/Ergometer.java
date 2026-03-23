package est.end;

import java.util.Objects;

public class Ergometer extends Maschine{

    private int maxDrehanzahl;

    public Ergometer(String name, double preisEur, int maxDrehanzahl) {
        super(name, preisEur);
        setMaxDrehanzahl(maxDrehanzahl);
    }

    public int getMaxDrehanzahl() {
        return maxDrehanzahl;
    }

    public void setMaxDrehanzahl(int maxDrehanzahl) {
        if (maxDrehanzahl < 5 || maxDrehanzahl > 150) throw new IllegalArgumentException("Error: Muss zwischen 100 und 500 sein");
        this.maxDrehanzahl = maxDrehanzahl;
    }

    @Override
    public int wartungsIntervall() {
        return 12;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ergometer ergometer = (Ergometer) o;
        return maxDrehanzahl == ergometer.maxDrehanzahl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxDrehanzahl);
    }

    @Override
    public String toString() {
        return "Ergometer:" + super.toString() +
                ", Wartungsintervall: " + wartungsIntervall() +
                ", max. Drehzahl: " + maxDrehanzahl;
    }
}
