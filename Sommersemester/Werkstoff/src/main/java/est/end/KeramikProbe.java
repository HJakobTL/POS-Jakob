package est.end;

public class KeramikProbe extends Werkstoffprobe {

    public KeramikProbe(String id, String bezeichnung, double masse, double dichte) throws WerkstoffException {
        super(id, bezeichnung, masse, dichte);
    }

    @Override
    public double berechneQualitaetsIndex() {
        return getDichte() * 2;
    }

    @Override
    public String toString() {
        return "KeramikProbe[ " + super.toString() +
                ", Qualitätsindex=" + berechneQualitaetsIndex() +
                "]";
    }
}
