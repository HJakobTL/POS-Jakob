package at.spengergasse;

import java.time.Year;

public class Arzt extends Mitarbeiter{

    private int wochenStunden;
    private double fixum;

    public Arzt(String name, Year gebJahr, Year eintrJahr, int wochenStunden, double fixum) throws PersonalException {
        super(name, gebJahr, eintrJahr);
        setWochenStunden(wochenStunden);
        setFixum(fixum);
    }

    public int getWochenStunden() {
        return wochenStunden;
    }

    public void setWochenStunden(int wochenStunden) throws PersonalException {
        if(wochenStunden <= 0) {
            //throw new IllegalArgumentException("Fehler: 0 oder negativ");
            throw new PersonalException("Fehler: 0 oder negativ");
        }
        this.wochenStunden = wochenStunden;
    }

    public double getFixum() {
        return fixum;
    }

    public void setFixum(double fixum) throws PersonalException {
        if(fixum <= 0.0) {
            //throw new IllegalArgumentException("Fehler: 0 oder negativ");
            throw new PersonalException("Fehler: 0 oder negativ");
        }
        this.fixum = fixum;
    }

    @Override
    public double berechneGehalt() {
        return fixum;
    }

    public double berechneStundensatz() {
        return fixum / wochenStunden; // kann wochenStunden 0 sein? Nein -> keine Div durch 0 möglich
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
        int result = super.hashCode();
        result = 31 * result + wochenStunden;
        result = 31 * result + Double.hashCode(fixum);
        return result;
    }

    @Override
    public String toString() {
        return "Arzt: " + super.toString() +
                ", Wochenstunden: " + wochenStunden +
                ", Fixum: " + fixum;
    }
}
