package est.end;

import java.time.Year;
import java.util.Objects;

public abstract class Messstation implements Comparable<Messstation>{

    private String standort;
    private Year installationsJahr;
    private double messwert;

    public Messstation(String standort, Year installationsJahr, double messwert) {
        setStandort(standort);
        setInstallationsJahr(installationsJahr);
        setMesswert(messwert);
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        if (standort == null || standort.isBlank()) throw new IllegalArgumentException("Fehler: Null");
        this.standort = standort;
    }

    public Year getInstallationsJahr() {
        return installationsJahr;
    }

    public void setInstallationsJahr(Year installationsJahr) {
        if (installationsJahr.isBefore(Year.of(1880))) throw new IllegalArgumentException("Darf nicht kleiner Jahr 1880 sein");
        this.installationsJahr = installationsJahr;
    }

    public double getMesswert() {
        return messwert;
    }

    public void setMesswert(double messwert) {
        if (messwert < 0) throw new IllegalArgumentException("Darf nicht kleinr 0 sein");
        this.messwert = messwert;
    }


    public abstract double berechneUmweltIndex();

    public abstract String getStationTyp();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Messstation that = (Messstation) o;
        return Double.compare(messwert, that.messwert) == 0 && Objects.equals(standort, that.standort) && Objects.equals(installationsJahr, that.installationsJahr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(standort, installationsJahr, messwert);
    }

    @Override
    public int compareTo(Messstation other) {
        return Double.compare(other.messwert,this.messwert);
    }

    @Override
    public String toString() {
        return "Messtation: " + "Standort: '" + standort + '\'' +
                ", Installationsjahr: " + installationsJahr +
                ", Messwert: " + messwert +
                ", Stationstyp: " + getClass().getSimpleName();
    }
}
