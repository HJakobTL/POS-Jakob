package est.end;

import java.time.Year;

public class Mitarbeiter {

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

    public double berechneGehalt() {
        int anzJahre = dienstAlter();
        int fixGehalt = 1500;
        return fixGehalt + (50*anzJahre);
    }

    public double berechnePraemie() {
        double praemie = 0;
        if (this.dienstAlter() >= 15 && this.dienstAlter() < 20) praemie = 1;
        if (this.dienstAlter() >= 20 && this.dienstAlter() < 25) praemie = 2;
        if (this.dienstAlter() >= 25 && this.dienstAlter() < 50) praemie = 3;
        if (this.dienstAlter() > 50) praemie = 6;
        return praemie * 1500;
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
