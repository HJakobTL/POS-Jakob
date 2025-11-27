package est.end.RundfahrtTour;

public class Rundfahrt {
    private String name;
    private int etappenMax = 50;
    private Etappe[] etappen;

    // Eine Rundfahrt
    public Rundfahrt(String name) {
        this.setName(name);
        this.etappen = new Etappe[etappenMax];
    }

    // Die Setter
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name nicht null");
        }
        this.name = name;
    }

    // Die Hilfsfunktionen
    // Eine Etappe hinzufügen
    public boolean hinzufuegen(Etappe etappe) {
        if (etappe == null) throw new IllegalArgumentException("Etappe nicht null");
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] == etappe) throw new IllegalArgumentException("Etappe schon eingetragen");
            if (etappen[i] == null) {
                etappen[i] = etappe;
                etappen[i].setNummer(i + 1);
                return true;
            }

        }
        throw new IllegalArgumentException("Maximal " + etappenMax + " etappen");
    }

    // Eine Etappe wieder löschen
    public boolean annullieren(int pos){
        if (pos < 0){
            throw new IllegalArgumentException("Kann nicht kleiner 0 sein");
        }
        for (int i = 0; i < etappen.length; i++) {
            if (i == pos-1){
                if (etappen[i] == null) throw new IllegalArgumentException("Keine Etappe hier");
                etappen[i] = null;
                return true;
            }
        }
        return false;
    }

    // Gibt von jeder Etappe die es gibt, deren Infos zurück
    public String etappenUebersich(){
        String alleEtappen = "";
        for (Etappe etappe : etappen) {
            if (etappe != null) alleEtappen += etappe;
        }
        return alleEtappen;
    }

    // Berechnet die Gesamte Strecke der Rundfahrt
    public float berechneGesamtlaenge(){
        float gesLaenge = 0;
        for (Etappe etappe: etappen){
            if (etappe != null){
                gesLaenge += etappe.getLaenge();
            }
        }
        return gesLaenge;
    }

    // Berechnet die Durschschnittlische Länge aller Etappen
    public float berechneDurchschnittslaenge(){
        return berechneGesamtlaenge() / anzEtappen();
    }

    // Gibt die Längste Etappe zurück
    public float sucheLaengsteEtappe(){
        float rv = 0;
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] != null) rv = etappen[i].getLaenge();
            for (int j = i+1; j < etappen.length; j++) {
                if (etappen[j] != null && rv >  etappen[j].getLaenge())
                    rv = etappen[j].getLaenge();
            }
        }
        return rv;
    }

    // Gibt die Etappengewinne eines Fahrers zurück
    public int anzGewonnen(String fahrer){
        int siege = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null && etappe.getSieger().equals(fahrer)) {
                siege++;
            }
        }
        return siege;
    }

    // Gibt die Anzahl der Validen Etappen (nicht null) zurück
    public int anzEtappen(){
        int gesEtappen = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null) {
                gesEtappen++;
            }
        }
        return gesEtappen;
    }

    // Um die Summe der Minuten in Stunden umzurechnen
    public int MinZuStunden(int x){
        int Stunden = 0;
        if(x >= 60){
            Stunden = x / 60;
        }
        return Stunden;
    }
    // Um die Restlichen Minuten noch zu bekommen
    public int RestMin(int x){
        int Stunden = 0;
        if (x >= 60){
            Stunden = x / 60;
        }
        return x - (Stunden * 60);
    }

    // Berechnet die Gesamte Dauer in Stunden und Minuten
    public String berechneGesDauer(){
        int gesDauerStunden = 0;
        int gesDauerMinuten = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null) {
                gesDauerStunden += etappe.getStunden();
                gesDauerMinuten += etappe.getMinuten();
            }
        }
        gesDauerStunden += MinZuStunden(gesDauerMinuten);
        gesDauerMinuten = RestMin(gesDauerMinuten);
        return gesDauerStunden + " Std," + gesDauerMinuten + " Minuten";
    }

    // Gibt alle Infos einer Rundfahrt zurück
    public String toString(){
        return name +
                "\nEtappen: " + anzEtappen() +
                "\nGesamte-Länge: " + berechneGesamtlaenge() + " km" +
                "\nGesamte-Dauer: " + berechneGesDauer() +
                "\nLängste-Etappe: " + sucheLaengsteEtappe() +
                "\nEtappen-Durschscnitt: " + berechneDurchschnittslaenge() +
                "\n" + etappenUebersich();
    }
}