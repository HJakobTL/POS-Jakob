package est.end.Vektoren;

import java.util.Arrays;

public class Vektor {

    private final int[] vektor;

    public Vektor(int len) {
        this.vektor = new int[len];
    }

    public int getVektorLen() {
        return vektor.length;
    }

    public void setVektor(int index, int wert) {
        if (index < 0 ) throw new IllegalArgumentException("Kann nicht kleiner 0 sein");
        this.vektor[index] = wert;
    }

    public boolean istGleichLang(Vektor a) {
        if (this.vektor.length != a.vektor.length) {
            throw new IllegalArgumentException("Vektoren müssen gleich lang sein");
        }
        return true;
    }

    public int multi(Vektor other) {
        this.istGleichLang(other);
        int erg = 0;
        for (int i = 0; i < other.getVektorLen(); i++) {
            erg += this.vektor[i] * other.vektor[i];
        }
        return erg;
    }

    public Vektor add(Vektor other) {
        Vektor erg = new Vektor(other.getVektorLen());
        for (int i = 0; i < other.getVektorLen(); i++) {
            erg.setVektor(i,this.vektor[i]*other.vektor[i]);
        }
        return erg;
    }

    @Override
    public String toString() {
        return "Vektor" + Arrays.toString(vektor);
    }
}
