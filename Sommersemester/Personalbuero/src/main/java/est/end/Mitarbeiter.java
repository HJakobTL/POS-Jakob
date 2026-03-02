package est.end;

import java.time.Year;
import java.util.Objects;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>{

    private String name;
    private Year gebJahr;
    private Year eintrJahr;

    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) {
        setName(name);
        setGebJahr(gebJahr);
        setEintrJahr(eintrJahr);
    }

    public Mitarbeiter() {
        this.name = "Anna";
        this.gebJahr = Year.of(2001);
        this.eintrJahr = Year.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(Year gebJahr) {
        if (gebJahr == null) throw new IllegalArgumentException("Fehler: null");
        if (gebJahr.isAfter(Year.now())) throw new IllegalArgumentException("Fehler: Geburstag liegt in der Zukunft");
        this.gebJahr = gebJahr;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public void setEintrJahr(Year eintrJahr) {
        if (eintrJahr == null) throw new IllegalArgumentException("Fehler: null");
        if (eintrJahr.isAfter(Year.now())) throw new IllegalArgumentException("Fehler: Geburstag liegt in der Zukunft");
        this.eintrJahr = eintrJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int dienstAlter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }

    public abstract double berechneGehalt();

    @Override
    public int compareTo(Mitarbeiter o) {
        /*
        if (o == null) throw new NullPointerException("Fehler: null");
        if (o.getClass() != getClass()) throw new ClassCastException("Fehler: Falsche Klasse");
        if (this.name.equals(o.name)) {
            return 0;
        }
        else {

        }
        */
        return name.compareTo(o.getName());
    }

    public double berechnePraemie() {
        /*  Alte Version
         * switch(dienstAlter()) {
            case 15: return berechneGehalt(); // break;
            case 20: return berechneGehalt()*2; //  break;
            case 25: return berechneGehalt()*3; // break;
            case 50: return berechneGehalt()*6; // break;
            default: return 0.0;
        }
        */
        // Neue Version
        return switch (dienstAlter()) {
            case 15 -> berechneGehalt();
            case 20 -> berechneGehalt()*2;
            case 25 -> berechneGehalt()*3;
            case 50 -> berechneGehalt()*7;
            default -> 0.0;
        };
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mitarbeiter that = (Mitarbeiter) o;
        return Objects.equals(name, that.name) && Objects.equals(gebJahr, that.gebJahr) && Objects.equals(eintrJahr, that.eintrJahr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gebJahr, eintrJahr);
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Geb.Jahr: " + getGebJahr() +
                ", Alter: " + berechneAlter() +
                ", Eintr.Jahr: " + getEintrJahr() +
                ", Dienstalter: " + dienstAlter() +
                ", Gehalt: " + berechneGehalt() +
                ", Praemie: " + berechnePraemie();
    }

    public void print() {
        IO.print(this);
    }
}
