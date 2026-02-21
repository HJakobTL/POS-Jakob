package est.end;

import java.time.Year;

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
    public String toString() {
        return "Freelancer: " + super.toString();
    }
}
