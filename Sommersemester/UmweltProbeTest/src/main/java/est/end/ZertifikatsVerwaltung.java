package est.end;

import java.util.ArrayList;
import java.util.List;

public class ZertifikatsVerwaltung  {

    private final List<UmweltZertifikat> zertifikate;

    public ZertifikatsVerwaltung() {
        zertifikate = new ArrayList<>();
    }

    public void addZertifikat(UmweltZertifikat z) throws UmweltProjektException {
        if (z == null) throw new UmweltProjektException("Fehler: add");
        zertifikate.add(z);
    }

    public void druckeAlle() {
        if (zertifikate.isEmpty()) System.out.println("Keine Zertifikate vorhanden");
        for (UmweltZertifikat z : zertifikate) {
            System.out.println(z);
        }
    }

    public void druckeScoreListe() {
        for (UmweltZertifikat z : zertifikate) {
            try {
                System.out.println(z.getId() + " | " + z.getName() + " | Score: " + z.berechneNachhaltigkeitsScore());
            } catch (UmweltProjektException e) {
                System.out.println(z.getId() + "Fehler: Recyclingquote außerhalb von 0–100");
            }
        }
    }

    public void druckeCO2EffizienzListe(double maxErlaubterCO2) {
        for (UmweltZertifikat z : zertifikate) {
            try {
                System.out.println(z.getId() + " | " + z.getName() + " | CO2-Effizienz: " + z.berechneCO2Effizienz(maxErlaubterCO2));
            } catch (UmweltProjektException e) {
                System.out.println("Fehler bei Zertifikat " + z.getId() + ": Der maximale CO2-Wert muss größer als 0 sein");
            }
        }
    }

    public UmweltZertifikat findeMitId(String id) throws UmweltProjektException {
        if (id == null || id.isEmpty()) throw new UmweltProjektException("Fehler id");
        for (UmweltZertifikat z : zertifikate) {
            if (z.getId().equals(id)) {
                return z;
            }
        }
        throw new UmweltProjektException("Kein UmweltZertifikat gefunden");
    }

    public List<UmweltZertifikat> listeTopNachhaltigkeitsScore() throws UmweltProjektException {
        if (zertifikate.size() < 10) throw new UmweltProjektException("Zu wenige Zeritfikate Vorhanden");
        zertifikate.sort(null);
        zertifikate.reversed();
        int anzahlTop10Prozent = zertifikate.size() / 10;
        ArrayList<UmweltZertifikat> topList = new ArrayList<>();
        for (int i = 0; i < anzahlTop10Prozent; i++) {
            topList.add(zertifikate.get(i));
        }
        return topList;
    }

    public List<UmweltZertifikat> listeFlopNachhaltigkeitsScore() throws UmweltProjektException {
        if (zertifikate.size() < 10) throw new UmweltProjektException("Zu wenige Zeritfikate Vorhanden");
        zertifikate.sort(null);
        int anzahlFlop10Prozent = zertifikate.size() / 10;
        ArrayList<UmweltZertifikat> flopList = new ArrayList<>();
        for (int i = 0; i < anzahlFlop10Prozent; i++) {
            flopList.add(zertifikate.get(i));
        }
        return flopList;
    }

}
