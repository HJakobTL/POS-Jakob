package est.end;

import java.time.Year;
import java.util.Objects;

public class Luftmessstation extends Messstation {

    private double feinstaubGrenzwert;

    public Luftmessstation(String standort, Year installationsJahr, double messwert, double feinstaubGrenzwert) {
        super(standort, installationsJahr, messwert);
        setFeinstaubGrenzwert(feinstaubGrenzwert);
    }

    public double getFeinstaubGrenzwert() {
        return feinstaubGrenzwert;
    }

    public void setFeinstaubGrenzwert(double feinstaubGrenzwert) {
        if (feinstaubGrenzwert <= 0) throw new IllegalArgumentException("Muss größer 0 sein");
        this.feinstaubGrenzwert = feinstaubGrenzwert;
    }

    @Override
    public double berechneUmweltIndex() {
        return getMesswert() / getFeinstaubGrenzwert();
    }

    @Override
    public String getStationTyp() {
        return "Luftmessstation";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Luftmessstation that = (Luftmessstation) o;
        return Double.compare(feinstaubGrenzwert, that.feinstaubGrenzwert) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feinstaubGrenzwert);
    }

    @Override
    public String toString() {
        return super.toString() + ", Feinstaubgrenzwert: " + getFeinstaubGrenzwert();
    }
}
