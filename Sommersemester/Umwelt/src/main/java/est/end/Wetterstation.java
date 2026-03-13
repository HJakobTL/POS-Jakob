package est.end;

import java.time.Year;
import java.util.Objects;

public class Wetterstation extends Messstation {

    private double temperatur;

    public Wetterstation(String standort, Year installationsJahr, double messwert,double temperatur) {
        super(standort, installationsJahr, messwert);
        setTemperatur(temperatur);
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        if (temperatur > 200 || temperatur < -200) throw new IllegalArgumentException("Muss zwischen -200 und 200 sein");
        this.temperatur = temperatur;
    }

    @Override
    public double berechneUmweltIndex() {
        if (getMesswert() > temperatur) {
            return getMesswert() + (temperatur * 0.5);
        }
        return getMesswert();
    }

    @Override
    public String getStationTyp() {
        return "Wetterstation";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wetterstation that = (Wetterstation) o;
        return Double.compare(temperatur, that.temperatur) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), temperatur);
    }

    @Override
    public String toString() {
        return super.toString() + ", Temperatur: " + getTemperatur();
    }
}
