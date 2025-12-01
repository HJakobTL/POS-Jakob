package org.example.test;

public class Etappe {

    private int nummer;
    private float laenge;
    private String zielOrt;
    private String sieger;
    private int stunden;
    private int minuten;

    // Eine Ettape
    public Etappe(String zielOrt, float laenge, String sieger, int stunden, int minuten){
        this.setLaenge(laenge);
        this.setZielOrt(zielOrt);
        this.setSieger(sieger);
        this.setStunden(stunden);
        this.setMinuten(minuten);
    }

    // Die Setter
    public void setNummer(int nummer) {
        if (nummer <= 0){
            throw new IllegalArgumentException("Nummer ist ungültig ("+nummer+"), muss größer 0 sein");
        }
        this.nummer = nummer;
    }

    public void setLaenge(float laenge) {
        if (laenge <= 0){
            throw new IllegalArgumentException("Laenge ist ungültig ("+laenge+"), muss größer 0 sein");
        }
        this.laenge = laenge;
    }

    public void setZielOrt(String zielOrt) {
        if (zielOrt == null || zielOrt.isBlank()){
            throw new IllegalArgumentException("ZielOrt ist null oder leer");
        }
        this.zielOrt = zielOrt;
    }

    public void setSieger(String sieger) {
        if (sieger == null || sieger.isBlank()){
            throw new IllegalArgumentException("Sieger ist null oder leer");
        }
        this.sieger = sieger;
    }

    public void setStunden(int stunden) {
        if (stunden <= 0){
            throw new IllegalArgumentException("Stunden ist ungültig ("+stunden+"), muss größer 0 sein");
        }
        this.stunden = stunden;
    }

    public void setMinuten(int minuten) {
        if (minuten < 0 || minuten > 60){
            throw new IllegalArgumentException("Minuten ist ungültig ("+minuten+"), muss zwischen 0 und 60 sein");
        }
        this.minuten = minuten;
    }

    // Die Getter
    public int getNummer() {
        return nummer;
    }

    public float getLaenge() {
        return laenge;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    public String getSieger() {
        return sieger;
    }

    public int getStunden() {
        return stunden;
    }

    public int getMinuten() {
        return minuten;
    }

    // ToSring Methode

    @Override
    public String toString() {
        return  "Etappe " + nummer +
                ": Länge " + laenge +
                " km, Ziel-Ort " + zielOrt +
                ", Sieger " + sieger +
                ", Dauer " +  stunden +
                ":" + minuten + "\n";
    }
}
