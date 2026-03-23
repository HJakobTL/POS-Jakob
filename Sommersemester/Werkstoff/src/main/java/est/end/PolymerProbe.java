package est.end;

public class PolymerProbe extends Werkstoffprobe{

    private double glassuerbergangsTemp;

    public PolymerProbe(String id, String bezeichnung, double masse, double dichte, double glassuerbergangsTemp) throws WerkstoffException {
        super(id, bezeichnung, masse, dichte);
        setGlassuerbergangsTemp(glassuerbergangsTemp);
    }

    public double getGlassuerbergangsTemp() {
        return glassuerbergangsTemp;
    }

    public void setGlassuerbergangsTemp(double glassuerbergangsTemp) throws WerkstoffException {
        if (glassuerbergangsTemp < -273) throw new WerkstoffException("Fehler: Muss groeßer -273 sein");
        this.glassuerbergangsTemp = glassuerbergangsTemp;
    }

    @Override
    public double berechneQualitaetsIndex() {
        return glassuerbergangsTemp * 0.1;
    }

    @Override
    public String toString() {
        return "PolymerProbe [" +
                super.toString() +
                ", Glasuebergangstemperatur=" + glassuerbergangsTemp + "°C" +
                ", Qualitätsindex=" + berechneQualitaetsIndex() +
                "]";
    }
}
