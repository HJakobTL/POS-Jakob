package est.end;

import java.util.Objects;

public class SegelBoot extends Boot{

    private double preisProPerson;
    private boolean lizenz;

    public SegelBoot(int maxPersonen, String bezeichnungen, double preisProPerson, boolean lizenz) throws BootException {
        super(maxPersonen, bezeichnungen);
        setPreisProPerson(preisProPerson);
        setLizenz(lizenz);
    }

    public double getPreisProPerson() {
        return preisProPerson;
    }

    public void setPreisProPerson(double preisProPerson) throws BootException {
        if (preisProPerson <= 0.0) throw new BootException("Fehler: kleiner 0.0");
        this.preisProPerson = preisProPerson;
    }

    public boolean isLizenz() {
        return lizenz;
    }

    public void setLizenz(boolean lizenz) {
        this.lizenz = lizenz;
    }

    private String hatLizenz(boolean lizenz) {
        if (lizenz) return "mit Lizenz";
        return "ohne Lizenz";
    }

    @Override
    public double preis() {
        return getMaxPersonen() * preisProPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SegelBoot segelBoot = (SegelBoot) o;
        return Double.compare(preisProPerson, segelBoot.preisProPerson) == 0 && lizenz == segelBoot.lizenz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preisProPerson, lizenz);
    }

    @Override
    public String toString() {
        return super.toString() + "," + hatLizenz(lizenz);
    }
}
