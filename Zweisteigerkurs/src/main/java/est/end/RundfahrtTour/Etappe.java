package est.end.RundfahrtTour;

public class Etappe {

    private int nummer;
    private float laenge;
    private String zielOrt;
    private String sieger;
    private int stunden;
    private int minuten;

    // Eine Ettape
    public Etappe(float laenge, String zielOrt, String sieger, int stunden, int minuten){
        this.setLaenge(laenge);
        this.setZielOrt(zielOrt);
        this.setSieger(sieger);
        this.setStunden(stunden);
        this.setMinuten(minuten);
    }

    // Die Setter
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
    public void setLaenge(float laenge) {
        this.laenge = laenge;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public void setSieger(String sieger) {
        this.sieger = sieger;
    }

    public void setStunden(int stunden) {
        this.stunden = stunden;
    }

    public void setMinuten(int minuten) {
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

    public String toString() {
        return "Etappe: " + this.nummer + " Länge " + this.laenge + "km, " +
        "Ziel-Ort " + this.zielOrt + ", " + "Sieger " + this.sieger + ", " +
                "Dauer " + this.stunden + ":" + this.minuten + "\n";
    }
}
