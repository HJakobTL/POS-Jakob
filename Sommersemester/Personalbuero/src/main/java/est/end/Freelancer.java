package est.end;

import java.time.Year;

public class Freelancer extends Mitarbeiter{
    private double stundenSatz;
    private int stunden;

    public Freelancer(String name, Year gebJahr, Year eintrJahr, double stundenSatz, int stunden) throws PersonalException {
        super(name, gebJahr, eintrJahr);
        setStundenSatz(stundenSatz);
        setStunden(stunden);
    }

    public Freelancer() throws PersonalException {
        super("Anna", Year.of(2001), Year.now());
        setStundenSatz(100.0);
        setStunden(10);
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) throws PersonalException {
        if (stundenSatz <= 0.0) {
            //throw new IllegalArgumentException("Fehler: zu billig!");
            throw new PersonalException("Fehler: zu billig!");
        }
        this.stundenSatz = stundenSatz;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) throws PersonalException {
        if (stunden <= 0) {
            //throw new IllegalArgumentException("Fehler: zu wenig");
            throw new PersonalException("Fehler: zu wenig");
        }
        this.stunden = stunden;
    }

    @Override
    public double berechneGehalt() {
        return stundenSatz * stunden;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Freelancer that = (Freelancer) o;
        return Double.compare(stundenSatz, that.stundenSatz) == 0 && stunden == that.stunden;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(stundenSatz);
        result = 31 * result + stunden;
        return result;
    }

    @Override
    public String toString() {
        return "Freelancer: " + super.toString() +
                ", Stundensatz: " + stundenSatz +
                ", Stunden: " + stunden;
    }
}
