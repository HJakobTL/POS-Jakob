package est.end;

import java.time.Year;
import java.util.Objects;

public class Freelancer extends Mitarbeiter {
   
    private double stundenSatz;
    private int stunden;

    public Freelancer() {
        super("Anna", Year.of(2001), Year.now());
        setStunden(10);
        setStundenSatz(100.0);
    }

    public Freelancer(String name, Year gebJahr, Year eintrJahr, double stundenSatz, int stunden) {
        super(name, gebJahr, eintrJahr);
        setStunden(stunden);
        setStundenSatz(stundenSatz);
    } 

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) {
        if (stundenSatz <= 0) throw new IllegalArgumentException("Darf nicht kleiner 0 sein");
        this.stundenSatz = stundenSatz;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        if (stunden <= 0) throw new IllegalArgumentException("Darf nicht kleiner 0 sein");
        this.stunden = stunden;
    }

    @Override
    public double berechneGehalt() {
        return stunden * stundenSatz;
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
        return Objects.hash(super.hashCode(), stundenSatz, stunden);
    }

    @Override
    public String toString() {
        return "Freelancer: " + super.toString();
    }
}
