package est.end;

import java.util.Objects;

public abstract class Boot implements Comparable<Boot> {

    private int maxPersonen;
    private String bezeichnungen;

    public Boot(int maxPersonen, String bezeichnungen) throws BootException {
        setMaxPersonen(maxPersonen);
        setBezeichnungen(bezeichnungen);
    }

    public int getMaxPersonen() {
        return maxPersonen;
    }

    public void setMaxPersonen(int maxPersonen) throws BootException {
        if (maxPersonen < 0) throw new BootException("Fehler: muss >= 1 sein");
        this.maxPersonen = maxPersonen;
    }

    public String getBezeichnungen() {
        return bezeichnungen;
    }

    public void setBezeichnungen(String bezeichnungen) throws BootException {
        if (bezeichnungen == null || bezeichnungen.isEmpty()) throw new BootException("Fehler: null oder leer");
        this.bezeichnungen = bezeichnungen;
    }

    public abstract double preis();

    public double preisProPerson() {
        return maxPersonen > 0 ? preis() / maxPersonen : 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Boot boot = (Boot) o;
        return maxPersonen == boot.maxPersonen && Objects.equals(bezeichnungen, boot.bezeichnungen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPersonen, bezeichnungen);
    }

    @Override
    public int compareTo(Boot o) {
        return Integer.compare(this.maxPersonen,o.getMaxPersonen());
    }

    @Override
    public String toString() {
        return "Max. Personen: " + maxPersonen +
            ", Bezeichnung: " + bezeichnungen +
            ", Preis: " + preis() + "EUR" +
            ", Preis pro Person: " + preisProPerson() + "EUR";
    }
}
