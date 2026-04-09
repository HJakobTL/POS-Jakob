package est.end;

public class ProduktZertifikat extends UmweltZertifikat {

    private double materialAnteilRecyclet;
    private int lebensdauerJahre;

    public ProduktZertifikat(String id, String name, double co2ProJahr, double recycling, double materialAnteilRecyclet, int lebensdauerJahre) throws UmweltProjektException {
        super(id, name, co2ProJahr, recycling);
        setMaterialAnteilRecyclet(materialAnteilRecyclet);
        setLebensdauerJahre(lebensdauerJahre);
    }

    public double getMaterialAnteilRecyclet() {
        return materialAnteilRecyclet;
    }

    public void setMaterialAnteilRecyclet(double materialAnteilRecyclet) throws UmweltProjektException {
        if (materialAnteilRecyclet <= 0.0 || materialAnteilRecyclet > 100.0) throw new UmweltProjektException("Fehler: materialAnteil");
        this.materialAnteilRecyclet = materialAnteilRecyclet;
    }

    public int getLebensdauerJahre() {
        return lebensdauerJahre;
    }

    public void setLebensdauerJahre(int lebensdauerJahre) throws UmweltProjektException {
        if (lebensdauerJahre <= 0) throw new UmweltProjektException("Fehler: Lebensdauer");
        this.lebensdauerJahre = lebensdauerJahre;
    }

    @Override
    public double berechneNachhaltigkeitsScore() throws UmweltProjektException {
        if (this.lebensdauerJahre <= 0) throw new UmweltProjektException("Fehler: Score");
        return (getRecyclingQuote() + this.materialAnteilRecyclet) - (getCo2ProJahr()/this.lebensdauerJahre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProduktZertifikat ").append(super.toString()).append("\n");
        sb.append("Recycling Anteil ist ").append(materialAnteilRecyclet).append("%,")
                .append("Lebensdauer ist ").append(lebensdauerJahre).append(" Jahre");
        return sb.toString();
    }
}
