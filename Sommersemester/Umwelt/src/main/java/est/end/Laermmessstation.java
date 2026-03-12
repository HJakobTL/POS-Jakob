package est.end;

import java.time.Year;
import java.util.Objects;

public class Laermmessstation extends Messstation {

    private double maxErlaubterPegel;

    public Laermmessstation(String standort, Year installationsJahr, double messwert, double maxErlaubterPegel) {
        super(standort, installationsJahr, messwert);
        setMaxErlaubterPegel(maxErlaubterPegel);
    }

    public double getMaxErlaubterPegel() {
        return maxErlaubterPegel;
    }

    public void setMaxErlaubterPegel(double maxErlaubterPegel) {
        if (maxErlaubterPegel <= 0) throw new IllegalArgumentException("Darf nicht kleiner 0 sein");
        this.maxErlaubterPegel = maxErlaubterPegel;
    }

    @Override
    public double berechneUmweltIndex() {
        return getMesswert() - getMaxErlaubterPegel();
    }

    @Override
    public String getStationTyp() {
        return "Laermmessstation";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laermmessstation that = (Laermmessstation) o;
        return Double.compare(maxErlaubterPegel, that.maxErlaubterPegel) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxErlaubterPegel);
    }

    @Override
    public String toString() {
        return "Laermmessstation{" +
                "maxErlaubterPegel=" + maxErlaubterPegel +
                "} " + super.toString();
    }
}
