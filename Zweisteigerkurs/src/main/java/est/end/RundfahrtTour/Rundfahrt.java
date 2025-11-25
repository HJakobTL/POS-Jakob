package est.end.RundfahrtTour;

public class Rundfahrt {
    private String name;
    private int etappenMenge = 50;
    private Etappe[] etappen;

    // Eine Rundfahrt
    public Rundfahrt(String name, int etappenMenge) {
        this.setName(name);
        this.setEtappen(etappenMenge);
    }

    // Die Setter
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name nicht null");
        }
        this.name = name;
    }

    public void setEtappen(int etappenMenge) {
        if (this.etappenMenge != etappenMenge || this.etappen == null){
            this.etappen = new Etappe[etappenMenge];
        }
        this.etappenMenge = etappenMenge;
    }

    // Die Hilfsfunktionen
    // Eine Etappe hinzufügen
    public boolean hinzufuegen(Etappe etappe) {
        if (etappe == null) {
            throw new IllegalArgumentException("Etappe nicht null");
        }
        if (etappen.length > 50){
            throw new IllegalArgumentException("Nein");
        }
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] == null) {
                etappen[i] = etappe;
                return true;
            }
        }
        return false;
    }

    // Eine Etappe wieder löschen
    public boolean annullieren(int pos){
        if (pos < 0){
            throw new IllegalArgumentException("Kann nicht kleiner 0 sein");
        }
        for (int i = 0; i < etappen.length; i++) {
            if (i == pos){
                etappen[i] = null;
                return true;
            }
        }
        return false;
    }

    // Gibt von jeder Etappe die es gibt, deren Infos zurück
    public String etappenUebersich(){
        String alleEtappen = "";
        for (int i = 0; i < etappen.length; i++){
            if (etappen[i] != null){
                etappen[i].setNummer(i+1);
                alleEtappen += etappen[i].toString();
            }
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
        int etappenAnzahl = 0;
        for (Etappe etappe: etappen){
            if (etappe != null){
                etappenAnzahl++;
            }
        }
        return berechneGesamtlaenge() / etappenAnzahl;
    }

    // Gibt die Längste Etappe zurück
    public float sucheLaengsteEtappe(){
        float rv = 0;
        for (int i = 0; i < newEt(etappen).length; i++) {
            rv = newEt(etappen)[i].getLaenge();
            for (int j = i+1; j < newEt(etappen).length; j++) {
                if (rv >  newEt(etappen)[j].getLaenge()){
                    rv = newEt(etappen)[j].getLaenge();
                }
            }
        }
        return rv;
    }


    // Gibt die Etappengewinne eines Fahrers zurück
    public int anzGewonnen(String fahrer){
        int siege = 0;
        for (int i = 0; i < etappen.length; i++){
            if (etappen[i] != null && etappen[i].getSieger().equals(fahrer)){
                siege++;
            }
        }
        return siege;
    }

    // Gibt die Anzahl der Validen Etappen (nicht platzhalter) zurück
    public int anzEtappen(){
        int gesEtappen = 0;
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] != null){
                gesEtappen++;
            }
        }
        return gesEtappen;
    }

    // Erstellt einen neuen Array mit allen Validen Etappen
    public Etappe[] newEt(Etappe[] etappen){
        Etappe[] newEt = new Etappe[anzEtappen()];
        for(int i = 0; i < etappen.length; i++){
            if (etappen[i] != null){
                newEt[i] = etappen[i];
            }
        }
        return newEt;
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
        int Minuten = x - (Stunden * 60);
        return Minuten;
    }

    // Berechnet die Gesamte Dauer in Stunden und Minuten
    public String berechneGesDauer(){
        int gesDauerStunden = 0;
        int gesDauerMinuten = 0;
        for (int i = 0; i < newEt(etappen).length ; i++) {
            gesDauerStunden += newEt(etappen)[i].getStunden();
            gesDauerMinuten += newEt(etappen)[i].getMinuten();
        }
        gesDauerStunden += MinZuStunden(gesDauerMinuten);
        gesDauerMinuten = RestMin(gesDauerMinuten);
        return gesDauerStunden + " Std," + gesDauerMinuten + " Minuten";
    }

    // Gibt alle Infos einer Rundfahrt zurück
    public String toString(){
        String InfoALl = "";
        InfoALl += name +
                "\nEtappen: " + anzEtappen() +
                "\nGesamte-Länge: " + berechneGesamtlaenge() + " km" +
                "\nGesamte-Dauer: " + berechneGesDauer() +
                "\nLängste-Etappe: " + sucheLaengsteEtappe() +
                "\nEtappen-Durschscnitt: " + berechneDurchschnittslaenge() +
                "\n" + etappenUebersich();

        return InfoALl;
    }
}