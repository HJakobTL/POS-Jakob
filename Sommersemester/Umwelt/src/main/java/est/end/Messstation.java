package est.end;

import java.time.Year;
import java.time.temporal.TemporalAmount;

public abstract class Messstation {

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
        if (standort.isBlank()) throw new IllegalArgumentException("Fehler: Null");
        this.standort = standort;
    }

    public Year getInstallationsJahr() {
        return installationsJahr;
    }

    public void setInstallationsJahr(Year installationsJahr) {
        if (installationsJahr.isAfter(Year.of(1880))) throw new IllegalArgumentException("Darf nicht kleiner Jahr 1880 sein");
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

    public int compareTo(Messstation other) {
        return Double.compare(other.messwert,this.messwert);
    }

    @Override
    public String toString() {
        return "Messstation{" +
                "standort='" + standort + '\'' +
                ", installationsJahr=" + installationsJahr +
                ", messwert=" + messwert +
                ", stationsTyp=" + getStationTyp() +
                '}';
    }
}
