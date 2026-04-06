package est.end;

public class Speise {

    private String bez;
    private int kCal;
    private double preis;
    private char art;
    private boolean veg;

    public Speise(String bez, int kCal, boolean veg, double preis, char art) {
        setBez(bez);
        setkCal(kCal);
        setVeg(veg);
        setPreis(preis);
        setArt(art);
    }

    public Speise() {
        setBez("Nudelsuppe");
        setkCal(250);
        setPreis(3.5);
        setArt('v');
        setVeg(true);
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        if (bez == null || bez.length() < 2 || bez.isBlank()) throw new IllegalArgumentException("Fehler: leer oder null oder kleiner 2");
        this.bez = bez.substring(0,1).toUpperCase() + bez.substring(1);
    }

    public int getkCal() {
        return kCal;
    }

    public void setkCal(int kCal) {
        if (kCal < 1 || kCal > 3000) throw new IllegalArgumentException("Fehler: muss zwischen 0 und 3000 sein");
        this.kCal = kCal;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if (preis < 1.5 || preis > 500) throw new IllegalArgumentException("Fehler: muss zwichen 1.5 und 500 sein");
        this.preis = preis;
    }

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public char getArt() {
        return art;
    }

    public void setArt(char art) {
        char[] allowed = new char[]{'V','H','N'};
        art =  Character.toLowerCase(art);
        boolean charYes = true;
        for (char i : allowed) {
            if (Character.toLowerCase(i) == art) charYes = false;
        }
        if (charYes) throw new IllegalArgumentException("Fehler: Char muss v,h,n sein!");
        this.art = art;
    }


    public int kCalKleinePortion() {
        return (int) Math.ceil((double) getkCal() /2);
    }

    public boolean istVorspeise() {
        if (getArt() != 'v') return false;
        return true;
    }

    public Speise alsVorspeise() {
        if (istVorspeise()) return this;
        return new Speise(getBez() + " Als Vorspeise",kCalKleinePortion(), this.isVeg(), this.getPreis()-1, 'v');
    }

    public Speise alsVeganeSpeise(int kCal, double preis) {
        if (preis < 1.5 || preis > 500) throw new IllegalArgumentException("Fehler: muss zwichen 1.5 und 500 sein");
        if (kCal < 1 || kCal > 3000) throw new IllegalArgumentException("Fehler: muss zwischen 0 und 3000 sein");
        String newBez = getBez();
        if (this.istVeganeSpeise()) newBez += " (vegan)" ;
        return new Speise(newBez, kCal, true, preis, this.art);
    }

    public boolean istVeganeSpeise() {
        return true;
    }

    public Speise veganePalatschinke() {
        return new Speise("Palatschinke (vegan)",500,true,8.5,'h');
    }


    @Override
    public String toString() {
        return "Speise{" +
                "bez='" + bez + '\'' +
                ", kCal=" + kCal +
                ", preis=" + preis +
                ", art=" + art +
                ", veg=" + veg +
                '}';
    }
}
