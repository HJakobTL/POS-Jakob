package est.end;

public class MetallProbe extends Werkstoffprobe {

    private double zugfestigkeit;
    private double korrosionsWert;

    public MetallProbe(String id, String bezeichnung, double masse, double dichte, double zugfestigkeit, double korrosionsWert) throws WerkstoffException {
        super(id, bezeichnung, masse, dichte);
        setZugfestigkeit(zugfestigkeit);
        setKorrosionsWert(korrosionsWert);
    }

    public double getZugfestigkeit() {
        return zugfestigkeit;
    }

    public void setZugfestigkeit(double zugfestigkeit) throws WerkstoffException {
        if (zugfestigkeit < 0) throw new WerkstoffException("Error: Kleiner 0");
        this.zugfestigkeit = zugfestigkeit;
    }

    public double getKorrosionsWert() {
        return korrosionsWert;
    }

    public void setKorrosionsWert(double korrosionsWert) throws WerkstoffException {
        if (korrosionsWert < 0 || korrosionsWert > 100) throw new WerkstoffException("Error: Muss zwischen 0 und 100 sein");
        this.korrosionsWert = korrosionsWert;
    }

    @Override
    public double berechneQualitaetsIndex() {
        return zugfestigkeit / (korrosionsWert + 1);
    }

    @Override
    public String toString() {
        return "MetallProbe [" +
                super.toString() +
                ", Zugfestigkeit=" + zugfestigkeit + " MPa" +
                ", Korrosionswert=" + korrosionsWert +
                ", Qualitätsindex=" + berechneQualitaetsIndex() +
                "]";
    }
}
