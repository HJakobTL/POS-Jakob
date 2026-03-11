package est.end;

import java.time.Year;

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
        if (maxErlaubterPegel < 0) throw new IllegalArgumentException("Darf nicht kleiner 0 sein");
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
    public String toString() {
        return "Laermmessstation{" +
                "maxErlaubterPegel=" + maxErlaubterPegel +
                "} " + super.toString();
    }
}
