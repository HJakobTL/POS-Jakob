package est.end;

public class BetriebsZertifikat extends UmweltZertifikat{

    private int mitarbeiter;

    public BetriebsZertifikat(String id, String name, double co2ProJahr, double recycling, int mitarbeiter) throws UmweltProjektException {
        super(id, name, co2ProJahr, recycling);
        setMitarbeiter(mitarbeiter);
    }

    @Override
    public double berechneNachhaltigkeitsScore() throws UmweltProjektException {
        if (mitarbeiter <= 0) throw new UmweltProjektException("Fehler: Mitarbeiter");
        return (getRecyclingQuote() * 1.5) - (getCo2ProJahr()/this.mitarbeiter);
    }

    public int getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(int mitarbeiter) throws UmweltProjektException {
        if (mitarbeiter <= 0) throw new UmweltProjektException("Fehler: Mitarbeiter");
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BetriebsZertifikat ").append(super.toString()).append("\n");
        sb.append(mitarbeiter).append(" Mitarbeiter");
        return sb.toString();
    }
}
