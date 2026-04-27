package at.spengergasse;

public abstract class Vertrag implements Comparable<Vertrag>{
    private double summe;

    public Vertrag(double summe) throws VersicherungException {
        setSumme(summe);
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) throws VersicherungException {
        if (summe > 0.0) {
            this.summe = summe;
        } else {
            throw new VersicherungException("Fehler: summe muss größer als 0.0 sein");
        }
    }

    public abstract double berechnePreis();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertrag vertrag)) return false;

        return Double.compare(summe, vertrag.summe) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(summe);
    }

    @Override
    public int compareTo(Vertrag o) {
        return Double.compare(o.berechnePreis(), berechnePreis());  // absteigend
    }

    @Override
    public String toString() {
        return "Versicherungs-Summe: " + summe + " EUR, " + berechnePreis() + " EUR";
    }
}
