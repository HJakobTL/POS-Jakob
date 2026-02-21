package est.end.Pegelstand;

import java.util.Arrays;

public class Pegelstand {

    private String fluss;
    private int[] werte;
    private int anzahl;

    // Konstruktoren
    public Pegelstand() {
        this.setFluss("Donau");
        this.werte = new int[7];
    }

    public Pegelstand(String fluss) {
        this.setFluss(fluss);
        this.werte = new int[7];
    }

    // Getter
    public String getFluss() {
        return fluss;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public int[] getWerte() {
        return werte;
    }

    // Setter
    public void setFluss(String fluss) {
        if (fluss != null && !fluss.isEmpty()) this.fluss = fluss;
        else throw new IllegalArgumentException("Fluss darf nicht null oder Empty sein");
    }

    // Funktionen
    public void ausgebenWerte(){
        for (int i = 0; i < werte.length; i++){
            System.out.println("[" + i + "]: " + werte[i]);
        }
    }

    public void fuellTestWerte(){
        werte = new int[] {250,290,310,310,300,300,300};
        anzahl = 7;
    }

    public float avgWwert(){
        float sum = 0f;
        if (anzahl == 0) return -99f;
        for (int i = 0; i < anzahl; i++) {
            sum += werte[i];
        }
        return sum/anzahl;
    }

    public int kleinsterWert(){
        int kWert = 0;
        if (anzahl == 0) return -99;
        if (anzahl > 0) {
             kWert = werte[0];
            for (int i = 0; i < anzahl; i++) {
                if (kWert > werte[i]) kWert = werte[i];
            }
        }
        return kWert;
    }

    public int maxIndex(){
        if (anzahl == 0) return -99;
        int maxWert = werte[0];
        int maxIndex = 0;
        for (int i = 0; i < anzahl; i++) {
            if (werte[i] > maxWert){
                maxWert = werte[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int getWert(int index){
        if (index < 0 || index >= werte.length) return -99;
        return werte[index];
    }

    public boolean messen(int wert) {
        if (wert < 0 || anzahl >= werte.length) {
            return false;
        }
        werte[anzahl] = wert;
        anzahl++;
        return true;
    }

    public boolean tauschen(int index1, int index2){
        if (index1 < 0 || index1 >= anzahl || index2 < 0 || index2 >= anzahl) {
            return false;
        }
        int tmp_Wert = werte[index1];
        werte[index1] = werte[index2];
        werte[index2] = tmp_Wert;
        return true;
    }

    public void entferneLetzenWert(){
        if (werte[anzahl-1] <= 0) throw new IllegalArgumentException("Platz ist schon 0 oder es gibt keine Messwerte");
        werte[anzahl-1] = 0;
        anzahl--;
    }

    public void loeschen(int index){
        if (index < 0 || index >= anzahl ) throw new IllegalArgumentException("Fehler: Hier gibt's nichts zu löschen (Index ist schon 0)");
        for (int i = 0; i < anzahl-1; i++) {
            werte[i] = werte[i+1];
        }
        if (werte[anzahl-1] != 0) {
            werte[anzahl-1] = 0;
            anzahl--;
        }
    }

    public int leeren(){
        int sum_entf_Werte = 0;
        for (int i = 0; i < werte.length; i++) {
            if (werte[i] != 0){
                werte[i] = 0;
                sum_entf_Werte++;
                anzahl--;
            }
        }
        return sum_entf_Werte;
    }

    public void einfuegen(int index, int wert){
        if (anzahl > 7) System.out.println("Kein Platz zum Einfügen");
        if (wert < 0) System.out.println("Wert ist ungültig");
        if (index < 0 || index > anzahl) System.out.println("Fehler: Index ist ungültig");
        for (int i = anzahl; i > index; i--) {
            werte[i] = werte[i-1];
        }
        werte[index] = wert;
        anzahl++;
    }

    public void sortiereWerte(){
        for (int i = 0; i < anzahl-1; i++) {
            for (int j = 0; j < anzahl-1-i; j++) if (werte[j] > werte[j + 1]) tauschen(j, j + 1);
        }
    }


    public int[] ueberschreibenAlle(int wert){
        if (wert < 0) throw new IllegalArgumentException("Wert darf nicht unter 0 sein");
        Arrays.fill(werte, wert);
        return werte;
    }

    public void printHoehenprofil(){
        StringBuilder sb = new StringBuilder();
        int laenge;
        if (anzahl > 0){
            for (int i = 0; i < anzahl; i++) {
                laenge = werte[i] / 10;
                sb.append("[").append(i).append("]: ");
                sb.append("~".repeat(Math.max(0, laenge)));
                sb.append(" (").append(werte[i]).append(" cm)\n");
            }
        }
        System.out.println(sb);
    }

    public void printPegelStand(){
        StringBuilder sb = new StringBuilder();
        sb.append(fluss).append("\n");
        if (anzahl > 0) {
            for (int i = 0; i < anzahl; i++){
                // concat Problem
                // System.out.println("[" + i + "]: " + werte[i] + " cm");
                sb.append("[").append(i).append("]: ").append(werte[i]).append(" cm \n");
            }
            sb.append("Anzahl: ").append(anzahl);
        }
        else sb.append("Keine Werte vorhanden");

        System.out.println(sb);
    }

    public String hohenprofilToString(char zeichen, int skalengroesse){
        StringBuilder sb = new StringBuilder();
        int laenge;
        if (anzahl > 0){
            for (int i = 0; i < anzahl; i++) {
                laenge = werte[i] / skalengroesse;
                sb.append("[").append(i).append("]: ");
                sb.append(String.valueOf(zeichen).repeat(Math.max(0, laenge)));
                sb.append(" (").append(werte[i]).append(" cm)\n");
            }
            sb.append("Ein ").append(zeichen).append(" entspricht ca. ").append(skalengroesse).append(" cm\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pegelstand: " + fluss +
                Arrays.toString(werte) +
                ", " + anzahl +
                " Messwerte";
    }
}
