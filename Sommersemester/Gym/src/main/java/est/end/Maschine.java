package est.end;

import java.util.Objects;

public abstract class Maschine implements Comparable<Maschine> {

    private String name;
    private double preisEur;

    public Maschine(String name, double preisEur) {
        setName(name);
        setPreisEur(preisEur);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Error: null oder leer");
        this.name = name;
    }

    public double getPreisEur() {
        return preisEur;
    }

    public void setPreisEur(double preisEur) {
        if (preisEur < 0.0) throw new IllegalArgumentException("Error: Kleiner als 0");
        this.preisEur = preisEur;
    }

    public abstract int wartungsIntervall();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Maschine maschine = (Maschine) o;
        return Double.compare(preisEur, maschine.preisEur) == 0 && Objects.equals(name, maschine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preisEur);
    }

    @Override
    public int compareTo(Maschine o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + ", " + preisEur + " EUR";
    }
}
