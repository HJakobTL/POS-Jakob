package est.end;

import java.util.Iterator;
import java.util.LinkedList;

public class WerkstoffzentrumVerwaltung {

    private final LinkedList<Werkstoffprobe> proben;

    public WerkstoffzentrumVerwaltung() {
        this.proben = new LinkedList<Werkstoffprobe>();
    }

    public boolean addProbe(Werkstoffprobe probe) throws WerkstoffException {
        if (proben.contains(probe)) return false;
        return proben.add(probe);
    }

    public boolean removeProbeById(String id) throws WerkstoffException {
        if (proben.isEmpty()) throw new WerkstoffException("Fehler: Keine Proben vorhanden");
        Iterator<Werkstoffprobe> iterator = proben.iterator();
        while (iterator.hasNext()) {
            Werkstoffprobe we = iterator.next();
            if (we.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public int removeAllByTyp(String typName) throws WerkstoffException {
        if (proben.isEmpty()) throw new WerkstoffException("Fehler: Keine Proben vorhanden");
        int count = 0;
        Iterator<Werkstoffprobe> iterator = proben.iterator();
        while (iterator.hasNext()) {
            Werkstoffprobe we = iterator.next();
            if (we.getClass().getSimpleName().equals(typName)) {
                count++;
                iterator.remove();
            }
        }
        return count;
    }

    public int removeAllMitIndexUnter(double grenzwert) throws WerkstoffException {
        if (proben.isEmpty()) throw new WerkstoffException("Fehler: Keine Proben vorhanden");
        int count = 0;
        Iterator<Werkstoffprobe> iterator = proben.iterator();
        while (iterator.hasNext()) {
            Werkstoffprobe we = iterator.next();
            if (we.berechneQualitaetsIndex() < grenzwert) {
                count++;
                iterator.remove();
            }
        }
        return count;
    }

    public Werkstoffprobe findById(String id) throws WerkstoffException {
        if (id == null || id.isEmpty()) throw new WerkstoffException("Error: null oder leer");
        for (Werkstoffprobe we : proben) {
            if (we.getId().equals(id)) return we;
        }
        throw new WerkstoffException("Keine Probe gefunden");
    }

    public void sortierenNachQualitaetsIndex() {
        proben.sort(new WerkstoffQualitaetsIndexComparator());
    }
    public void sortierenStandard() {
        proben.sort(null);
    }

    private int findProbAnz(String typName) throws WerkstoffException {
        if (typName == null || typName.isEmpty()) throw new WerkstoffException("Fehler: null oder leer");
        int count = 0;
        for (Werkstoffprobe we : proben) {
            if (we.getClass().getSimpleName().equals(typName)) {
                count++;
            }
        }
        return count;
    }

    private double findAvgQualitaetsindex(String type) throws WerkstoffException {
        double sum = 0.0;
        int anz = 0;

        switch (type) {
            case "MetallProbe", "KeramikProbe", "PolymerProbe":
                for (Werkstoffprobe we : proben) {
                    if (we.getClass().getSimpleName().equals(type)) {
                        sum += we.berechneQualitaetsIndex();
                        anz++;
                    }
                } break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return sum / anz;
    }

    public void druckeStatistik() throws WerkstoffException {
        String line = "---------------------------------------";
        IO.println("------ Werkstoffzentrum Statistik ------");
        IO.println("Gesamtanzahl Proben: " + proben.size());
        IO.println("MetallProben: " + findProbAnz("MetallProbe"));
        IO.println("PolymerProben: " + findProbAnz("PolymerProbe"));
        IO.println("KeramikProben: " + findProbAnz("KeramikProbe"));
        IO.println(line);
        IO.println("Durchschnittlicher Qualitätsindex");
        IO.println("Metalle: " + findAvgQualitaetsindex("MetallProbe"));
        IO.println("Polymere: " + findAvgQualitaetsindex("PolymerProbe"));
        IO.println("Keramiken: " + findAvgQualitaetsindex("KeramikProbe"));
        IO.println(line);
    }
}
