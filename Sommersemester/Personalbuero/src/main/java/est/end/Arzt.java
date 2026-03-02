package est.end;

import java.time.Year;
import java.util.Objects;

public class Arzt extends Mitarbeiter {

    private int wochenStunden;
    private double fixum;

    public Arzt(String name, Year gebJahr, Year eintrJahr, int wochenStunden, double fixum) {
        super(name, gebJahr, eintrJahr);
        setWochenStunden(wochenStunden);
        setFixum(fixum);

    }

    public int getWochenStunden() {
        return wochenStunden;
    }

    public void setWochenStunden(int wochenStunden) {
        if(wochenStunden <= 0) throw new IllegalArgumentException("Kann nicht kleiner oder gleich 0 sein");
        this.wochenStunden = wochenStunden;
    }

    public double getFixum() {
        return fixum;
    }

    public void setFixum(double fixum) {
        if(fixum <= 0.0) throw new IllegalArgumentException("Kann nicht kleiner oder gleich 0 sein");
        this.fixum = fixum;
    }

    @Override
    public double berechneGehalt() {
        return fixum;
    }

    public double berechneStundensatz() {
        return fixum / wochenStunden;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Arzt arzt = (Arzt) o;
        return wochenStunden == arzt.wochenStunden && Double.compare(fixum, arzt.fixum) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wochenStunden, fixum);
    }

    @Override
    public String toString() {
        return "Arzt{" + super.toString() +
                "wochenStunden=" + wochenStunden +
                ", fixum=" + fixum +
                "} ";
    }
}
