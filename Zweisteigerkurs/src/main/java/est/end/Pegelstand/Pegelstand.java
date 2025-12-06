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

    public float kleinsterWert(){
        if (anzahl == 0) return -99f;
        float kWert = werte[0];
        for (int i = 0; i < anzahl; i++) {
            if (kWert > werte[i]) kWert = werte[i];
        }
        return kWert;
    }

    public int maxIndex(){
        if (anzahl == 0) return -99;
        float maxWert = werte[0];
        int maxIndex = 0;
        for (int i = 0; i < anzahl; i++) {
            if (werte[i] > maxWert){
                maxWert = werte[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void printPegelStand(){
        StringBuilder sb = new StringBuilder();
        sb.append(fluss).append("\n");
        if (anzahl > 0) {
            for (int i = 0; i < werte.length; i++){
                // concat Problem
                // System.out.println("[" + i + "]: " + werte[i] + " cm");
                sb.append("[").append(i).append("]: ").append(werte[i]).append(" cm \n");
            }
            sb.append("Anzahl: ").append(anzahl);
        }
        else sb.append("Keine Werte vorhanden");

        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pegelstand: ");
        sb.append(fluss);
        sb.append(Arrays.toString(werte));
        sb.append(", ").append(anzahl);
        sb.append(" Messwerte");
        return sb.toString();
    }
}
