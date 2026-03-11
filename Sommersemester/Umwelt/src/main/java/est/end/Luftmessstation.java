package est.end;

import java.time.Year;

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
        if (feinstaubGrenzwert < 0) throw new IllegalArgumentException("Muss größer 0 sein");
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
    public String toString() {
        return "Luftmessstation{" +
                "feinstaubGrenzwert=" + feinstaubGrenzwert +
                "} " + super.toString();
    }
}
