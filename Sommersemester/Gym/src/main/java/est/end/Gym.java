package est.end;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gym {

    private double maxPreisEur;
    private int maxAnzahl;
    private final List<Maschine> maschinen;

    public Gym(double maxPreisEur, int maxAnzahl) {
        setMaxPreisEur(maxPreisEur);
        setMaxAnzahl(maxAnzahl);
        maschinen = new ArrayList<>();
    }

    public double getMaxPreisEur() {
        return maxPreisEur;
    }

    public void setMaxPreisEur(double maxPreisEur) {
        if (maxPreisEur < 0 || maxPreisEur > 9000) throw new IllegalArgumentException("Error: zwischen 0 und 9000");
        this.maxPreisEur = maxPreisEur;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    public void setMaxAnzahl(int maxAnzahl) {
        if (maxAnzahl < 5 || maxAnzahl > 100) throw new IllegalArgumentException("Error: Muss zwischen 5 und 100 sein");
        this.maxAnzahl = maxAnzahl;
    }

    public boolean aufstellen(Maschine maschine) {
        if (maxPreisEur < maschine.getPreisEur()) return false;
        if (maxAnzahl <= maschinen.size()) return false;
        if (maschinen.contains(maschine)) return false;
        return maschinen.add(maschine);
    }

    public double berechneAvgPreisMaschinen() {
        if (maschinen.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Maschine maschine : maschinen) {
            sum += maschine.getPreisEur();
        }
        return sum / maschinen.size();
    }

    public void sortieren() {
        maschinen.sort(null);
    }

    public void sortierenPreisEur() {
        maschinen.sort(new PreisComparator());
    }

    public int entfernenAlle(char typ) {
        if (maschinen.isEmpty()) return -99;
        int count = 0;
        Iterator<Maschine> iterator = maschinen.iterator();
        while (iterator.hasNext()) {
            Maschine ma = iterator.next();
            if ((typ == 'b' || typ == 'B') && ma instanceof Beinpresse) {
                count++;
                iterator.remove();
            }
            if ((typ == 'e' || typ == 'E') && ma instanceof Ergometer) {
                count++;
                iterator.remove();
            }
        }
        return count;
    }

    public boolean entfernen(Maschine maschine) {
        if (maschinen.isEmpty() || !maschinen.contains(maschine)) return false;
        return maschinen.remove(maschine);
    }

    public int maxWartungsIntervall() {
        if (maschinen.isEmpty()) return -99;
        int maxWartungsIntervall = 0;
        for (Maschine ma : maschinen) {
            if (ma.wartungsIntervall() > maxWartungsIntervall) maxWartungsIntervall = ma.wartungsIntervall();
        }
        return maxWartungsIntervall;
    }

    @Override
    public String toString() {
        StringBuilder ausgabe = new StringBuilder("=== Fitnesscenter Übersicht ===\n");
        ausgabe.append("Maximalpreis pro Gerät: ").append(maxPreisEur).append(" EUR\n");
        ausgabe.append("Maximale Geräteanzahl: ").append(maxAnzahl).append("\n");
        ausgabe.append("Aktuell aufgestellt: ").append(maschinen.size()).append(" Maschinen\n");
        ausgabe.append("Geräteliste:\n");

        if (maschinen.isEmpty()) {
            ausgabe.append(" -> Das Gym ist aktuell leer.");
        } else {
            for (Maschine m : maschinen) {
                ausgabe.append(" - ").append(m.toString()).append("\n");
            }
        }

        return ausgabe.toString();
    }
}
