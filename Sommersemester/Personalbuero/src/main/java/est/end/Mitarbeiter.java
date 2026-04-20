package est.end;

import java.time.Year;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>{

    private String name;
    private Year gebJahr;
    private Year eintrJahr;

    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) throws PersonalException {
        setName(name);
        setGebJahr(gebJahr);
        setEintrJahr(eintrJahr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws PersonalException {
        if (name == null) {
            throw new PersonalException("Fehler: null");
        }
        this.name = name;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(Year gebJahr) throws PersonalException {
        if (gebJahr == null) {
            //throw new IllegalArgumentException("Fehler: null");
            throw new PersonalException("Fehler: null");
        }
        if (gebJahr.isAfter(Year.now())) { // in der Zukunft
            //throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
            throw new PersonalException("Fehler: liegt in der Zukunft");
        }
        this.gebJahr = gebJahr;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public void setEintrJahr(Year eintrJahr) throws PersonalException {
        if (eintrJahr == null) {
            //throw new IllegalArgumentException("Fehler: null");
            throw new PersonalException("Fehler: null");

        }
        if (eintrJahr.isAfter(Year.now())) { // in der Zukunft
            //throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
            throw new PersonalException("Fehler: liegt in der Zukunft");
        }
        this.eintrJahr = eintrJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }

    public abstract double berechneGehalt();

    public double berechnePraemie() {
        return switch (berechneDienstalter()) {
            case 15 -> berechneGehalt(); // break;
            case 20 -> berechneGehalt() * 2; //break;
            case 25 -> berechneGehalt() * 3; // break;
            case 50 -> berechneGehalt() * 7; // break; // 14 Gehälter / 2 -> 7
            default -> 0.0;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Mitarbeiter that = (Mitarbeiter) o;
        return name.equals(that.name) && gebJahr.equals(that.gebJahr) && eintrJahr.equals(that.eintrJahr);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gebJahr.hashCode();
        result = 31 * result + eintrJahr.hashCode();
        return result;
    }

    @Override
    public int compareTo(Mitarbeiter o) {
        return name.compareTo(o.getName());
//        if (o == null) {
//            throw new NullPointerException("Fehler null");
//        }
//        if(o.getClass() != getClass()) {
//            throw new ClassCastException("Fehler falsche Klasse");
//        }
//        if (this.name.equals(name)) {
//            return 0;
//        } else {
//
//        }
    }

    @Override
    // Name: Anna, Geb.Jahr: 2001, Alter: 23, Eintr.Jahr: 2024, Dienstalter: 0, Gehalt: 1500.0
    public String toString() {
        return "Name: " + name +
                ", Geb.Jahr: " + gebJahr +
                ", Alter: " + berechneAlter() +
                ", Eintr.Jahr: " + eintrJahr +
                ", Dienstalter: " + berechneDienstalter() +
                ", Gehalt: " + berechneGehalt();
    }

    public void print() {
        System.out.println(this);
    }



















}
