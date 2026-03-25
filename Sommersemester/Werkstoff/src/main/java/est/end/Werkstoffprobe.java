package est.end;

import java.util.Objects;

public abstract class Werkstoffprobe implements Comparable<Werkstoffprobe>{

    private String id;
    private String bezeichnung;
    private double dichte;
    private double masse;

    public Werkstoffprobe(String id, String bezeichnung, double masse, double dichte) throws WerkstoffException {
        setId(id);
        setBezeichnung(bezeichnung);
        setMasse(masse);
        setDichte(dichte);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws WerkstoffException {
        if (id == null || id.isEmpty()) throw new WerkstoffException("Fehler: null oder leer");
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws WerkstoffException {
        if (bezeichnung == null || bezeichnung.isEmpty()) throw new WerkstoffException("Fehler: null oder leer");
        this.bezeichnung = bezeichnung;
    }

    public double getDichte() {
        return dichte;
    }

    public void setDichte(double dichte) throws WerkstoffException {
        if (dichte < 0) throw new WerkstoffException("Fehler: null oder leer");
        this.dichte = dichte;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) throws WerkstoffException {
        if (dichte < 0) throw new WerkstoffException("Fehler: null oder leer");
        this.masse = masse;
    }

    public double berechneVolumen() {
        return masse / dichte;
    }

    public double berechneMaterialWert() {
        return masse * dichte;
    }

    public abstract double berechneQualitaetsIndex();

    public int compareTo(Werkstoffprobe other) {
        if (this.bezeichnung.equals(other.bezeichnung)) {
            return this.id.compareTo(other.id);
        }
        return this.bezeichnung.compareTo(other.bezeichnung);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Werkstoffprobe that = (Werkstoffprobe) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return  "ID=" + id +
                ", Bezeichnung=" + bezeichnung +
                ", Dichte=" + dichte + " g/cm³" +
                ", Masse=" + masse + " kg" +
                ", Volumen=" + berechneVolumen() +
                ", Materialwert=" + berechneMaterialWert();
    }
}
